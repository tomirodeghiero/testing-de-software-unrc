# Practico 8

Resolucion del practico 8 de Testing de Software: generacion automatica de tests
(\textbf{Randoop} y \textbf{EvoSuite}), \textbf{mocking} con \texttt{EasyMock} y
\textbf{property-based testing} con \texttt{jqwik} sobre `fail2ban.Server`.

## Resoluciones por ejercicio

Estan dentro de `assignment-8-rodeghiero/`:

- `assignment-8-rodeghiero/ejercicio1/README.md` - `NodeCachingLinkedList` con Randoop, depuracion y metricas JaCoCo/PIT.
- `assignment-8-rodeghiero/ejercicio2/README.md` - `fileExample` con Randoop vs EvoSuite, analisis del trade-off.
- `assignment-8-rodeghiero/ejercicio3/README.md` - mecanismos de Randoop para mejorar escenarios complejos.
- `assignment-8-rodeghiero/ejercicio4/README.md` - tests con `EasyMock` para `IPBlacklist.login`.
- `assignment-8-rodeghiero/ejercicio5/README.md` - `fail2ban.Server`: Randoop, EvoSuite, depuracion con `repOK()` y propiedad `jqwik` con un unico generador.

## Documentos LaTeX

- `resolucion_practico8.tex` / `.pdf` - resolucion integral del TP8.
- `resumen_teorico_practico8.tex` / `.pdf` - resumen teorico basado en:
  - `material/notas-14-mocks.pdf`
  - `material/notas-15-evosuite.pdf`
  - `material/notas-16-.SymExec.pdf`

## Como compilar los LaTeX

```bash
tectonic resolucion_practico8.tex
tectonic resumen_teorico_practico8.tex
```

o, alternativamente:

```bash
pdflatex resolucion_practico8.tex && pdflatex resolucion_practico8.tex
pdflatex resumen_teorico_practico8.tex && pdflatex resumen_teorico_practico8.tex
```

## Como correr los tests y herramientas

Desde `tp8/assignment-8-rodeghiero`:

```bash
# Compilar
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -DskipTests compile

# Randoop (clase, tiempo en segundos, outputlimit, testsperfile)
./gen-randoop.sh assignment8_exercises.ncl.NodeCachingLinkedList 20 400 200

# EvoSuite (requiere Java 11)
JAVA_HOME=$(/usr/libexec/java_home -v 11) PATH=$JAVA_HOME/bin:$PATH \
    ./gen-evo.sh assignment8_exercises.fail2ban.Server 30

# Tests
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -Djacoco.skip=true test

# Cobertura JaCoCo (informe en target/site/jacoco/)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q test

# Mutation testing con PIT
JAVA_HOME=$(/usr/libexec/java_home -v 17) \
    mvn -q org.pitest:pitest-maven:mutationCoverage
```
