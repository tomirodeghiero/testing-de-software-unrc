# Práctico 3 — Testing de Software

Resolución del tercer práctico de la materia. El eje del TP es el **Particionado del Espacio de Entradas** (*Input Space Partitioning*, ISP) y los criterios de cobertura combinatoria asociados: *Each Choice*, *Pair-Wise*, *Base Choice* y *All Combinations*. Cada ejercicio sigue el flujo recomendado por Ammann y Offutt: identificar la unidad bajo prueba, construir un **Modelo del Dominio de Entradas** (MDE) a partir de la especificación, declarar restricciones de factibilidad, aplicar un criterio para derivar requisitos de test, e instanciar valores concretos.

## Documentos principales

- **Enunciado:** [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- **Resolución (PDF):** [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
- **Resumen teórico (PDF):** [`resumen_teorico_practico3.pdf`](/pdfs/tp3/resumen_teorico_practico3.pdf)
- **Fuente LaTeX:** `resolucion_practico3.tex`, `resumen_teorico_practico3.tex`

## Ejercicios

- `ejercicio1/` — lectura del capítulo 6 (*Input Space Partitioning*) de Ammann & Offutt.
- `ejercicio2/` — `numberOfOcurrences` con cobertura *Pair-Wise* y MDE explícito.
- `ejercicio3/` — análisis del MDE de `intersection` (`SetUtils`) y *Base Choice Coverage*.
- `ejercicio4/` — `PatternIndex` con *Pair-Wise* y detección de fallas en la implementación original.
- `ejercicio5/` — `Iterator` sobre `ArrayList` con *Pair-Wise* y caso `unmodifiableList`.

## Código

El código y los tests JUnit 5 viven en `assignmnet-3-rodeghiero/`. El nombre de la carpeta replica el del template provisto por la cátedra y se mantiene tal cual (incluyendo el typo `assignmnet`).

- `assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/ListUtils.java`
- `assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/SetUtils.java`
- `assignmnet-3-rodeghiero/src/main/java/assignment3_exercises/PatternIndex.java`
- `assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/numberOfOcurrencesTest.java`
- `assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/IntersectionTest.java`
- `assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/PatternIndexTest.java`
- `assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/IteratorArrayListTest.java`

## Material de referencia

Los apuntes y capítulos usados están en `material/`:

- `Capitulo 6 - Introduction to Software Testing.pdf` — Ammann & Offutt, capítulo 6.
- `notas-05-criterios.pdf` — notas de cátedra sobre criterios de cobertura.
- `notas-06-input.pdf` — notas de cátedra sobre *input space partitioning*.

## Cómo ejecutar la suite

Desde `tp3/assignmnet-3-rodeghiero`, usando un repositorio Maven local aislado en `.m2`:

```bash
mvn -Dmaven.repo.local=.m2 test
```

Para correr una suite puntual:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=PatternIndexTest test
```
