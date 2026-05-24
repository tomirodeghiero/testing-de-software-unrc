---
title: "TP2"
sidebar_position: 1
slug: "/tp2/"
description: "Contenido importado desde tp2/readme.md"
---

# Practico 2 - Testing de Software 2024

Resolucion del Practico 2 de la materia. El TP se centra en data-driven
testing con JUnit 5 (`@ParameterizedTest`), repOK / invariantes de
representacion sobre TADs (`StackAr` y `BoundedQueue`), y debugging guiado
por tests parametrizados (`ZuneBug`). Se trabaja con el codigo provisto
por la catedra en `assignment2_exercises/`, sin modificar el enunciado ni
los PDFs.

## Estructura

Las resoluciones estan organizadas por ejercicio, igual que en el TP1:

- `ejercicio1/README.md` - lectura del capitulo 3 de Ammann & Offutt.
- `ejercicio2/README.md` - tests parametrizados sobre `SimpleRoutines`.
- `ejercicio3/README.md` - tests para `StackAr`, fixture compartido,
  arrange / act / assert y `repOk`.
- `ejercicio4/README.md` - tests parametrizados en CSV para `Min`.
- `ejercicio5/README.md` - tests parametrizados y debugging del
  *Zune bug* en `currentYear`.
- `ejercicio6/README.md` - `repOK` y tests parametrizados para
  `BoundedQueue`.

## Codigo base (provisto por la catedra)

- `src/main/java/assignment2_exercises/SimpleRoutines.java`
- `src/main/java/assignment2_exercises/Min.java`
- `src/main/java/assignment2_exercises/ZuneBug.java`
- `src/main/java/assignment2_exercises/stack/Stack.java`
- `src/main/java/assignment2_exercises/stack/StackAr.java`
- `src/main/java/assignment2_exercises/queue/BoundedQueue.java`

## Artefactos agregados

### Ejercicio 2 - `SimpleRoutines`

- `src/test/java/assignment2_exercises/SimpleRoutinesParameterizedTest.java`
- `src/test/resources/assignment2_exercises/odd_or_pos_cases.csv`

Se cumple el requisito de la consigna: `@CsvSource` en `findLast`,
`@MethodSource` en `lastZero` y `countPositive`, y `@CsvFileSource` en
`oddOrPos`. La suite reutiliza los casos (c) y (d) del Practico 1, asi
que sobre la version defectuosa de `SimpleRoutines` provista en este
practico los tests fallan exactamente en los 4 casos que evidencian
cada uno de los defectos. Esto es deseado: muestra que los tests
parametrizados conservan la capacidad de detectar las fallas del modelo
RIPR establecida en el TP1.

### Ejercicio 3 - `StackAr`

- `src/test/java/assignment2_exercises/stack/StackArTest.java`
- implementacion completa de `repOk()` en `StackAr.java`
- ajustes menores en `pop()` y validacion de `push(null)`.

### Ejercicio 4 - `Min`

- `src/test/java/assignment2_exercises/MinCsvParameterizedTest.java`
- `src/test/resources/assignment2_exercises/min_valid_cases.csv`
- `src/test/resources/assignment2_exercises/min_invalid_cases.csv`

### Ejercicio 5 - `ZuneBug`

- `src/test/java/assignment2_exercises/ZuneBugParameterizedTest.java`
- correccion del defecto en `currentYear` de
  `src/main/java/assignment2_exercises/ZuneBug.java`
- copia de la version original en
  `ejercicio5/currentYear_original.java.txt`.

### Ejercicio 6 - `BoundedQueue`

- `src/test/java/assignment2_exercises/queue/BoundedQueueParameterizedTest.java`
- implementacion de `repOK()` en
  `src/main/java/assignment2_exercises/queue/BoundedQueue.java`.

## Como ejecutar la suite

Desde la raiz `tp2`, usando un repositorio local Maven aislado en `.m2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

El flag `-Djacoco.skip=true` se usa porque el plugin JaCoCo declarado en
`pom.xml` (`0.8.2`) es viejo y rompe la build con JDK actuales. Para
ejecutar la suite de un unico ejercicio basta con agregar
`-Dtest=<NombreDeClase>`. Por ejemplo:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=StackArTest test
```

## Documentos adicionales

- `resolucion_practico2.tex` y `resolucion_practico2.pdf`: resolucion
  completa del TP en formato academico, con la misma estructura usada
  para el TP1.
- `resumen_teorico_tp2.tex` y `resumen_teorico_tp2.pdf`: resumen
  teorico basado en la carpeta `material/` (capitulo 3 de Ammann &
  Offutt, notas 03 sobre automatizacion y notas 04 sobre data-driven
  testing).

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
