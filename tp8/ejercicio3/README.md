# Ejercicio 3 — Mecanismos de Randoop para escenarios como el del ejercicio 2

En `fileExample.checkContent()` hay varias dependencias externas que dificultan la generación automática de tests significativos:

1. Entrada por `System.in`.
2. Lectura de archivos reales del filesystem.
3. Dependencia de la fecha y el locale del sistema.
4. Efecto lateral: cerrar el scanner de consola también cierra `System.in`, lo que altera el estado global.

Con la configuración por defecto, Randoop rara vez logra casos útiles en este tipo de clases: su exploración aleatoria no puede fabricar el contexto mínimo para alcanzar los caminos interesantes.

## Mecanismos de Randoop para mejorar la generación

Randoop tiene un conjunto de opciones pensadas justamente para estas dificultades.

### 1) Setup / teardown inyectado en los tests

```
--junit-before-each
--junit-after-each
--junit-before-all
--junit-after-all
```

Recrea `System.in`, crear un archivo temporal controlado, cargar el contenido esperado, y limpiar el estado al finalizar cada test.

### 2) Fijar propiedades del sistema (reproducibilidad)

```
--system-props
```

Permite fijar `user.language`, `user.country`, `user.timezone` para estabilizar el formato de fecha y quitarle ese grado de libertad a los tests.

### 3) Inyectar literales relevantes

```
--literals-file
--literals-level
```

Para que Randoop elija valores útiles (cadenas, rutas, identificadores) en lugar de basarse solo en literales inferidos del código.

### 4) Filtrar métodos bajo prueba

```
--methodlist
--omitmethods
```

Concentran la generación en las APIs relevantes y evitan ruido o bloqueos por métodos que no aportan cobertura.

### 5) Ajustar la clasificación de excepciones

```
--checked-exception
--unchecked-exception
--npe-on-null-input
--npe-on-non-null-input
```

Cambian cómo se clasifica cada caso generado: como `ErrorTest`, como `RegressionTest`, o como secuencia inválida.

### 6) Controlar presupuesto y tamaño de la suite

```
--timelimit
--inputlimit
--outputlimit
--maxsize
--small-tests
```

Para priorizar tests legibles y evitar que la suite quede demasiado grande para mantener.

### 7) Manejo de bloqueos y timeouts

```
--usethreads
--timeout
```

Claves cuando algún camino puede quedar esperando entrada indefinidamente, como pasa con `System.in`.

### 8) Captura de salida de consola

```
--capture-output
```

Reduce el ruido cuando el código bajo prueba imprime por `stdout` / `stderr`.

### 9) Contratos extra con `@CheckRep`

```
@randoop.CheckRep
```

Randoop evalúa el método anotado como invariante durante la generación de tests.

## Aplicación práctica a `fileExample`

Para este caso, la estrategia recomendada:

1. `--junit-before-each` para setear `System.in` y preparar un archivo temporal.
2. `--junit-after-each` para restaurar el estado.
3. Fijar locale y timezone con `--system-props`.
4. Acotar la suite con `--small-tests`, `--maxsize` y `--outputlimit`.
5. Configurar un `--timeout` por test para cortar bloqueos derivados de la lectura de `stdin`.

Comando:

```bash
java -classpath target/classes:libs/randoop-all-3.0.8.jar randoop.main.Main gentests \
  --testclass=assignment8_exercises.fileContents.fileExample \
  --timelimit=60 \
  --small-tests=true \
  --maxsize=40 \
  --outputlimit=300 \
  --junit-output-dir=src/test/java \
  --junit-package-name=assignment8_exercises.fileContents \
  --junit-before-each=src/test/resources/randoop/beforeEach.txt \
  --junit-after-each=src/test/resources/randoop/afterEach.txt \
  --system-props=user.language=en \
  --system-props=user.country=US \
  --system-props=user.timezone=UTC \
  --capture-output=true \
  --usethreads=true \
  --timeout=2000
```

Con la configuración por defecto, Randoop no rinde bien sobre código fuertemente acoplado al entorno. Combinando hooks de setup/teardown, fijación de propiedades del sistema y control del presupuesto, la utilidad y la estabilidad de los tests generados mejoran de forma clara y se aprovecha mucho mejor el tiempo de exploración.

## Enlaces

- Enunciado: [`practico8.pdf`](/pdfs/tp8/practico8.pdf)
- Resolución: [`resolucion_practico8.pdf`](/pdfs/tp8/resolucion_practico8.pdf)
