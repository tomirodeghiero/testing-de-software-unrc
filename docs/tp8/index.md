---
title: "TP8"
sidebar_position: 1
slug: "/tp8/"
description: "Contenido importado desde tp8/readme.md"
---

# Practico 8

Resolucion del practico 8 de Testing de Software: generacion automatica de tests
(**Randoop** y **EvoSuite**), **mocking** con `EasyMock` y
**property-based testing** con `jqwik` sobre `fail2ban.Server`.

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

## Navegacion interna

- [Ejercicio 1](./assignment-8-rodeghiero/ejercicio1/)
- [Ejercicio 2](./assignment-8-rodeghiero/ejercicio2/)
- [Ejercicio 3](./assignment-8-rodeghiero/ejercicio3/)
- [Ejercicio 4](./assignment-8-rodeghiero/ejercicio4/)
- [Ejercicio 5](./assignment-8-rodeghiero/ejercicio5/)
- [Assignment 8 Rodeghiero](./assignment-8-rodeghiero/)

## Material PDF

- [notas-14-mocks.pdf](/pdfs/tp8/material/notas-14-mocks.pdf)
- [notas-15-evosuite.pdf](/pdfs/tp8/material/notas-15-evosuite.pdf)
- [notas-16-.SymExec.pdf](/pdfs/tp8/material/notas-16-.SymExec.pdf)
- [resolucion_practico8.pdf](/pdfs/tp8/resolucion_practico8.pdf)
- [resumen_teorico_practico8.pdf](/pdfs/tp8/resumen_teorico_practico8.pdf)
