---
title: "Ejercicio 2"
sidebar_position: 2
slug: "/tp6/ejercicio2/"
description: "Contenido importado desde tp6/ejercicio2/README.md"
---

# Ejercicio 2

En este ejercicio hice mutación con PIT para el método `triang` de `TriTyp`.
El objetivo fue construir una suite JUnit suficientemente fuerte como para matar todos los mutantes del método y justificar los resultados.

## Código analizado

- Método bajo test: [TriTyp.java](../assignment-6-rodeghiero/src/main/java/assignment6_exercises/TriTyp.java)
- Suite de tests: [TriTypTest.java](../assignment-6-rodeghiero/src/test/java/assignment6_exercises/TriTypTest.java)

## Ejecución de PIT para TriTyp

Como el `pom.xml` venía apuntando por defecto a `Palindrome`, para este ejercicio corrí PIT con override:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -DtargetClasses=assignment6_exercises.TriTyp -DtargetTests=assignment6_exercises.TriTypTest test org.pitest:pitest-maven:mutationCoverage
```

## Suite de tests que construí

La suite final quedó con **15 tests** y cubre:

1. Equilátero válido.
2. Escaleno válido.
3. Escaleno no-triángulo por igualdad de suma (las 3 permutaciones).
4. Escaleno no-triángulo por desigualdad estricta.
5. Isósceles válidos en las 3 variantes (`S1==S2`, `S1==S3`, `S2==S3`).
6. Isósceles no-triángulo en las 3 variantes.
7. Casos con lado no positivo en cada posición.

Con esto se activan todas las decisiones importantes de `triang` y se alcanzan todos los mutantes generados por PIT.

## Respuestas

### a) ¿Cuántos mutantes generó la herramienta?

PIT generó **39 mutantes**.

### b) ¿Cuántos tests definió para matar todos los mutantes?

Definí **15 tests** en `TriTypTest`.

### c) ¿Qué puntaje de mutación obtuvo antes de analizar mutantes equivalentes?

El puntaje final fue **100% (39/39)**.

Dato de evolución:

- línea base inicial con 1 test: **23% (9/39)**
- suite final: **100% (39/39)**

### d) ¿Cuántos mutantes equivalentes hay? Justifique

En esta corrida quedaron **0 mutantes equivalentes observados**.

Justificación práctica: el reporte final de PIT quedó sin sobrevivientes (`KILLED 39 / GENERATED 39`), por lo tanto no fue necesario identificar equivalentes para cerrar el ejercicio.

## Cierre

- Mutantes generados: **39**
- Mutantes muertos: **39**
- Score bruto: **100%**
- Mutantes equivalentes observados: **0**
