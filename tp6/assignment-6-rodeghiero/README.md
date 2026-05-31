# Proyecto Maven — TP6 (mutación y fuzzing)

Código y tests del Práctico 6 (Testing de Software, UNRC).

## Contenido

- `src/main/java/assignment6_exercises/` — `Palindrome`, `TriTyp` (clases bajo prueba para Pitest).
- `src/main/java/assignment6_exercises/fuzzing/` — interfaz `Fuzzer` + implementaciones `Mutator`, `MutationFuzzer`, `RandomFuzzer` + utilidades HTTP.
- `src/test/java/assignment6_exercises/` — `PalindromeTests`, `TriTypTest`.
- `src/test/java/assignment6_exercises/fuzzing/` — `LinuxCommandTest` (fuzzing parametrizado sobre `bc`).

## Cómo correr los tests

Hay que usar JDK 17. Desde esta carpeta:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

## Cómo correr Pitest

El `pom.xml` está configurado para que Pitest apunte a `Palindrome` por defecto:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    test org.pitest:pitest-maven:mutationCoverage
```

Para `TriTyp` hay que sobrescribir `targetClasses` y `targetTests`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -DtargetClasses=assignment6_exercises.TriTyp \
    -DtargetTests=assignment6_exercises.TriTypTest \
    test org.pitest:pitest-maven:mutationCoverage
```

El `-Djacoco.skip=true` evita el choque entre JaCoCo y Pitest (ambos instrumentan bytecode).

El reporte de Pitest queda en `target/pit-reports/<timestamp>/index.html`.

## Resolución completa

Volver al [README del TP6](../readme.md) para la explicación de cada ejercicio.
