---
title: "Ejercicio 2"
sidebar_position: 2
slug: "/tp2/ejercicio2/"
description: "Contenido importado desde tp2/ejercicio2/README.md"
---

# Ejercicio 2

En este punto pase a tests parametrizados los casos del ejercicio 3 del TP1,
pero ejecutandolos sobre la clase que dio la catedra:

- `../src/main/java/assignment2_exercises/SimpleRoutines.java`

Metodos cubiertos:

- `findLast(int[] x, int y)`
- `lastZero(int[] x)`
- `countPositive(int[] x)`
- `oddOrPos(int[] x)`

## Que agregue

- `../src/test/java/assignment2_exercises/SimpleRoutinesParameterizedTest.java`
- `../src/test/resources/assignment2_exercises/odd_or_pos_cases.csv`

## Como esta parametrizado

- `@MethodSource` en `lastZero` y `countPositive`.
- `@CsvSource` en `findLast`.
- `@CsvFileSource` en `oddOrPos`.

Con esto se cumple lo pedido en la consigna: usar al menos un proveedor por
metodo y al menos un caso en formato CSV.

## Como correrlo

Desde `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=SimpleRoutinesParameterizedTest test
```

Uso `-Djacoco.skip=true` porque el JaCoCo del template (`0.8.2`) rompe con
JDK actuales.

## Que deberia pasar

La suite corre 10 casos. Sobre `SimpleRoutines` (version defectuosa) fallan
justamente los 4 casos que exponen los defectos del enunciado:

- `findLast`: no revisa el indice `0`.
- `lastZero`: devuelve el primer cero y no el ultimo.
- `countPositive`: cuenta `0` como positivo.
- `oddOrPos`: no cuenta impares negativos.
