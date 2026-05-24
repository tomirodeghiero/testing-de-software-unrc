---
title: "Ejercicio 4"
sidebar_position: 4
slug: "/tp2/ejercicio4/"
description: "Contenido importado desde tp2/ejercicio4/README.md"
---

# Ejercicio 4 — Tests parametrizados en CSV para `Min`

## Consigna

Proveer tests parametrizados en formato CSV para el método `Min.min(List<? extends T>)` de `assignment2_exercises.Min`. Agregar tests negativos.

## Programa bajo prueba

`Min.min` recibe una lista de elementos `Comparable` y devuelve el mínimo. Su contrato (ver Javadoc) tiene tres precondiciones, cada una con una excepción asociada:

- `IllegalArgumentException` si la lista es vacía,
- `NullPointerException` si la lista es `null` o contiene `null`,
- `ClassCastException` si los elementos no son mutuamente comparables.

## Diseño de casos

La consigna pide tests parametrizados en CSV, por lo que se eligió codificar la lista de entrada como string separado por `;` dentro de una única celda CSV. Esto permite un CSV legible y compacto.

### Casos válidos (`min_valid_cases.csv`)

| Lista          | Mínimo | Qué cubre                                  |
|----------------|--------|--------------------------------------------|
| `3;2;1`        | `1`    | mínimo al final                            |
| `5`            | `5`    | lista de un solo elemento                  |
| `-2;4;0`       | `-2`   | mínimo en la primera posición + negativos  |
| `7;7;9`        | `7`    | elementos repetidos                        |
| `10;-1;3;-1`   | `-1`   | mínimo repetido en distintas posiciones    |

Cada caso cubre una partición de entrada distinta dentro de la familia "listas válidas no vacías".

### Casos inválidos vía CSV (`min_invalid_cases.csv`)

| Lista          | Excepción esperada           |
|----------------|------------------------------|
| `EMPTY`        | `IllegalArgumentException`   |
| `null;2;3`     | `NullPointerException`       |
| `1;null;3`     | `NullPointerException`       |

El token literal `EMPTY` se mapea a lista vacía. El token `null` representa un `null` dentro de la lista. El mapping `texto → Class<? extends Throwable>` se hace en el propio test, así el CSV queda libre de detalles de Java.

### Casos inválidos en código

Hay dos escenarios que no son cómodos de expresar en CSV y por eso se escriben como `@Test` clásicos:

- lista `null` → `NullPointerException`,
- elementos no mutuamente comparables (`Integer + String` vía *raw type*) → `ClassCastException`.

## Cómo ejecutar

Desde la raíz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=MinCsvParameterizedTest test
```

## Observaciones

- `Min.min` es genéricamente paramétrico (`<T extends Comparable<? super T>>`). En los tests se usa `List<Integer>` porque alcanza para ejercitar todas las ramas del método. Para el caso de incomparables hay que romper la tipicidad con *raw types*, que es la forma de emular en tiempo de ejecución la situación para la que existe `ClassCastException`.
- Esta estructura —un CSV con casos válidos y otro con casos inválidos— es una forma sencilla de aplicar el patrón *data-driven testing* visto en las notas 04 de la cátedra: separar los datos de los casos de la lógica del test.

## Código

- [`Min.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/Min.java) — implementación provista por la cátedra.
- [`MinCsvParameterizedTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/MinCsvParameterizedTest.java) — tests parametrizados sobre los dos CSV más casos negativos en código.
- [`min_valid_cases.csv`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/resources/assignment2_exercises/min_valid_cases.csv) — set de casos válidos.
- [`min_invalid_cases.csv`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/resources/assignment2_exercises/min_invalid_cases.csv) — set de casos que deben lanzar excepción.

## Enlaces relacionados

- Enunciado del práctico: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución completa: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
- Resumen teórico: [`resumen_teorico_tp2.pdf`](/pdfs/tp2/resumen_teorico_tp2.pdf)
