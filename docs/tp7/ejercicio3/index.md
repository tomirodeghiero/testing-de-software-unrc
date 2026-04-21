---
title: "Ejercicio 3"
sidebar_position: 3
slug: "/tp7/ejercicio3/"
description: "Contenido importado desde tp7/ejercicio3/README.md"
---

# Ejercicio 3

Este ejercicio trabaja sobre la clase `assignment7_exercises.date.Date`, que representa una fecha de calendario (día, mes, año) a partir del año 1900. La consigna pedía:

1. completar el constructor y el método `repOk()` para que rechacen fechas inválidas,
2. implementar `addDays(Date when, int days)`, que suma una cantidad de días a una fecha dada,
3. escribir una propiedad en `jqwik` que verifique que el resultado de `addDays` siempre es una fecha válida.

## Archivos relevantes

- Implementación de `Date`: [Date.java](../assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/date/Date.java)
- Propiedad `jqwik`: [DatePropertiesTest.java](../assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/date/DatePropertiesTest.java)

## Desarrollo de la resolución

### 1) Constructor y `repOk()`

El constructor toma `(d, m, y)` y antes de asignar los campos valida la terna con `isValidDate`. Si la combinación no es legal, lanza `IllegalArgumentException("invalid date")`. De esta forma nunca se construye un `Date` en estado inválido, lo cual simplifica el resto del código: cualquier instancia existente se puede asumir consistente.

`repOk()` reutiliza la misma función `isValidDate` para evitar duplicar la lógica. Las reglas del invariante son:

- `year >= 1900` (la clase no modela fechas anteriores),
- `1 <= month <= 12`,
- `1 <= day <= daysInMonth(month, year)`,
- los meses de 30 días (abril, junio, septiembre, noviembre) no admiten `day == 31`,
- febrero tiene 29 días en años bisiestos y 28 en años no bisiestos.

El cálculo de días por mes se centralizó en la función privada `daysInMonth(m, y)`, que usa `leap(y)` para decidir el caso de febrero. Tener un único lugar con esa lógica es importante porque `addDays` también la consume: si hubiera dos implementaciones podrían desincronizarse.

### 2) `addDays(Date when, int days)`

El método devuelve una **nueva** `Date` (no muta la original), sumando `days` días calendario a `when`. Se optó por un algoritmo que avanza **por bloques de mes** en lugar de día por día, porque con `days` del orden de miles (lo que permite el generador) una iteración por día sería innecesariamente lenta.

El esquema general:

1. **Validaciones de entrada.** Si `when` es `null`, se lanza `IllegalArgumentException`. Si `days < 0`, también. El enunciado restringe el avance a números no negativos, así que se rechaza explícitamente.
2. **Variables de trabajo** `d`, `m`, `y` y `remainingDays` inicializadas a partir de `when` y del parámetro `days`.
3. **Bucle principal.** En cada iteración se calcula cuántos días quedan en el mes actual (`daysLeftInMonth = daysInCurrentMonth - d`). Hay dos casos:
   - Si los días restantes **caben** en el mes actual (`remainingDays <= daysLeftInMonth`), se suman directamente al día y se termina.
   - Si **no caben**, se consume el resto del mes (incluyendo saltar al día 1 del mes siguiente, por eso se resta `daysLeftInMonth + 1`), se avanza un mes y, si el mes supera 12, se pasa al 1 de enero del año siguiente.
4. **Construcción del resultado.** Se devuelve `new Date(d, m, y)`, que internamente vuelve a pasar por el constructor, por lo que si por algún error quedara en un estado inválido, la excepción lo expondría de inmediato.

La clave del algoritmo es que nunca se construye una fecha intermedia inválida: el salto de mes se hace en un solo paso, sin pasar por un hipotético "32 de enero".

### 3) Propiedad con generadores

La propiedad `addDaysSiempreDevuelveFechaValida` captura la idea central: **para cualquier fecha válida y cualquier cantidad no negativa de días, el resultado de `addDays` es una fecha válida**. Es la propiedad natural que se espera de una operación de avance sobre un tipo con invariante.

Los generadores son dos:

- **`fechasValidas`**: usa `flatMap` para construir la terna `(day, month, year)` en el orden correcto. Primero se elige el año entre `1900` y `2400`, después el mes entre `1` y `12`, y por último el día entre `1` y `daysInMonth(month, year)`. El anidamiento con `flatMap` es necesario porque el rango del día **depende** del mes y del año ya elegidos (de otra forma se podrían generar cosas como `31/04/2024`, que el constructor rechazaría). Al tope del año se lo acotó en `2400` para que las fechas generadas se mantengan dentro del rango útil sin volverse extravagantes.
- **`diasNoNegativos`**: genera enteros entre `0` y `5000`. El rango se eligió con dos criterios: que sea lo suficientemente amplio como para forzar saltos de varios años (5000 días ≈ 13 años y medio), y que no sea tan grande como para que las 250 iteraciones se vuelvan lentas.

La propiedad crea una instancia *receptora* `new Date(1, 1, 1900)` solamente porque `addDays` es un método de instancia; el contenido del receptor es irrelevante porque todo el cálculo se hace sobre `when`. Luego llama a `addDays(fecha, dias)` y verifica que el resultado:

- no sea `null`,
- cumpla `repOk()`.

Se ejecuta con `tries = 250`.

## Ejecución

Desde `tp7/assignmnet-7-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado: **BUILD SUCCESS** con la propiedad del ejercicio 3 en verde, junto con las del resto del TP.
