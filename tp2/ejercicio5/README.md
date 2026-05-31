# Ejercicio 5 — Zune bug

## Consigna

Tests parametrizados para `ZuneBug.currentYear(int days)`. Si los tests revelan alguna falla, hacer debugging y corregir el defecto.

## Contexto

`ZuneBug` reproduce un bug real del firmware del Zune de Microsoft: el 31 de diciembre de 2008 (año bisiesto) todos los dispositivos colgaron al intentar determinar el año actual a partir de los días transcurridos desde 1980. La rutina entraba en un loop infinito por una lógica inconsistente al tratar bisiestos.

## Tests

Armé dos tests parametrizados complementarios:

### 1. `casosDeBorde` con `@MethodSource`

Cubre los límites del problema (fin de año, transición de año, año bisiesto, años encadenados):

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

Los dos tests envuelven la llamada en `assertTimeoutPreemptively(Duration.ofMillis(200))`. Esto es importante porque la versión defectuosa podía quedarse en un loop infinito y romper la build entera. El timeout convierte un cuelgue en un *test failure* explícito.

## Fallas que aparecieron

Sobre la versión original (`currentYear_original.java.txt`) los tests mostraron dos síntomas:

- **Loop infinito** cuando `days` quedaba en `366` en un año bisiesto. La guarda `while (days > 365)` permitía entrar al cuerpo, pero la rama bisiesta solo descontaba si `days > 366`; sin `else`, el bucle no avanzaba.
- **Off-by-one** en transiciones exactas de año: por ejemplo con `days = 731` devolvía un año menos que el oráculo.

## Causa

El método mezclaba `365` y `366` en lugares distintos:

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

Dos problemas combinados:

1. la guarda exterior es `days > 365`, no `days >= 365`, así que el límite exacto no se trata bien;
2. la rama bisiesta usa `days > 366` (más restrictivo todavía) y **no tiene `else`**: si la rama no se cumple, el bucle se queda iterando sin que las variables cambien.

## Corrección

Reescribí el bucle para que la condición dependa de cuántos días tiene **el año actual**:

```java
public static int currentYear(int days) {
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

`daysInYear` se calcula según el año en curso. Mientras quedan días suficientes para completarlo (`>= daysInYear`), se descuentan y se avanza; si no, se corta y se devuelve el año. Así se eliminan los dos problemas: el bucle siempre progresa (no hay loop infinito) y la comparación es `>=`, así que los bordes quedan bien.

## Cómo correr

```bash
cd tp2
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=ZuneBugParameterizedTest test
```

Después de la corrección: `Tests run: 21, Failures: 0, Errors: 0`.

## Relación con los conceptos de la materia

- **Differential testing**: el segundo test compara contra `oracle` (`LocalDate.plusDays`), que actúa como implementación de referencia.
- **Boundary value analysis**: los `casosDeBorde` se eligen alrededor de los límites donde la versión original fallaba.
- **Defensive testing**: el `assertTimeoutPreemptively` traduce un posible *hang* en una falla diagnosticable en vez de bloquear la build.

## Archivos

- [`ZuneBug.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/main/java/assignment2_exercises/ZuneBug.java) — versión corregida.
- [`ZuneBugParameterizedTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/src/test/java/assignment2_exercises/ZuneBugParameterizedTest.java) — `casosDeBorde` + comparación contra el oráculo.
- [`currentYear_original.java.txt`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp2/ejercicio5/currentYear_original.java.txt) — versión defectuosa, conservada como referencia.

## Enlaces

- Enunciado: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
