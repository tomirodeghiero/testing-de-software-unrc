---
title: "Ejercicio 5"
sidebar_position: 5
slug: "/tp2/ejercicio5/"
description: "Contenido importado desde tp2/ejercicio5/README.md"
---

# Ejercicio 5 - Tests parametrizados y debugging del Zune bug

## Consigna

Proveer tests parametrizados para el metodo
`ZuneBug.currentYear(int days)`. Si los tests revelan alguna falla,
hacer debugging para encontrar y corregir el defecto.

## Contexto - el Zune bug

`ZuneBug` reproduce un bug real del firmware del reproductor Zune de
Microsoft: el 31 de diciembre de 2008 (anio bisiesto) todos los
dispositivos quedaron colgados al intentar determinar el anio actual a
partir de la cantidad de dias transcurridos desde 1980. La rutina
defectuosa entraba en un loop infinito porque su logica para tratar
anios bisiestos era inconsistente.

## Archivos

- `../src/test/java/assignment2_exercises/ZuneBugParameterizedTest.java`
- `../src/main/java/assignment2_exercises/ZuneBug.java` (version
  corregida)
- `currentYear_original.java.txt` (version defectuosa antes de la
  correccion, conservada como referencia)

## Diseno de los tests

Se escribieron dos tests parametrizados complementarios:

### 1. `casosDeBorde` con `@MethodSource`

Cubre los limites del problema (fin de anio, transicion de anio,
anio bisiesto, varios anios encadenados):

| days  | year esperado | que cubre                    |
|-------|---------------|------------------------------|
| `1`   | `1980`        | caso minimo                  |
| `365` | `1980`        | ultimo dia de 1980 (bisiesto) |
| `366` | `1981`        | primer dia de 1981 (limite)  |
| `367` | `1981`        | 1 + 1 dia de margen          |
| `731` | `1982`        | suma exacta 366 + 365        |
| `1461`| `1984`        | suma exacta 366+365+365+365  |

### 2. `currentYear_debeCoincidirConOracle` con `@ValueSource`

Comparacion diferencial contra `ZuneBug.oracle`, que usa
`LocalDate.plusDays`. Los valores se eligen alrededor de los
limites: `1, 2, 30, 31, 59, 60, 100, 365, 366, 367, 730, 731, 1095,
1461, 10000`.

### Timeout

Ambos tests usan `assertTimeoutPreemptively(Duration.ofMillis(200))`
porque la version defectuosa podia quedarse en un loop infinito y
romper la build. Esto convierte un colgado en un test failure
explicito en lugar de un timeout global.

## Falla detectada

Sobre la version original (`currentYear_original.java.txt`) los tests
detectaban dos sintomas distintos:

- **Loop infinito** cuando `days` quedaba exactamente en `366` en un
  anio bisiesto. La guarda `while (days > 365)` permitia entrar al
  cuerpo pero la rama bisiesta solo descontaba si `days > 366`, asi
  que el bucle no avanzaba nunca.
- **Off-by-one** en transiciones exactas de anio: por ejemplo con
  `days = 731` la version original devolvia un anio menos que el
  oracle.

## Causa del defecto

El metodo original mezclaba las constantes `365` y `366` en distintos
lugares:

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

1. la guarda exterior es `days > 365`, no `days >= 365`, asi que el
   limite exacto no se trata bien;
2. la rama bisiesta usa `days > 366` (mas restrictivo todavia) y, lo
   peor, **no tiene `else`**: si la rama no se cumple, el bucle se
   queda iterando porque las variables no cambian.

## Correccion aplicada

Se reescribio el bucle para que la condicion dependa de cuantos dias
tiene **el anio actual**:

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

La variable `daysInYear` se calcula en funcion de si el anio en curso
es bisiesto. Mientras quedan dias suficientes para completar el anio
en curso (`days >= daysInYear`), se descuentan y se avanza; si no, se
corta y se devuelve el anio. Asi se eliminan el loop infinito (porque
el bucle siempre progresa) y el off-by-one (porque la comparacion
ahora es `>=`).

## Como correr solo este ejercicio

Desde la raiz `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=ZuneBugParameterizedTest test
```

Resultado luego de la correccion:

- `Tests run: 21, Failures: 0, Errors: 0`
- `BUILD SUCCESS`

## Relacion con los conceptos de la materia

- **Differential testing**: el segundo test compara la rutina contra
  `oracle`, que actua como implementacion de referencia
  (`LocalDate.plusDays`). Es un caso pequenio pero claro de uso de
  *test oracle*.
- **Boundary value analysis**: los `casosDeBorde` se eligen alrededor
  de los limites donde sabemos que la logica original fallaba.
- **Defensive testing**: el `assertTimeoutPreemptively` traduce un
  posible hang en una falla diagnosticable.
