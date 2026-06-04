# Práctico 8 — Testing de Software

## Documentos principales

- Enunciado: [`practico8.pdf`](/pdfs/tp8/practico8.pdf)
- Resolución: [`resolucion_practico8.pdf`](/pdfs/tp8/resolucion_practico8.pdf)

## Ejercicios

- `ejercicio1/` — `NodeCachingLinkedList` con Randoop, depuración y métricas JaCoCo/PIT.
- `ejercicio2/` — `fileExample` con Randoop vs EvoSuite, análisis del trade-off.
- `ejercicio3/` — mecanismos de Randoop para mejorar escenarios complejos.
- `ejercicio4/` — tests con `EasyMock` para `IPBlacklist.login`.
- `ejercicio5/` — `fail2ban.Server`: Randoop, EvoSuite, depuración con `repOK()` y propiedad `jqwik` con un único generador.

## Material de referencia

- [Notas 14 — Mocks](/pdfs/tp8/material/notas-14-mocks.pdf)
- [Notas 15 — EvoSuite](/pdfs/tp8/material/notas-15-evosuite.pdf)
- [Notas 16 — Symbolic execution](/pdfs/tp8/material/notas-16-.SymExec.pdf)

## Cómo correr los tests y las herramientas

El código se encuentra en `assignment-8-rodeghiero/`. Recomiendo usar JDK 17 (y JDK 11 para EvoSuite). Desde la carpeta del proyecto:

```bash
cd tp8/assignment-8-rodeghiero

# Compilar
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -DskipTests compile

# Tests JUnit
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -Djacoco.skip=true test

# Cobertura JaCoCo (reporte en target/site/jacoco/)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q test

# Mutation testing con PIT (reporte en target/pit-reports/)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q org.pitest:pitest-maven:mutationCoverage

# Randoop: clase, time-limit (s), output-limit, tests-per-file
./gen-randoop.sh assignment8_exercises.ncl.NodeCachingLinkedList 20 400 200

# EvoSuite (requiere Java 11)
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
    ./gen-evo.sh assignment8_exercises.fail2ban.Server 30
```
