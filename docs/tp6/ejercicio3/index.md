---
title: "Ejercicio 3"
sidebar_position: 3
slug: "/tp6/ejercicio3/"
description: "Contenido importado desde tp6/ejercicio3/README.md"
---

# Ejercicio 3

Este ejercicio estaba orientado a completar la parte de fuzzing del template.
La consigna pedía completar `MutationFuzzer`, `Mutator`, `RandomFuzzer` y cerrar el test que ejecuta `bc` para validar que no aparezcan comportamientos inesperados.

## Código completado

Archivos editados:

- [Mutator.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/Mutator.java)
- [MutationFuzzer.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/MutationFuzzer.java)
- [RandomFuzzer.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/fuzzing/RandomFuzzer.java)
- [LinuxCommandTest.java](../assignment-6-rodeghiero/src/test/java/assignment6_exercises/fuzzing/LinuxCommandTest.java)

## Qué implementé en cada clase

### 1) `Mutator`

Se implementaron los tres operadores básicos:

1. `deleteRandomCharacter(s)`
2. `insertRandomCharacter(s)`
3. `flipRandomCharacter(s)`

Y el método `mutate(s)` que elige aleatoriamente uno de esos operadores.
Además se agregó validación de `null` y manejo de string vacío en operaciones donde corresponde.

### 2) `MutationFuzzer`

Se corrigió el constructor (el `max_mutations` estaba mal asignado) y se implementó `fuzz()`:

1. toma una semilla aleatoria de la población,
2. elige cuántas mutaciones aplicar entre `min_mutations` y `max_mutations`,
3. aplica las mutaciones en cadena y devuelve el resultado.

### 3) `RandomFuzzer`

Se implementó `fuzz()` para generar strings con:

1. longitud aleatoria entre `0` y `maxLength`,
2. caracteres aleatorios en el rango indicado por `charStart` y `charRange`.

### 4) `LinuxCommandTest`

Se completó el test parametrizado que ejecuta `bc` sobre entradas fuzzed.

Criterio de chequeo final (enfocado a “salida inesperada grave”):

1. el proceso no finaliza con códigos típicos de aborto/segfault (`134`, `139`),
2. `stderr` no contiene:
   - `segmentation fault`
   - `core dumped`
   - `illegal instruction`

Importante: no se exige `exitCode == 0`, porque con entradas fuzzed es esperable que `bc` devuelva errores sintácticos para parte de los casos.

## Verificación

Comando ejecutado:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado:

- `BUILD SUCCESS`
- `LinuxCommandTest`: 100/100 OK
- `TriTypTest`: 15/15 OK

## Cierre

El ejercicio queda completo con las tres clases de fuzzing implementadas y con un test robusto para ejecutar `bc` de forma segura y controlada ante entradas aleatorias/mutadas.
