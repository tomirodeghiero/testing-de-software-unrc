# Proyecto Maven — TP4 (testing basado en grafos)

Código y tests del Práctico 4 (Testing de Software, UNRC). El nombre del directorio mantiene el typo `assignmnet` del template original de la cátedra.

## Contenido

- `src/main/java/assignment4_exercises/` — implementaciones (`FmtRewrap`, `PatternIndex`) y la instrumentación (`PatternIndexPathTracker`).
- `src/test/java/assignment4_exercises/` — suites JUnit (3 para `FmtRewrap` cubriendo NC, EC y PPC; 1 para `PatternIndex` con instrumentación y reporte).

## Cómo correr los tests

Hay que usar JDK 17 porque la build se apoya en JaCoCo para reportar cobertura. Desde esta carpeta:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 test
```

Para una suite puntual:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 \
    -Dtest=FmtRewrapPrimePathBestEffortCoverageTest test
```

El `-Dmaven.repo.local=.m2` mantiene el repositorio Maven dentro de la carpeta del proyecto, así no contamina `~/.m2/`.

## Reporte de cobertura

`PatternIndexInstrumentationCoverageTest` genera un reporte en `target/patternindex-path-report.txt` con los caminos ejecutados y la cobertura de arcos y prime paths sobre el CFG instrumentado.

