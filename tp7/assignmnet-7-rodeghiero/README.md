# Proyecto Maven — TP7 (Property-Based Testing con jqwik)

Código y tests del Práctico 7. El nombre del directorio mantiene el typo `assignmnet` del template original de la cátedra.

## Contenido

- `src/main/java/assignment7_exercises/ncl/` — `NodeCachingLinkedList` (con `repOK()`) y `LinkedListNode`.
- `src/main/java/assignment7_exercises/point/` — `Point` con `equals`/`hashCode`.
- `src/main/java/assignment7_exercises/date/` — `Date` con constructor, `repOk` y `addDays`.
- `src/test/java/assignment7_exercises/` — tres suites jqwik (`NodeCachingLinkedListPropertiesTest`, `PointPropertiesTest`, `DatePropertiesTest`), una por ejercicio.

## Cómo correr los tests

Recomiendo usar JDK 17. Desde esta carpeta:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Para una suite puntual:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=DatePropertiesTest test
```

El `-Djacoco.skip=true` evita el problema con el plugin JaCoCo `0.8.2` del template (incompatible con JDK >= 17). El `-Dmaven.repo.local=.m2` mantiene el repositorio Maven dentro de la carpeta del proyecto.

## Resolución completa

Volver al [README del TP7](../readme.md) para la explicación de cada ejercicio.
