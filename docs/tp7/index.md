---
title: "TP7"
sidebar_position: 1
slug: "/tp7/"
description: "Contenido importado desde tp7/readme.md"
---

# Practico 7

Resolucion del practico 7 de Testing de Software (Property-Based Testing con `jqwik` y
generacion aleatoria de inputs).

## Resoluciones por ejercicio

- `ejercicio1/README.md` - `NodeCachingLinkedList`: implementacion de `repOK()` y tres propiedades sobre cache y remocion.
- `ejercicio2/README.md` - `Point`: contrato `equals/hashCode`, generador `@Provide` y propiedad de distancia en recta horizontal.
- `ejercicio3/README.md` - `Date`: constructor con validacion, `addDays` por bloques de mes y propiedad de validez del resultado.
- `assignmnet-7-rodeghiero/` - codigo Java con `jqwik` (`mvn test`).

## Documentos LaTeX

- `resolucion_practico7.tex` / `.pdf` - resolucion integral del TP7.
- `resumen_teorico_practico7.tex` / `.pdf` - resumen teorico basado en:
  - `material/notas-12-pbt.pdf`
  - `material/notas-13-generacion-aleatoria.pdf`

## Como compilar los LaTeX

```bash
tectonic resolucion_practico7.tex
tectonic resumen_teorico_practico7.tex
```

o, alternativamente:

```bash
pdflatex resolucion_practico7.tex && pdflatex resolucion_practico7.tex
pdflatex resumen_teorico_practico7.tex && pdflatex resumen_teorico_practico7.tex
```

## Como correr los tests

Desde `tp7/assignmnet-7-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

## Navegacion interna

- [Assignment 7 Rodeghiero](./assignmnet-7-rodeghiero/)
- [Ejercicio 1](./ejercicio1/)
- [Ejercicio 2](./ejercicio2/)
- [Ejercicio 3](./ejercicio3/)

## Material PDF

- [notas-12-pbt.pdf](/pdfs/tp7/material/notas-12-pbt.pdf)
- [notas-13-generacion-aleatoria.pdf](/pdfs/tp7/material/notas-13-generacion-aleatoria.pdf)
- [resolucion_practico7.pdf](/pdfs/tp7/resolucion_practico7.pdf)
- [resumen_teorico_practico7.pdf](/pdfs/tp7/resumen_teorico_practico7.pdf)
