---
title: "TP5"
sidebar_position: 1
slug: "/tp5/"
description: "Contenido importado desde tp5/readme.md"
---

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

## Navegacion interna

- [Assignment 5 Rodeghiero](./assignment-5-rodeghiero/)
- [Ejercicio 1](./ejercicio1/)
- [Ejercicio 2](./ejercicio2/)
- [Ejercicio 3](./ejercicio3/)
- [Ejercicio 4](./ejercicio4/)

## Material PDF

- [Capitulo 8 - Introduction to Software Testing.pdf](/pdfs/tp5/Capitulo 8 - Introduction to Software Testing.pdf)
- [Capitulo 8 - Introduction to Software Testing.pdf](/pdfs/tp5/material/Capitulo 8 - Introduction to Software Testing.pdf)
- [notas-09-logicExpr-02.pdf](/pdfs/tp5/material/notas-09-logicExpr-02.pdf)
- [notas-09-logicExpr.pdf](/pdfs/tp5/material/notas-09-logicExpr.pdf)
- [practico5.pdf](/pdfs/tp5/practico5.pdf)
- [resolucion_practico5.pdf](/pdfs/tp5/resolucion_practico5.pdf)
- [resumen_teorico_practico5.pdf](/pdfs/tp5/resumen_teorico_practico5.pdf)
