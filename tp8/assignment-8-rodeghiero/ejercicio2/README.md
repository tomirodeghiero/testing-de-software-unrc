# Ejercicio 2 - Análisis de `fileExample` con Randoop y EvoSuite

## Análisis rápido del código

La clase `assignment8_exercises.fileContents.fileExample` expone una única operación (`checkContent`) que concentra varias dependencias fuertes con el entorno de ejecución. Su flujo es:

1. Lee un nombre de archivo desde `System.in`.
2. Cierra el `Scanner` asociado a consola, lo que también cierra `System.in`.
3. Si el archivo no existe, retorna `false`.
4. Si existe, lee la primera línea del archivo.
5. Compara esa línea con la fecha actual formateada con `DateFormat.SHORT`.

Como consecuencia, cualquier test generado queda expuesto a varias fuentes de no determinismo:

- entrada estándar,
- sistema de archivos,
- fecha del sistema,
- locale y formato de fecha.

Este contexto es el que hace interesante comparar el comportamiento de Randoop y EvoSuite sobre la clase.

## Resultado con Randoop

Comando de generación:

```bash
./gen-randoop.sh assignment8_exercises.fileContents.fileExample 25 300 200
```

Salida obtenida:

- Se generó `RegressionTest0` con un único test.
- No se produjo `ErrorTest`.
- El test verifica la `NoSuchElementException` que se lanza cuando no hay datos disponibles en `System.in`.

Ejecución, evitando que el test se bloquee esperando entrada estándar:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
mvn -q -Djacoco.skip=true -DforkCount=0 \
-Dtest=assignment8_exercises.fileContents.RegressionTest test < /dev/null
```

Resultado:

- 1 test ejecutado
- 0 fallos
- 0 errores

Interpretación: Randoop explora muy poco comportamiento funcional de esta clase porque su API pública exige IO real y estado externo para alcanzar los caminos relevantes. Sin ese soporte, la generación aleatoria queda atrapada en el caso trivial.

## Resultado con EvoSuite

Comando de generación:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
./gen-evo.sh assignment8_exercises.fileContents.fileExample 20
```

Salida obtenida:

- `fileExample_ESTest` (suite principal) con 3 tests.
- `fileExample_Failed_ESTest` con los casos correspondientes a violaciones o errores detectados.

Cobertura reportada por EvoSuite durante la generación:

- Cobertura promedio: 60%
- Line: 53%
- Branch: 60%
- Weak mutation: 10%

También se detectaron excepciones no declaradas en la suite `Failed` (por ejemplo, `No line found`), lo cual es consistente con un `Scanner.nextLine()` que no valida disponibilidad previa.

Ejecución de `fileExample_ESTest` en este entorno:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
mvn -q -Djacoco.skip=true -DforkCount=0 \
-Dtest=assignment8_exercises.fileContents.fileExample_ESTest test
```

Resultado: los tests se generan correctamente, pero fallan al inicializar el runner de EvoSuite porque no encuentra `tools.jar`.

Interpretación: el runtime que usa la suite de EvoSuite está pensado para un JDK 8 con infraestructura histórica; sobre JDK 11 o superior no llega a inicializarse. Por eso la comparación se hace sobre las métricas reportadas por EvoSuite en la fase de generación.

## Comparación Randoop vs EvoSuite

- **Randoop**:
  - Muy rápido y simple de poner en marcha.
  - Para esta clase solo generó un escenario trivial.
  - No produjo `ErrorTest`.
- **EvoSuite**:
  - Generó más casos y detectó violaciones de excepciones no declaradas.
  - Requiere un entorno más específico para ejecutarse, idealmente compatible con el runtime histórico pensado para JDK 8.

Conclusión: para `fileExample`, EvoSuite resultó más expresivo en la generación, mientras que Randoop fue más práctico de ejecutar en este entorno. Ninguno reemplaza al otro; cada uno ilustra un trade-off distinto entre profundidad de exploración y facilidad de integración.
