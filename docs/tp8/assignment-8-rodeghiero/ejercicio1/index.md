---
title: "Ejercicio 1"
sidebar_position: 1
slug: "/tp8/assignment-8-rodeghiero/ejercicio1/"
description: "Contenido importado desde tp8/assignment-8-rodeghiero/ejercicio1/README.md"
---

# Ejercicio 1 - NodeCachingLinkedList con Randoop

## Objetivo

Aplicar testing automatico con Randoop sobre `assignment8_exercises.ncl.NodeCachingLinkedList`, analizar resultados, corregir defectos e informar cobertura de ramas y mutacion.

## Trabajo realizado

1. Compilacion del proyecto y generacion de tests con Randoop para `NodeCachingLinkedList`.
2. Analisis de defectos encontrados en la clase.
3. Correccion de defectos y agregado de contrato `repOK`.
4. Regeneracion de la suite para dejar tests de regresión.
5. Ejecucion de cobertura JaCoCo y mutacion PIT.

## Defectos corregidos

En `NodeCachingLinkedList` se corrigieron los dos problemas:

1. `maximumCacheSize` no se inicializaba en el constructor (quedaba en `0`).
2. `repOK()` estaba sin implementar y devolvia siempre `false`.

Además:

- Se implemento `repOK()` completo validando estructura de lista, cache y consistencia interna.
- Se anotó `repOK()` con `@randoop.CheckRep` para que Randoop lo use durante la generacion.

## Comandos usados

Compilacion:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q -DskipTests compile
```

Generacion Randoop:

```bash
./gen-randoop.sh assignment8_exercises.ncl.NodeCachingLinkedList 20 400 200
```

Ejecucion de tests:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q test
```

Mutacion con PIT:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -q org.pitest:pitest-maven:mutationCoverage
```

## Resultados

Suite de regresion:

- 217 tests
- 0 failures
- 0 errors

Cobertura de ramas (JaCoCo) para `NodeCachingLinkedList`:

- Branches cubiertas: 25
- Branches no cubiertas: 45
- Cobertura de ramas: 35.71%

Cobertura de mutacion (PIT):

- Mutaciones generadas: 102
- Mutaciones eliminadas (killed): 39
- Mutation score: 38%
- Mutaciones sin cobertura: 44
- Test strength: 67%

## Archivos utiles

- JaCoCo HTML: `target/site/jacoco/index.html`
- JaCoCo XML: `target/site/jacoco/jacoco.xml`
- PIT: `target/pit-reports`
- Surefire: `target/surefire-reports`

## Nota tecnica

Para ejecutar bien herramientas en este entorno se actualizaron plugins en `pom.xml`:

- `maven-surefire-plugin` a `3.2.5`
- `jacoco-maven-plugin` a `0.8.11`

Tambien se ajusto `gen-randoop.sh` para limitar salida y dejar una suite manejable.
