# Proyecto Maven — TP8 (generación automática + mocks + PBT)

Código y tests del Práctico 8 (Testing de Software, UNRC). Combina varias técnicas: generación automática con Randoop y EvoSuite, mocks con EasyMock, y property-based testing con jqwik.

## Contenido

- `src/main/java/assignment8_exercises/ncl/` — `NodeCachingLinkedList` (con `repOK()`) y `LinkedListNode`.
- `src/main/java/assignment8_exercises/fileContents/` — `fileExample`.
- `src/main/java/assignment8_exercises/logging/` — `IPBlacklist`, `LoginService`, `FailedIPLogger`, `Utils`.
- `src/main/java/assignment8_exercises/fail2ban/` — `Server`, `IPBan`, `IP`, `Entry`, `Node`, `ITime`, `RealTime`, `SinglyLinkedList`, `StrictlySortedSinglyLinkedList`.
- `src/test/java/` — tests JUnit, suites de Randoop (`RegressionTest*`) y de EvoSuite (`*_ESTest.java`), tests con EasyMock (`IPBlacklistTest`), propiedad jqwik (`ServerPropertyTest`).
- `gen-randoop.sh` / `gen-evo.sh` — scripts para regenerar las suites con cada herramienta.
- `libs/` — JARs de Randoop y EvoSuite.

## Cómo correr los tests

Hay que usar **JDK 17** (y **JDK 11** para regenerar con EvoSuite). Desde esta carpeta:

```bash
# Compilar
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -DskipTests compile

# Tests JUnit (sin JaCoCo)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -Djacoco.skip=true test

# Tests con cobertura JaCoCo (reporte en target/site/jacoco/)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q test
```

## Cómo regenerar suites con Randoop

```bash
# clase, time-limit (s), output-limit, tests-per-file
./gen-randoop.sh assignment8_exercises.ncl.NodeCachingLinkedList 20 400 200
```

Si necesitás opciones más finas (por ejemplo `--forbid-null`, `--ignore-flaky-tests`), conviene invocar Randoop directamente con `java -classpath ...`. Ver `ejercicio5/README.md`.

## Cómo regenerar suites con EvoSuite (JDK 11)

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
    ./gen-evo.sh assignment8_exercises.fail2ban.Server 30
```

EvoSuite genera dos suites por clase: `<Clase>_ESTest.java` (principal) y `<Clase>_Failed_ESTest.java` (excepciones no declaradas).

## Mutation testing con PIT

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q \
    org.pitest:pitest-maven:mutationCoverage
```

Para apuntar a clases/tests específicos:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q \
    -DtargetClasses=assignment8_exercises.fail2ban.Server \
    -DtargetTests=assignment8_exercises.fail2ban.RegressionTest \
    org.pitest:pitest-maven:mutationCoverage
```

## Reportes

- JaCoCo (HTML): `target/site/jacoco/index.html`
- PIT: `target/pit-reports/`
- Surefire: `target/surefire-reports/`

## Resolución completa

Volver al [README del TP8](../readme.md) para la explicación de cada ejercicio.
