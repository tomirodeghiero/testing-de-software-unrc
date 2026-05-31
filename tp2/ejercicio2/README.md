# Ejercicio 2 — Tests parametrizados sobre `SimpleRoutines`

## Consigna

Pasar los tests del ejercicio 3 del Práctico 1 a **tests parametrizados** usando JUnit 5. La consigna pide usar al menos un `@MethodSource` y al menos un caso en CSV (`@CsvSource` o `@CsvFileSource`).

## Programas bajo prueba

Los cuatro métodos viven en `SimpleRoutines.java` (es la versión defectuosa, igual a la del TP1):

- `findLast(int[] x, int y)`
- `lastZero(int[] x)`
- `countPositive(int[] x)`
- `oddOrPos(int[] x)`

## Cómo elegí la fuente para cada método

Para cubrir las tres alternativas que pide la consigna, asigné una fuente distinta a cada uno:

| Método          | Proveedor       | Por qué                                                |
|-----------------|-----------------|--------------------------------------------------------|
| `findLast`      | `@CsvSource`    | datos *inline*, dos columnas + el esperado             |
| `lastZero`      | `@MethodSource` | conviene devolver `int[]` directamente desde Java      |
| `countPositive` | `@MethodSource` | mismo motivo: arreglos `int[]`                         |
| `oddOrPos`      | `@CsvFileSource`| el set queda en un archivo externo, fácil de modificar |

Para los tipos no primitivos (`int[]`), `@MethodSource` devolviendo `Stream<Arguments>` es la forma estándar en JUnit 5.

## Casos elegidos

Reutilicé los casos (c) y (d) del análisis RIPR del TP1:

- **(c)** ejecutan el defecto pero no producen falla (estado infectado que no se propaga).
- **(d)** ejecutan el defecto y sí producen falla.

| Programa        | Caso (c) — pasa     | Caso (d) — revela el defecto       |
|-----------------|---------------------|------------------------------------|
| `findLast`      | `[5,2,3], 2 → 1`    | `[2,3,5], 2 → 0`                   |
| `lastZero`      | `[1,0,2] → 1`       | `[0,1,0] → 2`                      |
| `countPositive` | `[-4,2,2] → 2`      | `[-4,2,0,2] → 2`                   |
| `oddOrPos`      | `[2,4,-2] → 2`      | `[-3,-2,0,1,4] → 3`                |

También incluí los casos (b) con arreglo vacío para `countPositive` y `oddOrPos`.

## Cómo correr

```bash
cd tp2
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=SimpleRoutinesParameterizedTest test
```

## Resultado

La suite ejecuta 10 casos. Sobre la versión defectuosa fallan exactamente los 4 casos (d), uno por programa:

- `findLast`: la guarda `i > 0` omite el índice 0; falla con `[2,3,5]`.
- `lastZero`: recorre de izquierda a derecha y se queda con el primer cero; falla con `[0,1,0]`.
- `countPositive`: usa `>= 0` y cuenta el 0 como positivo; falla con `[-4,2,0,2]`.
- `oddOrPos`: usa `% 2 == 1`, los impares negativos no se detectan; falla con `[-3,-2,0,1,4]`.

Las parametrizadas conservan el mismo poder de detección que las versiones no parametrizadas del TP1.

## Archivos

- [`SimpleRoutines.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/SimpleRoutines.java) — versión defectuosa provista para este TP.
- [`SimpleRoutinesParameterizedTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/SimpleRoutinesParameterizedTest.java) — suite con los tres tipos de fuente.
- [`odd_or_pos_cases.csv`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/resources/assignment2_exercises/odd_or_pos_cases.csv) — casos externos usados por `@CsvFileSource`.

## Enlaces

- Enunciado: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
