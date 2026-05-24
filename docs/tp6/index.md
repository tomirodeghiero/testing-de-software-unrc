---
title: "TP6"
sidebar_position: 1
slug: "/tp6/"
description: "Contenido importado desde tp6/readme.md"
---

# Practico 6

Resolucion del practico 6 de Testing de Software (testing basado en sintaxis: mutacion de
programas con Pitest y fuzzing).

## Resoluciones por ejercicio

- `ejercicio1/README.md` - mutacion sobre `Palindrome.capicua` con Pitest; analisis del unico mutante equivalente.
- `ejercicio2/README.md` - mutacion sobre `TriTyp.triang` con Pitest; suite de 15 tests, score 100%.
- `ejercicio3/README.md` - implementacion de `Mutator`, `MutationFuzzer` y `RandomFuzzer`; test parametrizado sobre `bc`.
- `assignment-6-rodeghiero/` - codigo Java, tests JUnit y configuracion de Pitest (`mvn test`).

## Documentos LaTeX

- `resolucion_practico6.tex` / `.pdf` - resolucion integral del TP6.
- `resumen_teorico_practico6.tex` / `.pdf` - resumen teorico basado en:
  - `material/Capitulo 9 - Introduction to Software Testing.pdf`
  - `material/notas-10-overviewSyntax.pdf`
  - `material/notas-11-mutation.pdf`

## Como compilar los LaTeX

```bash
tectonic resolucion_practico6.tex
tectonic resumen_teorico_practico6.tex
```

o, alternativamente:

```bash
pdflatex resolucion_practico6.tex && pdflatex resolucion_practico6.tex
pdflatex resumen_teorico_practico6.tex && pdflatex resumen_teorico_practico6.tex
```

## Como correr los tests y Pitest

Desde `tp6/assignment-6-rodeghiero`:

```bash
# Suite JUnit (Palindrome, TriTyp y fuzzing/LinuxCommandTest)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test

# Pitest sobre Palindrome (clase por defecto en el pom.xml)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    test org.pitest:pitest-maven:mutationCoverage

# Pitest sobre TriTyp (override por linea de comando)
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -DtargetClasses=assignment6_exercises.TriTyp \
    -DtargetTests=assignment6_exercises.TriTypTest \
    test org.pitest:pitest-maven:mutationCoverage
```

## Navegacion interna

- [Assignment 6 Rodeghiero](./assignment-6-rodeghiero/)
- [Ejercicio 1](./ejercicio1/)
- [Ejercicio 2](./ejercicio2/)
- [Ejercicio 3](./ejercicio3/)

## Material PDF

- [Capitulo 9 - Introduction to Software Testing.pdf](/pdfs/tp6/material/Capitulo 9 - Introduction to Software Testing.pdf)
- [notas-10-overviewSyntax.pdf](/pdfs/tp6/material/notas-10-overviewSyntax.pdf)
- [notas-11-mutation.pdf](/pdfs/tp6/material/notas-11-mutation.pdf)
- [practico6.pdf](/pdfs/tp6/practico6.pdf)
- [resolucion_practico6.pdf](/pdfs/tp6/resolucion_practico6.pdf)
- [resumen_teorico_practico6.pdf](/pdfs/tp6/resumen_teorico_practico6.pdf)
