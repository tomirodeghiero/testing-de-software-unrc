# Proyecto Maven — TP5 (cobertura lógica)

Código y tests del Práctico 5 (Testing de Software, UNRC).

## Contenido

- `src/main/java/assignment5_exercises/checkit/` — `CheckIt` con `checkIt` y `checkItExpand`.
- `src/main/java/assignment5_exercises/thermostat/` — `Thermostat`, `Period`, `DayType`, `ProgrammedSettings`.
- `src/main/java/assignment5_exercises/triangle/` — `TriTyp.triang`.
- `src/test/java/assignment5_exercises/checkit/` — `CheckItT1CaccTest`, `CheckItT2EdgeCoverageTest`.
- `src/test/java/assignment5_exercises/thermostat/` — tres suites (CC, PC, CACC) + `ThermostatCoverageSupport`.
- `src/test/java/assignment5_exercises/triangle/` — `TriTypExercise4CaccTest` + `TriTypTraceSupport`.

## Cómo correr los tests

Hay que usar JDK 17. Desde esta carpeta:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Para una suite puntual:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=TriTypExercise4CaccTest test
```

El `-Djacoco.skip=true` evita el problema con el plugin JaCoCo `0.8.2` del template (no es compatible con JDK 17). El `-Dmaven.repo.local=.m2` mantiene el repositorio Maven dentro de la carpeta del proyecto.

## Resolución completa

Volver al [README del TP5](../readme.md) para la explicación de cada ejercicio.
