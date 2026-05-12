# Ejercicio 2 - Tests parametrizados sobre `SimpleRoutines`

## Consigna

Codificar todos los tests escritos para los programas del ejercicio 3
de la Practica 1 como tests **parametrizados**, usando JUnit 5. Hay
que usar al menos un proveedor con `@MethodSource` y al menos un caso
en formato CSV (`@CsvSource` o `@CsvFileSource`).

## Programas bajo prueba

Los cuatro programas viven en
`../src/main/java/assignment2_exercises/SimpleRoutines.java` (version
defectuosa provista por la catedra para este TP):

- `findLast(int[] x, int y)`
- `lastZero(int[] x)`
- `countPositive(int[] x)`
- `oddOrPos(int[] x)`

## Que se agrego

- `../src/test/java/assignment2_exercises/SimpleRoutinesParameterizedTest.java`
- `../src/test/resources/assignment2_exercises/odd_or_pos_cases.csv`

## Estrategia de parametrizacion

Cada metodo se prueba con una fuente diferente para cubrir la consigna:

| Metodo          | Proveedor       | Justificacion                                         |
|-----------------|-----------------|-------------------------------------------------------|
| `findLast`      | `@CsvSource`    | datos inline, 2 columnas (arreglo, valor) + esperado  |
| `lastZero`      | `@MethodSource` | conviene usar `int[]` "nativo" desde codigo Java      |
| `countPositive` | `@MethodSource` | mismo motivo: arreglos `int[]`                        |
| `oddOrPos`      | `@CsvFileSource`| set externo de casos, recargable sin tocar el codigo  |

Los proveedores via `@MethodSource` devuelven `Stream<Arguments>`, que
es la forma estandar de JUnit 5 para inyectar tipos no primitivos como
`int[]`. Para `findLast` y `oddOrPos`, donde los datos se pueden
representar comodamente como texto, se usa CSV.

## Casos de prueba

Se reutilizan los casos (c) y (d) que el Practico 1 habia derivado del
analisis con el modelo RIPR:

- **(c)** ejecutan el defecto pero **no** producen falla observable
  (el estado se infecta pero no se propaga, o nunca se infecta).
- **(d)** ejecutan el defecto y **si** producen falla.

| Programa        | Caso (c) - pasa     | Caso (d) - revela el defecto       |
|-----------------|---------------------|------------------------------------|
| `findLast`      | `[5,2,3], 2 -> 1`   | `[2,3,5], 2 -> 0`                  |
| `lastZero`      | `[1,0,2] -> 1`      | `[0,1,0] -> 2`                     |
| `countPositive` | `[-4,2,2] -> 2`     | `[-4,2,0,2] -> 2`                  |
| `oddOrPos`      | `[2,4,-2] -> 2`     | `[-3,-2,0,1,4] -> 3`               |

Para los casos (b) (no ejecutan el defecto) se incluyen arreglos
vacios en `countPositive` y `oddOrPos`.

## Como correrlo

Desde la raiz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=SimpleRoutinesParameterizedTest test
```

El `-Djacoco.skip=true` evita el problema con el JaCoCo 0.8.2 del
template, que no compatibiliza con JDK >= 11.

## Resultado esperado

La suite ejecuta 10 casos. Sobre la **version defectuosa** de
`SimpleRoutines` provista por la catedra fallan exactamente los 4
casos que cumplen Reachability + Infection + Propagation:

- `findLast`: la guarda `i > 0` omite el indice 0; falla con `[2,3,5]`.
- `lastZero`: recorre de izquierda a derecha y se queda con el primer
  cero; falla con `[0,1,0]`.
- `countPositive`: usa `>= 0`, cuenta el cero como positivo; falla con
  `[-4,2,0,2]`.
- `oddOrPos`: usa `% 2 == 1` y por la semantica de `%` en Java los
  impares negativos no se detectan; falla con `[-3,-2,0,1,4]`.

Esos cuatro **failures** son el resultado deseado del ejercicio:
demuestran que los tests parametrizados conservan la capacidad de
deteccion que ya tenian las versiones no parametrizadas del TP1.
