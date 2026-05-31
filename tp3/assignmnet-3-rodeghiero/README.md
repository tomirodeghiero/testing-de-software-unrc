# Proyecto Maven — TP3 (Input Space Partitioning)

Código y tests del Práctico 3 (Testing de Software, UNRC). El nombre del directorio mantiene el typo `assignmnet` del template original de la cátedra.

## Contenido

- `src/main/java/assignment3_exercises/` — implementaciones (`ListUtils`, `SetUtils`, `PatternIndex`).
- `src/test/java/assignment3_exercises/` — suites JUnit 5 (`numberOfOcurrencesTest`, `IntersectionTest`, `PatternIndexTest`, `IteratorArrayListTest`).

## Cómo correr los tests

Desde esta carpeta:

```bash
mvn -Dmaven.repo.local=.m2 test
```

Para un ejercicio puntual:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=PatternIndexTest test
```

El `-Dmaven.repo.local=.m2` mantiene el repositorio Maven dentro de la carpeta del proyecto, así no contamina `~/.m2/`.

## Resolución completa

Volver al [README del TP3](../readme.md) para la explicación de cada ejercicio.
