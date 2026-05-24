# Ejercicio 5 — Tests parametrizados y debugging del Zune bug

## Consigna

Proveer tests parametrizados para el método `ZuneBug.currentYear(int days)`. Si los tests revelan alguna falla, hacer debugging para encontrar y corregir el defecto.

## Contexto — el Zune bug

`ZuneBug` reproduce un bug real del firmware del reproductor Zune de Microsoft: el 31 de diciembre de 2008 (año bisiesto) todos los dispositivos quedaron colgados al intentar determinar el año actual a partir de la cantidad de días transcurridos desde 1980. La rutina defectuosa entraba en un loop infinito porque su lógica para tratar años bisiestos era inconsistente.

## Diseño de los tests

Se escribieron dos tests parametrizados complementarios:

### 1. `casosDeBorde` con `@MethodSource`

Cubre los límites del problema (fin de año, transición de año, año bisiesto, varios años encadenados):

| `days`  | `year` esperado | Qué cubre                          |
|---------|-----------------|------------------------------------|
| `1`     | `1980`          | caso mínimo                        |
| `365`   | `1980`          | último día de 1980 (bisiesto)      |
| `366`   | `1981`          | primer día de 1981 (límite)        |
| `367`   | `1981`          | 1 + 1 día de margen                |
| `731`   | `1982`          | suma exacta 366 + 365              |
| `1461`  | `1984`          | suma exacta 366 + 365 + 365 + 365  |

### 2. `currentYear_debeCoincidirConOracle` con `@ValueSource`

Comparación diferencial contra `ZuneBug.oracle`, que usa `LocalDate.plusDays`. Los valores se eligen alrededor de los límites: `1, 2, 30, 31, 59, 60, 100, 365, 366, 367, 730, 731, 1095, 1461, 10000`.

### Timeout

Ambos tests usan `assertTimeoutPreemptively(Duration.ofMillis(200))` porque la versión defectuosa podía quedarse en un loop infinito y romper la build. Esto convierte un cuelgue en un test failure explícito en lugar de un timeout global.

## Falla detectada

Sobre la versión original (`currentYear_original.java.txt`) los tests detectaban dos síntomas distintos:

- **Loop infinito** cuando `days` quedaba exactamente en `366` en un año bisiesto. La guarda `while (days > 365)` permitía entrar al cuerpo pero la rama bisiesta solo descontaba si `days > 366`, así que el bucle no avanzaba nunca.
- **Off-by-one** en transiciones exactas de año: por ejemplo con `days = 731` la versión original devolvía un año menos que el oráculo.

## Causa del defecto

El método original mezclaba las constantes `365` y `366` en distintos lugares:

```java
while (days > 365) {
    if (isLeapYear(year)) {
        if (days > 366) {
            days -= 366;
            year += 1;
        }
    } else {
        days -= 365;
        year += 1;
    }
}
```

Hay dos problemas combinados:

1. la guarda exterior es `days > 365`, no `days >= 365`, así que el límite exacto no se trata bien;
2. la rama bisiesta usa `days > 366` (más restrictivo todavía) y, lo peor, **no tiene `else`**: si la rama no se cumple, el bucle se queda iterando porque las variables no cambian.

## Corrección aplicada

Se reescribió el bucle para que la condición dependa de cuántos días tiene **el año actual**:

```java
public static int currentYear (int days) {
    int year = 1980;
    while (true) {
        int daysInYear = isLeapYear(year) ? 366 : 365;
        if (days >= daysInYear) {
            days -= daysInYear;
            year += 1;
        } else {
            break;
        }
    }
    return year;
}
```

La variable `daysInYear` se calcula en función de si el año en curso es bisiesto. Mientras quedan días suficientes para completar el año en curso (`days >= daysInYear`), se descuentan y se avanza; si no, se corta y se devuelve el año. Así se eliminan el loop infinito (porque el bucle siempre progresa) y el off-by-one (porque la comparación ahora es `>=`).

## Cómo ejecutar

Desde la raíz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=ZuneBugParameterizedTest test
```

Resultado luego de la corrección:

- `Tests run: 21, Failures: 0, Errors: 0`
- `BUILD SUCCESS`

## Relación con los conceptos de la materia

- **Differential testing**: el segundo test compara la rutina contra `oracle`, que actúa como implementación de referencia (`LocalDate.plusDays`). Es un caso pequeño pero claro de uso de *test oracle*.
- **Boundary value analysis**: los `casosDeBorde` se eligen alrededor de los límites donde sabemos que la lógica original fallaba.
- **Defensive testing**: el `assertTimeoutPreemptively` traduce un posible *hang* en una falla diagnosticable.

## Código

- [`ZuneBug.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/ZuneBug.java) — versión corregida.
- [`ZuneBugParameterizedTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/ZuneBugParameterizedTest.java) — `casosDeBorde` + comparación diferencial contra el oráculo.
- [`currentYear_original.java.txt`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/ejercicio5/currentYear_original.java.txt) — versión defectuosa antes de la corrección, conservada como referencia.

## Enlaces relacionados

- Enunciado del práctico: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución completa: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
- Resumen teórico: [`resumen_teorico_tp2.pdf`](/pdfs/tp2/resumen_teorico_tp2.pdf)
