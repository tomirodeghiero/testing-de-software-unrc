# Practico 5

Resolucion del practico 5 de Testing de Software (testing basado en expresiones logicas:
predicados, clausulas y criterios de cobertura logica).

## Resoluciones por ejercicio

- `ejercicio1/README.md` - cobertura logica sobre cinco predicados (clausulas, tablas de verdad, CC/PC/CACC/RACC).
- `ejercicio2/README.md` - `checkIt()` vs `checkItExpand()`, suite CACC (T1) y Edge Coverage (T2), implementacion JUnit.
- `ejercicio3/README.md` - `Thermostat.turnHeaterOn()`: tests para CC sin PC, PC sin CC y CACC.
- `ejercicio4/README.md` - `TriTyp.triang()`: tests CACC con instrumentacion de predicados.
- `assignment-5-rodeghiero/` - codigo Java, instrumentacion y tests (`mvn test`).

## Documentos LaTeX

- `resolucion_practico5.tex` / `.pdf` - resolucion integral del TP5.
- `resumen_teorico_practico5.tex` / `.pdf` - resumen teorico basado en:
  - `material/Capitulo 8 - Introduction to Software Testing.pdf`
  - `material/notas-09-logicExpr.pdf`
  - `material/notas-09-logicExpr-02.pdf`

## Como compilar los LaTeX

```bash
tectonic resolucion_practico5.tex
tectonic resumen_teorico_practico5.tex
```

o, alternativamente:

```bash
pdflatex resolucion_practico5.tex
pdflatex resolucion_practico5.tex
pdflatex resumen_teorico_practico5.tex
pdflatex resumen_teorico_practico5.tex
```

## Como correr los tests

Desde `tp5/assignment-5-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```
