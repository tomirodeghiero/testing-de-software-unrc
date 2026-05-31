# Ejercicio 3 — `Date`: validación, `addDays` y propiedad

Trabajo sobre `assignment7_exercises.date.Date`, que representa una fecha de calendario (día, mes, año) desde el año 1900. La consigna pide:

1. completar el constructor y `repOk()` para que rechacen fechas inválidas,
2. implementar `addDays(Date when, int days)` que suma una cantidad de días a una fecha,
3. escribir una propiedad en `jqwik` que verifique que el resultado de `addDays` siempre es una fecha válida.

## Constructor y `repOk()`

El constructor toma `(d, m, y)` y antes de asignar valida la terna con `isValidDate`. Si la combinación no es legal, lanza `IllegalArgumentException("invalid date")`. Así nunca se construye un `Date` en estado inválido y el resto del código puede asumir consistencia.

```java
public Date(int d, int m, int y) throws IllegalArgumentException {
    if (!isValidDate(d, m, y)) {
        throw new IllegalArgumentException("invalid date");
    }
    this.day = d;
    this.month = m;
    this.year = y;
    assert repOk();
}

public boolean repOk() {
    return isValidDate(day, month, year);
}
```

`repOk()` reutiliza `isValidDate` para no duplicar lógica. Las reglas del invariante:

- `year >= 1900`,
- `1 <= month <= 12`,
- `1 <= day <= daysInMonth(month, year)`,
- meses de 30 días (4, 6, 9, 11) no admiten `day == 31`,
- febrero tiene 29 días en años bisiestos y 28 en no bisiestos.

El cálculo de días por mes está centralizado en `daysInMonth(m, y)`, que usa `leap(y)` para febrero. Tener un único lugar con esa lógica es importante porque `addDays` también la consume: si hubiera dos implementaciones, podrían desincronizarse.

## `addDays(Date when, int days)`

Devuelve una **nueva** `Date` (no muta la original), sumando `days` días calendario a `when`. Avanza **por bloques de mes** en lugar de día por día: con `days` del orden de miles, la iteración por día sería innecesariamente lenta.

```java
public Date addDays(Date when, int days) {
    if (when == null) throw new IllegalArgumentException("date cannot be null");
    if (days < 0)    throw new IllegalArgumentException("days must be non-negative");

    int d = when.day, m = when.month, y = when.year;
    int remainingDays = days;

    while (remainingDays > 0) {
        int daysInCurrentMonth = daysInMonth(m, y);
        int daysLeftInMonth = daysInCurrentMonth - d;

        if (remainingDays <= daysLeftInMonth) {
            d = d + remainingDays;
            remainingDays = 0;
        } else {
            remainingDays = remainingDays - (daysLeftInMonth + 1);
            d = 1;
            m = m + 1;
            if (m > 12) { m = 1; y = y + 1; }
        }
    }

    return new Date(d, m, y);
}
```

Esquema:

1. **Validaciones**. `when` no puede ser `null`. `days` no puede ser negativo (la consigna restringe a avance).
2. **Variables de trabajo** `d`, `m`, `y` y `remainingDays`.
3. **Bucle**: en cada iteración se calcula `daysLeftInMonth`. Si los restantes caben en el mes actual, se suman directamente al día y se termina. Si no caben, se consume el resto del mes (incluyendo el salto al día 1 del mes siguiente, por eso se resta `daysLeftInMonth + 1`), se avanza un mes y, si supera 12, se pasa al 1 de enero del año siguiente.
4. **Resultado**: `new Date(d, m, y)` vuelve a pasar por el constructor, así que cualquier estado intermedio inválido explotaría con `IllegalArgumentException`.

La clave: nunca se construye una fecha intermedia inválida — el salto de mes se hace en un solo paso, sin pasar por un hipotético "32 de enero".

## Propiedad con generadores

```java
@Property(tries = 250)
void addDaysSiempreDevuelveFechaValida(
    @ForAll("fechasValidas") Date fecha,
    @ForAll("diasNoNegativos") int dias
) {
    Date receptor = new Date(1, 1, 1900);
    Date resultado = receptor.addDays(fecha, dias);

    assertNotNull(resultado);
    assertTrue(resultado.repOk());
}
```

Captura la idea central: **para cualquier fecha válida y cualquier cantidad no negativa de días, el resultado de `addDays` es una fecha válida**.

Los generadores:

- **`fechasValidas`** usa `flatMap` para construir la terna `(day, month, year)` en el orden correcto: primero el año (`1900..2400`), después el mes (`1..12`), y por último el día (`1..daysInMonth(month, year)`). El anidamiento es necesario porque el rango del día **depende** del mes y el año (si no, se generarían cosas como `31/04/2024` que el constructor rechazaría).
- **`diasNoNegativos`** genera enteros entre `0` y `5000`. Suficiente para forzar saltos de varios años (5000 días ≈ 13 años y medio) sin volver lenta la suite.

El receptor `new Date(1, 1, 1900)` está solo porque `addDays` es de instancia; su contenido es irrelevante porque todo se hace sobre `when`.

## Cómo correr

```bash
cd tp7/assignmnet-7-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=DatePropertiesTest test
```

Resultado: `BUILD SUCCESS` con la propiedad en verde.

## Archivos

- [`Date.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp7/assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/date/Date.java) — constructor, `repOk`, `addDays`.
- [`DatePropertiesTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp7/assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/date/DatePropertiesTest.java) — propiedad + generadores.

## Enlaces

- Resolución: [`resolucion_practico7.pdf`](/pdfs/tp7/resolucion_practico7.pdf)
