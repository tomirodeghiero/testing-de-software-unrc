# Práctico 2 — Testing de Software

## Documentos principales

- Enunciado: [`practico2.pdf`](/pdfs/tp2/practico2.pdf)
- Resolución: [`resolucion_practico2.pdf`](/pdfs/tp2/resolucion_practico2.pdf)

## Ejercicios

- `ejercicio1/` — lectura del capítulo 3 de *Introduction to Software Testing* (Ammann & Offutt): TRs, criterios de cobertura, MDTD y AAA.
- `ejercicio2/` — tests parametrizados sobre `SimpleRoutines` con `@CsvSource`, `@MethodSource` y `@CsvFileSource`.
- `ejercicio3/` — suite completa para `StackAr` con fixture compartido, AAA explícito y `repOk` (más reflexión para los casos negativos).
- `ejercicio4/` — tests parametrizados en CSV para `Min.min`, con casos negativos para las tres excepciones.
- `ejercicio5/` — tests parametrizados y debugging del *Zune bug* en `ZuneBug.currentYear`.
- `ejercicio6/` — `repOK` y tests parametrizados para `BoundedQueue` (escenarios válidos e inválidos con un mini-DSL).

## Material de referencia

Está todo en `material/`:

- [Capítulo 3 — *Introduction to Software Testing*](/pdfs/tp2/material/Capitulo%203%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 03 — Automation](/pdfs/tp2/material/notas-03-automation.pdf)
- [Notas 04 — Data-driven testing](/pdfs/tp2/material/notas-04-data-driven-test.pdf)

## Cómo correr los tests

A diferencia del TP1, todos los ejercicios del TP2 viven en **un único proyecto Maven** en la raíz del TP. Para correr toda la suite:

```bash
cd tp2
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

El `-Djacoco.skip=true` evita que se cuelgue por el plugin JaCoCo `0.8.2` del template (no compatibiliza con JDK >= 11). Para correr solo un ejercicio:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=StackArTest test
```
