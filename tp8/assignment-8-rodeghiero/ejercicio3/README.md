# Ejercicio 3 - Mecanismos de Randoop para mejorar escenarios como el Ejercicio 2

## Problema base del escenario

En `fileExample.checkContent()` hay dependencias externas que dificultan la generacion automatica de tests:

1. Entrada por `System.in`.
2. Lectura de archivos reales.
3. Dependencia de fecha/locale del sistema.
4. Efecto lateral al cerrar scanner de consola (`System.in` queda cerrado).

Con configuración básica, Randoop suele generar pocos casos utiles.

## Mecanismos concretos de mejora que provee Randoop

### 1) Setup/teardown inyectado en tests generados

Opciones:

- `--junit-before-each`
- `--junit-after-each`
- `--junit-before-all`
- `--junit-after-all`

Uso recomendado aqui:

- recrear `System.in`,
- crear archivo temporal,
- cargar contenido esperado,
- limpiar estado al final.

### 2) Fijar propiedades del sistema (reproducibilidad)

Opcion:

- `--system-props`

Ejemplo: fijar `user.language`, `user.country`, `user.timezone` para estabilizar formato de fecha.

### 3) Inyectar literales relevantes

Opciones:

- `--literals-file`
- `--literals-level`

Ayuda a que Randoop use valores utiles (strings/rutas) en escenarios con IO.

### 4) Filtrar metodos bajo prueba

Opciones:

- `--methodlist`
- `--omitmethods`

Permite concentrar la generacion en APIs relevantes y evitar ruido o bloqueos.

### 5) Ajustar clasificacion de excepciones

Opciones:

- `--checked-exception`
- `--unchecked-exception`
- `--npe-on-null-input`
- `--npe-on-non-null-input`

Esto impacta que termina como `ErrorTest`, `RegressionTest` o secuencia invalida.

### 6) Controlar presupuesto y tamano de suite

Opciones:

- `--timelimit`
- `--inputlimit`
- `--outputlimit`
- `--maxsize`
- `--small-tests`

Sirve para priorizar tests legibles y evitar suites enormes.

### 7) Manejo de bloqueos y timeouts

Opciones:

- `--usethreads`
- `--timeout`

Clave cuando algun camino puede trabarse esperando input.

### 8) Captura de salida de consola

Opcion:

- `--capture-output`

Reduce ruido cuando el codigo imprime por stdout/stderr.

### 9) Contratos extra con `@CheckRep`

Mecanismo:

- anotacion `@randoop.CheckRep` sobre metodos invariantes.

Randoop valida esos contratos durante generacion y detecta violaciones en estructuras con estado.

## Aplicacion practica a `fileExample`

Estrategia recomendada:

1. `--junit-before-each` para setear `System.in` y preparar archivo temporal.
2. `--junit-after-each` para restaurar estado.
3. `--system-props` para fijar locale/timezone.
4. `--small-tests`, `--maxsize`, `--outputlimit` para controlar calidad de suite.
5. `--timeout` por test para cortar bloqueos.

## Comando ejemplo recomendado

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

## Conclusion

Randoop con defaults no suele rendir bien en codigo muy dependiente del entorno.
Con hooks de setup/teardown, system props y control de presupuesto, mejora de forma clara la utilidad y estabilidad de los tests generados.
