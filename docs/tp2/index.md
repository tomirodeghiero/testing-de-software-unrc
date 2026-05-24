---
title: "TP2"
sidebar_position: 1
slug: "/tp2/"
description: "Contenido importado desde tp2/readme.md"
---

# Práctico 2 — Testing de Software

Resolución del segundo práctico de la materia. El TP profundiza en testing automatizado con **JUnit 5** y, en particular, en el enfoque *data-driven* a través de `@ParameterizedTest` con sus tres fuentes principales (`@CsvSource`, `@MethodSource`, `@CsvFileSource`). En paralelo, introduce la idea de **invariante de representación** y el método `repOK()` como oráculo interno sobre dos TADs clásicos: la pila acotada `StackAr` y la cola circular `BoundedQueue`. El práctico cierra con un caso real de defecto —el *Zune bug*— como excusa para practicar debugging guiado por tests.

## Documentos principales

- **Enunciado:** [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- **Resolución (PDF):** [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)
- **Resumen teórico (PDF):** [`resumen_teorico_tp2.pdf`](/pdfs/tp2/resumen_teorico_tp2.pdf)
- **Fuente LaTeX:** `resolucion_practico2.tex`, `resumen_teorico_tp2.tex`

## Ejercicios

- `ejercicio1/` — lectura del capítulo 3 de *Introduction to Software Testing* (Ammann & Offutt): test requirements, criterios de cobertura, MDTD y *arrange–act–assert*.
- `ejercicio2/` — tests parametrizados sobre `SimpleRoutines` con `@CsvSource`, `@MethodSource` y `@CsvFileSource`.
- `ejercicio3/` — suite completa para `StackAr` con fixture compartido, AAA explícito y `repOk` con su propio juego de tests.
- `ejercicio4/` — tests parametrizados en CSV para `Min.min`, incluyendo casos negativos.
- `ejercicio5/` — tests parametrizados y debugging del *Zune bug* en `ZuneBug.currentYear`.
- `ejercicio6/` — `repOK` y tests parametrizados para `BoundedQueue` con escenarios válidos e inválidos.

## Código base (provisto por la cátedra)

- `src/main/java/assignment2_exercises/SimpleRoutines.java`
- `src/main/java/assignment2_exercises/Min.java`
- `src/main/java/assignment2_exercises/ZuneBug.java`
- `src/main/java/assignment2_exercises/stack/Stack.java`
- `src/main/java/assignment2_exercises/stack/StackAr.java`
- `src/main/java/assignment2_exercises/queue/BoundedQueue.java`

## Artefactos agregados

- **Ej. 2**: `SimpleRoutinesParameterizedTest.java`, `odd_or_pos_cases.csv`.
- **Ej. 3**: `StackArTest.java`, implementación de `repOk()` y ajustes en `pop()` y `push(null)` sobre `StackAr.java`.
- **Ej. 4**: `MinCsvParameterizedTest.java`, `min_valid_cases.csv`, `min_invalid_cases.csv`.
- **Ej. 5**: `ZuneBugParameterizedTest.java`, corrección de `currentYear` y copia de la versión original en `ejercicio5/currentYear_original.java.txt`.
- **Ej. 6**: `BoundedQueueParameterizedTest.java`, implementación de `repOK()` en `BoundedQueue.java`.

## Material de referencia

Los apuntes y capítulos usados están en `material/`:

- `Capitulo 3 - Introduction to Software Testing.pdf` — Ammann & Offutt, capítulo 3.
- `notas-03-automation.pdf` — automatización de tests.
- `notas-04-data-driven-test.pdf` — data-driven testing.

## Cómo ejecutar la suite

Desde la raíz `tp2`, usando un repositorio Maven local aislado en `.m2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

El flag `-Djacoco.skip=true` se usa porque el plugin JaCoCo declarado en `pom.xml` (`0.8.2`) es viejo y rompe la build con JDK actuales. Para correr la suite de un único ejercicio basta con agregar `-Dtest=<NombreDeClase>`. Por ejemplo:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=StackArTest test
```

## Navegacion interna

- [Ejercicio 1](./ejercicio1/)
- [Ejercicio 2](./ejercicio2/)
- [Ejercicio 3](./ejercicio3/)
- [Ejercicio 4](./ejercicio4/)
- [Ejercicio 5](./ejercicio5/)
- [Ejercicio 6](./ejercicio6/)

## Material PDF

- [Capitulo 3 - Introduction to Software Testing.pdf](/pdfs/tp2/material/Capitulo 3 - Introduction to Software Testing.pdf)
- [notas-03-automation.pdf](/pdfs/tp2/material/notas-03-automation.pdf)
- [notas-04-data-driven-test.pdf](/pdfs/tp2/material/notas-04-data-driven-test.pdf)
- [practico2.pdf](/pdfs/tp2/practico2.pdf)
- [resolucion_practico2.pdf](/pdfs/tp2/resolucion_practico2.pdf)
- [resumen_teorico_tp2.pdf](/pdfs/tp2/resumen_teorico_tp2.pdf)
