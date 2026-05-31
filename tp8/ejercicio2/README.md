# Ejercicio 2 — `fileExample` con Randoop y EvoSuite

## La clase

`assignment8_exercises.fileContents.fileExample` expone una sola operación (`checkContent`) con varias dependencias fuertes con el entorno de ejecución:

1. Lee un nombre de archivo desde `System.in`.
2. Cierra el `Scanner` asociado a consola — lo que también cierra `System.in`.
3. Si el archivo no existe, retorna `false`.
4. Si existe, lee la primera línea del archivo.
5. La compara con la fecha actual formateada con `DateFormat.SHORT`.

Cualquier test queda expuesto a fuentes de no determinismo:

- entrada estándar,
- sistema de archivos,
- fecha del sistema,
- locale y formato.

Es justo lo que hace interesante la comparación entre Randoop y EvoSuite.

## Randoop

```bash
./gen-randoop.sh assignment8_exercises.fileContents.fileExample 25 300 200
```

Salida:

- Se generó `RegressionTest0` con un único test.
- No se produjo `ErrorTest`.
- El test verifica la `NoSuchElementException` que se lanza cuando no hay datos en `System.in`.

Ejecución (con `< /dev/null` para evitar que el test se bloquee esperando entrada):

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
    mvn -q -Djacoco.skip=true -DforkCount=0 \
    -Dtest=assignment8_exercises.fileContents.RegressionTest test < /dev/null
```

Resultado: 1 test, 0 fallos.

**Interpretación**: Randoop explora muy poco de la clase porque su API pública exige IO real y estado externo para llegar a los caminos relevantes. Sin ese soporte, la generación aleatoria queda en el caso trivial.

## EvoSuite

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
    ./gen-evo.sh assignment8_exercises.fileContents.fileExample 20
```

Salida:

- `fileExample_ESTest` (suite principal) con 3 tests.
- `fileExample_Failed_ESTest` con los casos correspondientes a violaciones o errores detectados.

**Métricas reportadas por EvoSuite** durante la generación:

- Cobertura promedio: 60 %
- Line: 53 %
- Branch: 60 %
- Weak mutation: 10 %

Además detectó excepciones no declaradas en la suite `Failed` (por ejemplo, `No line found`), consistente con un `Scanner.nextLine()` que no valida disponibilidad previa.

Cuando intenté ejecutar `fileExample_ESTest` en el entorno:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
    mvn -q -Djacoco.skip=true -DforkCount=0 \
    -Dtest=assignment8_exercises.fileContents.fileExample_ESTest test
```

Los tests se generan correctamente, pero fallan al inicializar el runner de EvoSuite porque no encuentra `tools.jar`. El runtime que usa la suite de EvoSuite está pensado para un JDK 8 con infraestructura histórica; sobre JDK 11+ no llega a inicializarse. Por eso la comparación se hace sobre las métricas reportadas por EvoSuite en la generación.

## Comparación

| | Randoop | EvoSuite |
|---|---|---|
| Velocidad | rápido | más lento |
| Casos generados | 1 (trivial) | 3 + suite `Failed` |
| `ErrorTest` | no produjo | sí (excepciones no declaradas) |
| Cobertura | baja | branch 60 %, line 53 % |
| Entorno requerido | JDK 17, simple | JDK 11 (runtime histórico) |

Ninguno reemplaza al otro: cada uno muestra un trade-off distinto entre profundidad de exploración y facilidad de integración. Para `fileExample`, EvoSuite fue más expresivo en la generación, mientras que Randoop fue más práctico de ejecutar.

## Archivos

- [`fileExample.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/main/java/assignment8_exercises/fileContents/fileExample.java)
- [`RegressionTest0.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/fileContents/RegressionTest0.java) — generado por Randoop.
- [`fileExample_ESTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/fileContents/fileExample_ESTest.java) — generado por EvoSuite.
- [`fileExample_Failed_ESTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp8/assignment-8-rodeghiero/src/test/java/assignment8_exercises/fileContents/fileExample_Failed_ESTest.java) — suite Failed con excepciones no declaradas.

## Enlaces

- Resolución: [`resolucion_practico8.pdf`](/pdfs/tp8/resolucion_practico8.pdf)
