# Práctico 7 — Testing de Software

## Documentos principales

- Resolución: [`resolucion_practico7.pdf`](/pdfs/tp7/resolucion_practico7.pdf)

> El enunciado original (`practico7.pdf`) no se conserva en el repo. Cada ejercicio describe su consigna en el README correspondiente.

## Ejercicios

- `ejercicio1/` — `NodeCachingLinkedList`: implementación de `repOK()` y tres propiedades sobre la cache y la remoción.
- `ejercicio2/` — `Point`: contrato `equals`/`hashCode`, generador `@Provide` y propiedad de distancia en recta horizontal.
- `ejercicio3/` — `Date`: constructor con validación, `addDays` por bloques de mes y propiedad de validez del resultado.

## Material de referencia

Está todo en `material/`:

- [Notas 12 — Property-Based Testing](/pdfs/tp7/material/notas-12-pbt.pdf)
- [Notas 13 — Generación aleatoria](/pdfs/tp7/material/notas-13-generacion-aleatoria.pdf)

## Cómo correr los tests

El código vive en `assignmnet-7-rodeghiero/` (el typo `assignmnet` es del template de la cátedra). Hay que usar JDK 17. Desde la carpeta del proyecto:

```bash
cd tp7/assignmnet-7-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Para una suite puntual:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=DatePropertiesTest test
```

El `-Djacoco.skip=true` evita el problema con el plugin JaCoCo `0.8.2` del template (incompatible con JDK >= 17).
