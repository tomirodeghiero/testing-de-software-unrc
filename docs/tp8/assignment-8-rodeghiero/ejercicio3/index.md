---
title: "Ejercicio 3"
sidebar_position: 3
slug: "/tp8/assignment-8-rodeghiero/ejercicio3/"
description: "Contenido importado desde tp8/assignment-8-rodeghiero/ejercicio3/README.md"
---

# Ejercicio 3 - Mecanismos de Randoop para mejorar escenarios como el Ejercicio 2

## Problema base del escenario

En `fileExample.checkContent()` hay varias dependencias externas que dificultan la generación automática de tests significativos:

1. Entrada por `System.in`.
2. Lectura de archivos reales desde el filesystem.
3. Dependencia de la fecha y el locale del sistema.
4. Un efecto lateral: cerrar el scanner de consola también cierra `System.in`, lo que altera el estado global.

Con una configuración básica, Randoop rara vez logra generar casos útiles en este tipo de clases, ya que su exploración aleatoria no puede fabricar el contexto mínimo necesario para alcanzar los caminos interesantes.

## Mecanismos concretos de mejora que provee Randoop

Randoop ofrece un conjunto de opciones pensadas justamente para abordar estas dificultades. A continuación se describen las más relevantes para el escenario del Ejercicio 2.

### 1) Setup/teardown inyectado en tests generados

Opciones disponibles:

- `--junit-before-each`
- `--junit-after-each`
- `--junit-before-all`
- `--junit-after-all`

Uso recomendado aquí:

- recrear `System.in`,
- crear un archivo temporal controlado,
- cargar el contenido esperado,
- limpiar el estado al finalizar cada test.

### 2) Fijar propiedades del sistema (reproducibilidad)

Opción:

- `--system-props`

Permite, por ejemplo, fijar `user.language`, `user.country` y `user.timezone` para estabilizar el formato de fecha y quitarle ese grado de libertad a los tests.

### 3) Inyectar literales relevantes

Opciones:

- `--literals-file`
- `--literals-level`

Ayudan a que Randoop elija valores útiles (cadenas, rutas, identificadores) en lugar de basarse únicamente en literales inferidos del código.

### 4) Filtrar métodos bajo prueba

Opciones:

- `--methodlist`
- `--omitmethods`

Permiten concentrar la generación en las APIs relevantes y evitar ruido o bloqueos provocados por métodos que no aportan cobertura.

### 5) Ajustar la clasificación de excepciones

Opciones:

- `--checked-exception`
- `--unchecked-exception`
- `--npe-on-null-input`
- `--npe-on-non-null-input`

Estas opciones cambian cómo se clasifica cada caso generado: si termina como `ErrorTest`, como `RegressionTest` o directamente como secuencia inválida.

### 6) Controlar presupuesto y tamaño de la suite

Opciones:

- `--timelimit`
- `--inputlimit`
- `--outputlimit`
- `--maxsize`
- `--small-tests`

Sirven para priorizar tests legibles y evitar que la suite termine siendo demasiado grande como para mantenerse.

### 7) Manejo de bloqueos y timeouts

Opciones:

- `--usethreads`
- `--timeout`

Son claves cuando algún camino de ejecución puede quedar esperando entrada indefinidamente, como ocurre con `System.in`.

### 8) Captura de salida de consola

Opción:

- `--capture-output`

Reduce el ruido cuando el código bajo prueba imprime por `stdout` o `stderr`.

### 9) Contratos extra con `@CheckRep`

Mecanismo:

- anotación `@randoop.CheckRep` sobre métodos invariantes.

Randoop evalúa esos contratos durante la generación y reporta violaciones, lo que resulta especialmente útil en estructuras con estado interno.

## Aplicación práctica a `fileExample`

Para este caso concreto, la estrategia recomendada sería:

1. Usar `--junit-before-each` para setear `System.in` y preparar un archivo temporal de prueba.
2. Usar `--junit-after-each` para restaurar el estado del entorno.
3. Fijar locale y timezone con `--system-props`.
4. Acotar la suite con `--small-tests`, `--maxsize` y `--outputlimit`.
5. Configurar un `--timeout` por test para cortar bloqueos derivados de la lectura de `stdin`.

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

## Conclusión

Con la configuración por defecto, Randoop no suele rendir bien sobre código fuertemente acoplado al entorno. Al combinar hooks de setup/teardown, fijación de propiedades del sistema y control del presupuesto, la utilidad y la estabilidad de los tests generados mejoran de forma clara, aprovechando mejor el tiempo de exploración de la herramienta.
