# Práctico 1 — Testing de Software

## Documentos principales

- Enunciado: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)

## Ejercicios

- `ejercicio1/` — lectura de los capítulos 1 y 2 de *Introduction to Software Testing* (Ammann & Offutt).
- `ejercicio2/` — diferencia entre *fault* y *failure*, y el rol del *error* como estado interno.
- `ejercicio3/` — cuatro programas defectuosos: defecto, reparación y casos según RIPR.
- `ejercicio4/` — los tests del ejercicio 3 trasladados a JUnit y analizados con RIPR.
- `ejercicio5/` — análisis del ejemplo de Bloch: `Point`, `ColorPoint` y `equals`.
- `ejercicio6/` — `Point` y `PointTest`: consistencia entre `equals` y `hashCode`.
- `ejercicio7/` — `PointSet` apoyado en `HashSet<Point>` y tests con AAA.

## Material de referencia

- [Capítulos 1 y 2 — *Introduction to Software Testing*](/pdfs/tp1/material/Capitulos%201%20y%202%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 00](/pdfs/tp1/material/notas-00-testing-de-software.pdf), [Notas 01](/pdfs/tp1/material/notas-01-testing-de-software.pdf), [Notas 02](/pdfs/tp1/material/notas-02-ts.pdf) — slides de la materia.

## Cómo correr los tests

Los ejercicios con código (3 al 7) son proyectos Maven autocontenidos. Para correr cualquiera:

```bash
cd ejercicio4   # o el ejercicio que corresponda
mvn -Dmaven.repo.local=.m2 test
```

El `-Dmaven.repo.local=.m2` mantiene el repo de Maven dentro de la carpeta del ejercicio.
