# Práctico 3 — Testing de Software

## Documentos principales

- Enunciado: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)

## Ejercicios

- `ejercicio1/` — lectura del capítulo 6 (*Input Space Partitioning*) de Ammann & Offutt.
- `ejercicio2/` — `numberOfOcurrences` con cobertura *Pair-Wise* y MDE explícito.
- `ejercicio3/` — análisis del MDE de `intersection` (`SetUtils`) y *Base Choice Coverage*.
- `ejercicio4/` — `PatternIndex` con *Pair-Wise* y dos fallas detectadas en la implementación original.
- `ejercicio5/` — `Iterator` sobre `ArrayList` con *Pair-Wise* (incluye `unmodifiableList`).

## Material de referencia

Está todo en `material/`:

- [Capítulo 6 — *Introduction to Software Testing*](/pdfs/tp3/material/Capitulo%206%20-%20Introduction%20to%20Software%20Testing.pdf)
- [Notas 05 — Criterios de cobertura](/pdfs/tp3/material/notas-05-criterios.pdf)
- [Notas 06 — Input Space Partitioning](/pdfs/tp3/material/notas-06-input.pdf)

## Cómo correr los tests

El código y los tests viven en `assignmnet-3-rodeghiero/` (el typo del nombre viene del template de la cátedra; lo dejé igual). Desde ahí:

```bash
cd tp3/assignmnet-3-rodeghiero
mvn -Dmaven.repo.local=.m2 test
```

Para correr un ejercicio puntual:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=PatternIndexTest test
```
