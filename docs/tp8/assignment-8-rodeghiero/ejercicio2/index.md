---
title: "Ejercicio 2"
sidebar_position: 2
slug: "/tp8/assignment-8-rodeghiero/ejercicio2/"
description: "Contenido importado desde tp8/assignment-8-rodeghiero/ejercicio2/README.md"
---

# Ejercicio 2 - Analisis de `fileExample` con Randoop y EvoSuite

## Analisis rapido del codigo

La clase `assignment8_exercises.fileContents.fileExample` tiene una sola operacion (`checkContent`) con dependencia fuerte del contexto del entorno:

1. Lee nombre de archivo desde `System.in`.
2. Cierra el `Scanner` de consola (cierra tambien `System.in`).
3. Si el archivo no existe, devuelve `false`.
4. Si existe, lee primera linea del archivo.
5. Compara con fecha actual (`DateFormat.SHORT`).

Esto vuelve sensibles los tests a:

- entrada estandar,
- sistema de archivos,
- fecha del sistema,
- locale/formato de fecha.

## Resultado con Randoop

Generacion:

```bash
./gen-randoop.sh assignment8_exercises.fileContents.fileExample 25 300 200
```

Salida obtenida:

- Se genero `RegressionTest0` con 1 test.
- No se genero `ErrorTest`.
- El test verifica `NoSuchElementException` al no haber entrada en `System.in`.

Ejecucion (evitando bloqueo por stdin):

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
mvn -q -Djacoco.skip=true -DforkCount=0 \
-Dtest=assignment8_exercises.fileContents.RegressionTest test < /dev/null
```

Resultado:

- 1 test
- 0 fallos
- 0 errores

Interpretacion:

Randoop explora poco comportamiento funcional en esta clase porque la API publica requiere IO y estado externo para llegar a caminos interesantes.

## Resultado con EvoSuite

Generacion:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
./gen-evo.sh assignment8_exercises.fileContents.fileExample 20
```

Salida obtenida:

- `fileExample_ESTest` (suite principal) con 3 tests.
- `fileExample_Failed_ESTest` (casos de violaciones/errores).

Cobertura reportada por EvoSuite durante la generacion de tests:

- Cobertura promedio: 60%
- Line: 53%
- Branch: 60%
- Weak mutation: 10%

También detecto excepciones no declaradas en la suite `Failed` (ejemplo: `No line found`), consistente con `Scanner.nextLine()` sin validar disponibilidad.

Ejecución de `fileExample_ESTest` en este entorno:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
mvn -q -Djacoco.skip=true -DforkCount=0 \
-Dtest=assignment8_exercises.fileContents.fileExample_ESTest test
```

Resultado:

- Falla en inicialización del runner de EvoSuite por `tools.jar` no encontrado.

Interpretación:

Los tests se generan, pero el runtime de EvoSuite usado por el template no ejecuta bien sobre JDK modernos (11/17+) y espera infraestructura historica de JDK 8.

## Comparación Randoop vs EvoSuite

- Randoop:
  - Robusto para generar rápido.
  - En esta clase genero solo un escenario trivial.
  - No levanto `ErrorTest`.
- EvoSuite:
  - Genero mas casos y detecto violaciones de excepciones no declaradas.
  - Requiere entorno mas especifico para ejecutar (idealmente JDK 8 compatible con su runtime).

Conclusion:

Para `fileExample`, EvoSuite fue mas expresivo en generacion; Randoop fue mas simple de ejecutar en este entorno.
