# Ejercicio 3

En este ejercicio se piden tests para `turnHeaterOn()` de `Thermostat.java` que cumplan:

1. Cobertura de cláusulas (CC) y, si se puede, sin llegar a cobertura de predicados (PC).
2. Cobertura de predicados (PC) y, si se puede, sin llegar a cobertura de cláusulas (CC).
3. Cobertura correlacionada de cláusulas activas (CACC).

Archivo bajo test:

- [Thermostat.java](../assignment-5-rodeghiero/src/main/java/assignment5_exercises/thermostat/Thermostat.java)

Predicado principal analizado:

`p = ((a || (b && c)) && d)`

Cláusulas:

- `a`: `curTemp < dTemp - thresholdDiff`
- `b`: `override`
- `c`: `curTemp < overTemp - thresholdDiff`
- `d`: `timeSinceLastRun > minLag`

## Criterio que usé para diseñar los datos

Para controlar `dTemp` (que es interno del objeto), en todos los tests fijé:

- `setSetting(Period.MORNING, DayType.WEEKDAY, 69)`
- `setPeriod(Period.MORNING)`
- `setDay(DayType.WEEKDAY)`

Además trabajé con:

- `thresholdDiff = 5`
- `minLag = 10`

Soporte común implementado:

- [ThermostatCoverageSupport.java](../assignment-5-rodeghiero/src/test/java/assignment5_exercises/thermostat/ThermostatCoverageSupport.java)

## a) CC y, si es posible, sin PC

Sí, en este caso se puede lograr CC sin alcanzar PC.

Suite propuesta:

- `t1 = (a=T, b=F, c=F, d=F)` -> `p=F`
- `t2 = (a=F, b=T, c=F, d=T)` -> `p=F`
- `t3 = (a=F, b=F, c=T, d=T)` -> `p=F`

Justificación:

1. CC se cumple porque cada cláusula toma `T` y `F` al menos una vez:
- `a`: `T` en `t1`, `F` en `t2,t3`
- `b`: `T` en `t2`, `F` en `t1,t3`
- `c`: `T` en `t3`, `F` en `t1,t2`
- `d`: `T` en `t2,t3`, `F` en `t1`

2. PC no se cumple porque `p` siempre vale `F`.

Implementación:

- [ThermostatExercise3ClauseCoverageTest.java](../assignment-5-rodeghiero/src/test/java/assignment5_exercises/thermostat/ThermostatExercise3ClauseCoverageTest.java)

## b) PC y, si es posible, sin CC

Sí, también se puede lograr PC sin cubrir CC.

Suite propuesta:

- `u1 = (a=T, b=T, c=T, d=T)` -> `p=T`
- `u2 = (a=T, b=T, c=T, d=F)` -> `p=F`

Justificación:

1. PC se cumple porque `p` toma ambos valores (`T` y `F`).
2. CC no se cumple porque:
- `a` nunca toma `F`
- `b` nunca toma `F`
- `c` nunca toma `F`

Implementación:

- [ThermostatExercise3PredicateCoverageTest.java](../assignment-5-rodeghiero/src/test/java/assignment5_exercises/thermostat/ThermostatExercise3PredicateCoverageTest.java)

## c) CACC

Para CACC armé pares donde cada cláusula sea mayor y efectivamente determine el resultado del predicado.

Pares usados:

1. Mayor `a`:
- `(T,F,F,T)` vs `(F,F,F,T)` -> `p` cambia `T -> F`

2. Mayor `b`:
- `(F,T,T,T)` vs `(F,F,T,T)` -> `p` cambia `T -> F`

3. Mayor `c`:
- `(F,T,T,T)` vs `(F,T,F,T)` -> `p` cambia `T -> F`

4. Mayor `d`:
- `(T,F,F,T)` vs `(T,F,F,F)` -> `p` cambia `T -> F`

Observación:

- La suite final queda en 6 tests únicos porque varios casos se reutilizan entre pares.

Implementación:

- [ThermostatExercise3CaccTest.java](../assignment-5-rodeghiero/src/test/java/assignment5_exercises/thermostat/ThermostatExercise3CaccTest.java)

## Ejecución de tests

Desde `tp5/assignment-5-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado en este entorno:

- `BUILD SUCCESS`
- tests de `checkit` (ejercicio 2): 5 OK
- tests de `thermostat` (ejercicio 3): 6 OK

Total: 11 tests, 0 fallas.

Nota:

- Se usa `-Djacoco.skip=true` porque el plugin JaCoCo del template (`0.8.2`) no es compatible con la JVM disponible.
