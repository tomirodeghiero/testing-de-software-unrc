# Ejercicio 4

En este ejercicio hice tests parametrizados en CSV para el metodo
`Min.min(List<? extends T>)`.

## Archivos

- `../src/test/java/assignment2_exercises/MinCsvParameterizedTest.java`
- `../src/test/resources/assignment2_exercises/min_valid_cases.csv`
- `../src/test/resources/assignment2_exercises/min_invalid_cases.csv`

## Que cubren los tests

- Casos validos con enteros (minimo al inicio, al medio, al final, repetidos,
  negativos, lista de un elemento).
- Casos invalidos desde CSV:
  - lista vacia (`IllegalArgumentException`)
  - lista con `null` como primer elemento (`NullPointerException`)
  - lista con `null` en otra posicion (`NullPointerException`)
- Negativos adicionales:
  - lista `null` (`NullPointerException`)
  - elementos no mutuamente comparables (`ClassCastException`)

## Como correr solo este ejercicio

Desde `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=MinCsvParameterizedTest test
```
