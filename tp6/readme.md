# Práctico 6 — Testing de Software

## Documentos principales

- Enunciado: [`practico6.pdf`](/pdfs/tp6/practico6.pdf)
- Resolución: [`resolucion_practico6.pdf`](/pdfs/tp6/resolucion_practico6.pdf)

## Ejercicios

- `ejercicio1/` — mutación sobre `Palindrome.capicua` con Pitest. 9 mutantes, score 89%, **1 equivalente justificado**.
- `ejercicio2/` — mutación sobre `TriTyp.triang` con Pitest. 15 tests, score **100%**.
- `ejercicio3/` — fuzzing: implementación de `Mutator`, `MutationFuzzer` y `RandomFuzzer`, más un test parametrizado sobre `bc`.

## Material de referencia

Está todo en `material/`:

- [Capítulo 9 — *Introduction to Software Testing*](/pdfs/tp6/material/Capitulo%209%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 10 — Overview de syntax-based testing](/pdfs/tp6/material/notas-10-overviewSyntax.pdf)
- [Notas 11 — Mutación](/pdfs/tp6/material/notas-11-mutation.pdf)

## Cómo correr los tests y Pitest

El código vive en `assignment-6-rodeghiero/`. Hay que usar JDK 17. Desde la carpeta del proyecto:

```bash
cd tp6/assignment-6-rodeghiero

# Suite JUnit (Palindrome, TriTyp y fuzzing/LinuxCommandTest)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Para Pitest hay dos variantes: el `pom.xml` apunta a `Palindrome` por defecto, así que para `TriTyp` hay que sobrescribir `targetClasses` y `targetTests`.

```bash
# Pitest sobre Palindrome (default del pom)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    test org.pitest:pitest-maven:mutationCoverage

# Pitest sobre TriTyp
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -DtargetClasses=assignment6_exercises.TriTyp \
    -DtargetTests=assignment6_exercises.TriTypTest \
    test org.pitest:pitest-maven:mutationCoverage
```

El `-Djacoco.skip=true` evita el choque entre JaCoCo y Pitest (ambos instrumentan bytecode).
