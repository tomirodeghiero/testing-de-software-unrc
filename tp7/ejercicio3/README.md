# Ejercicio 3

En este ejercicio trabajé sobre `assignment7_exercises.date.Date`.
La consigna pedía implementar `addDays(Date when, int days)` y chequear con una propiedad que la fecha resultante siempre sea válida (`repOk()`).

## Código resuelto

- Implementación de `Date`: [Date.java](../assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/date/Date.java)
- Propiedad `jqwik`: [DatePropertiesTest.java](../assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/date/DatePropertiesTest.java)

## Qué implementé

### 1) Constructor y `repOk()`

Se completó el constructor con validación de fecha y excepción para datos inválidos.
Además se implementó `repOk()` para validar el invariante de representación:

- `year >= 1900`,
- `1 <= month <= 12`,
- `day` dentro de los límites del mes,
- febrero correcto según año bisiesto.

### 2) `addDays(Date when, int days)`

Se implementó el algoritmo de avance día a día por bloques de mes:

- valida `when != null`,
- valida `days >= 0`,
- ajusta día/mes/año cuando se supera el fin de mes,
- devuelve una nueva `Date` válida.

### 3) Propiedad con generador

Se creó una propiedad con `jqwik` que genera:

- fechas válidas (`fechasValidas`),
- cantidad de días no negativa (`diasNoNegativos`).

Y verifica que el resultado de `addDays`:

- no sea `null`,
- cumpla `repOk()`.

## Ejecución

Desde `tp7/assignmnet-7-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado: **BUILD SUCCESS** con todas las propiedades de `tp7` en verde.
