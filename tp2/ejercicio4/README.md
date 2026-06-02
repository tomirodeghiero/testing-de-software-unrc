# Ejercicio 4 — Tests parametrizados en CSV para `Min`

## Consigna

Tests parametrizados en CSV para `Min.min(List<? extends T>)`. Agregar tests negativos.

## Programa bajo prueba

`Min.min` recibe una `List` de elementos `Comparable` y devuelve el mínimo. El contrato (Javadoc) tiene tres precondiciones, cada una con su excepción:

- `IllegalArgumentException` si la lista es vacía,
- `NullPointerException` si la lista es `null` o contiene `null`,
- `ClassCastException` si los elementos no son mutuamente comparables.

## Cómo armé los CSV

Como la consigna pide CSV, codifiqué cada lista como un string con elementos separados por `;` dentro de una sola celda. Queda compacto y legible.

### Casos válidos (`min_valid_cases.csv`)

| Lista          | Mínimo | Qué cubre                                  |
|----------------|--------|--------------------------------------------|
| `3;2;1`        | `1`    | mínimo al final                            |
| `5`            | `5`    | lista de un solo elemento                  |
| `-2;4;0`       | `-2`   | mínimo al inicio + negativos               |
| `7;7;9`        | `7`    | elementos repetidos                        |
| `10;-1;3;-1`   | `-1`   | mínimo repetido en distintas posiciones    |

Cada caso cae en una partición distinta dentro de la familia "listas válidas no vacías".

### Casos inválidos en CSV (`min_invalid_cases.csv`)

| Lista          | Excepción esperada           |
|----------------|------------------------------|
| `EMPTY`        | `IllegalArgumentException`   |
| `null;2;3`     | `NullPointerException`       |
| `1;null;3`     | `NullPointerException`       |

El token `EMPTY` se mapea a lista vacía. `null` representa un elemento nulo en la lista. La traducción de "nombre de excepción" → `Class<? extends Throwable>` se hace en el propio test, así el CSV se mantiene libre de detalles de Java.

### Casos inválidos en código

Hay dos que no se prestan a expresarse en CSV, así que van como `@Test` clásicos:

- lista `null` → `NullPointerException`,
- elementos no mutuamente comparables (`Integer + String` vía *raw type*) → `ClassCastException`.

## Cómo correr

```bash
cd tp2
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=MinCsvParameterizedTest test
```

## Notas

- `Min.min` es genérico (`<T extends Comparable<? super T>>`). En los tests uso `List<Integer>` porque ya ejercita todas las ramas. Para el caso de elementos incomparables hay que romper la tipicidad con un *raw type*: es la forma de emular en tiempo de ejecución la situación para la que existe `ClassCastException`.
- Separar casos válidos e inválidos en dos CSV es la versión más simple del patrón *data-driven testing*.

## Archivos

- [`Min.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/Min.java) — implementación provista.
- [`MinCsvParameterizedTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/MinCsvParameterizedTest.java) — tests sobre los dos CSV + casos negativos en código.
- [`min_valid_cases.csv`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/resources/assignment2_exercises/min_valid_cases.csv) — casos válidos.
- [`min_invalid_cases.csv`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/resources/assignment2_exercises/min_invalid_cases.csv) — casos que deben lanzar excepción.

## Enlaces

- Enunciado: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
