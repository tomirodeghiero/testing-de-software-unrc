# Ejercicio 3 — `Thermostat.turnHeaterOn()`: CC, PC y CACC

Tests para `turnHeaterOn()` de [`Thermostat.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/main/java/assignment5_exercises/thermostat/Thermostat.java) que cumplan:

1. Cobertura de cláusulas (CC) y, si es posible, sin llegar a cobertura de predicados (PC).
2. Cobertura de predicados (PC) y, si es posible, sin llegar a cobertura de cláusulas (CC).
3. Cobertura correlacionada de cláusulas activas (CACC).

## Predicado principal

```
p = ((a || (b && c)) && d)
```

Cláusulas:

- `a`: `curTemp < dTemp - thresholdDiff`
- `b`: `override`
- `c`: `curTemp < overTemp - thresholdDiff`
- `d`: `timeSinceLastRun > minLag`

## Cómo armé los datos

Para controlar `dTemp` (que es interno del objeto), en todos los tests fijé:

- `setSetting(Period.MORNING, DayType.WEEKDAY, 69)`
- `setPeriod(Period.MORNING)`
- `setDay(DayType.WEEKDAY)`

Y trabajé con `thresholdDiff = 5` y `minLag = 10`. El setup común está en `ThermostatCoverageSupport`.

## a) CC sin PC

**Sí se puede.** Suite:

- `t1 = (a=T, b=F, c=F, d=F)` → `p=F`
- `t2 = (a=F, b=T, c=F, d=T)` → `p=F`
- `t3 = (a=F, b=F, c=T, d=T)` → `p=F`

CC se cumple porque cada cláusula toma `T` y `F` al menos una vez:

- `a`: `T` en `t1`, `F` en `t2,t3`
- `b`: `T` en `t2`, `F` en `t1,t3`
- `c`: `T` en `t3`, `F` en `t1,t2`
- `d`: `T` en `t2,t3`, `F` en `t1`

PC no se cumple: `p` siempre vale `F`.

## b) PC sin CC

**Sí se puede.** Suite:

- `u1 = (a=T, b=T, c=T, d=T)` → `p=T`
- `u2 = (a=T, b=T, c=T, d=F)` → `p=F`

PC se cumple porque `p` toma ambos valores. CC no se cumple: `a`, `b` y `c` nunca toman `F`.

## c) CACC

Pares donde cada cláusula es mayor y determina el resultado del predicado:

| Mayor | Par                             | `p` |
|-------|---------------------------------|-----|
| `a`   | `(T,F,F,T)` vs `(F,F,F,T)`      | `T → F` |
| `b`   | `(F,T,T,T)` vs `(F,F,T,T)`      | `T → F` |
| `c`   | `(F,T,T,T)` vs `(F,T,F,T)`      | `T → F` |
| `d`   | `(T,F,F,T)` vs `(T,F,F,F)`      | `T → F` |

La suite final queda en 6 tests únicos porque varios casos se reutilizan entre pares.

## Ejecución

```bash
cd tp5/assignment-5-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado: 11 tests (5 de `checkit` + 6 de `thermostat`), 0 fallas.

## Archivos

- [`Thermostat.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/main/java/assignment5_exercises/thermostat/Thermostat.java)
- [`ThermostatCoverageSupport.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/test/java/assignment5_exercises/thermostat/ThermostatCoverageSupport.java) — setup común.
- [`ThermostatExercise3ClauseCoverageTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/test/java/assignment5_exercises/thermostat/ThermostatExercise3ClauseCoverageTest.java) — CC sin PC.
- [`ThermostatExercise3PredicateCoverageTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/test/java/assignment5_exercises/thermostat/ThermostatExercise3PredicateCoverageTest.java) — PC sin CC.
- [`ThermostatExercise3CaccTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp5/assignment-5-rodeghiero/src/test/java/assignment5_exercises/thermostat/ThermostatExercise3CaccTest.java) — CACC.

## Enlaces

- Enunciado: [`practico5.pdf`](/pdfs/tp5/practico5.pdf)
- Resolución: [`resolucion_practico5.pdf`](/pdfs/tp5/resolucion_practico5.pdf)
