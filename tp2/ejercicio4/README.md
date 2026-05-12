# Ejercicio 4 - Tests parametrizados en CSV para `Min`

## Consigna

Proveer tests parametrizados en formato CSV para el metodo
`Min.min(List<? extends T>)` de
`assignment2_exercises.Min`. Agregar tests negativos.

## Programa bajo prueba

`Min.min` recibe una lista de elementos `Comparable` y devuelve el
minimo. Su contrato (ver Javadoc) tiene tres precondiciones, cada una
con una excepcion asociada:

- `IllegalArgumentException` si la lista es vacia,
- `NullPointerException` si la lista es `null` o contiene `null`,
- `ClassCastException` si los elementos no son mutuamente comparables.

## Archivos

- `../src/test/java/assignment2_exercises/MinCsvParameterizedTest.java`
- `../src/test/resources/assignment2_exercises/min_valid_cases.csv`
- `../src/test/resources/assignment2_exercises/min_invalid_cases.csv`

## Diseno de casos

La consigna pide tests parametrizados en CSV, por lo que se eligio
codificar la lista de entrada como string separado por `;` dentro de
una unica celda CSV. Esto permite un CSV legible y compacto.

### Casos validos (`min_valid_cases.csv`)

| Lista          | Minimo | Que cubre                    |
|----------------|--------|------------------------------|
| `3;2;1`        | `1`    | minimo al final              |
| `5`            | `5`    | lista de un solo elemento    |
| `-2;4;0`       | `-2`   | minimo en la primera posicion + negativos |
| `7;7;9`        | `7`    | elementos repetidos          |
| `10;-1;3;-1`   | `-1`   | minimo repetido en distintas posiciones |

Cada caso cubre una particion de entrada distinta dentro de la familia
"listas validas no vacias".

### Casos invalidos via CSV (`min_invalid_cases.csv`)

| Lista          | Excepcion esperada           |
|----------------|------------------------------|
| `EMPTY`        | `IllegalArgumentException`   |
| `null;2;3`     | `NullPointerException`       |
| `1;null;3`     | `NullPointerException`       |

El token literal `EMPTY` se mapea a lista vacia. El token `null`
representa un `null` dentro de la lista. El mapping `texto -> Class<?
extends Throwable>` se hace en el propio test, asi el CSV queda libre
de detalles de Java.

### Casos invalidos en codigo

Hay dos escenarios que no son comodos de expresar en CSV y por eso se
escriben como `@Test` clasicos:

- lista `null` -> `NullPointerException`,
- elementos no mutuamente comparables (`Integer + String` via raw
  type) -> `ClassCastException`.

## Como correr solo este ejercicio

Desde la raiz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=MinCsvParameterizedTest test
```

## Observaciones

- `Min.min` es genericamente parametrico (`<T extends Comparable<?
  super T>>`). En los tests se usa `List<Integer>` porque alcanza para
  ejercitar todas las ramas del metodo. Para el caso de incomparables
  hay que romper la tipicidad con `raw types`, que es la forma de
  emular en tiempo de ejecucion la situacion para la que existe
  `ClassCastException`.
- Esta estructura (un CSV con casos validos y otro con casos
  invalidos) es una forma sencilla de aplicar el patron *data driven
  testing* visto en las notas 04 de la catedra: separar los datos de
  los casos de la logica del test.
