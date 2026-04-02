---
title: "Ejercicio 6"
sidebar_position: 6
slug: "/tp2/ejercicio6/"
description: "Contenido importado desde tp2/ejercicio6/README.md"
---

# Ejercicio 6

En este ejercicio implemente `repOK()` en `BoundedQueue` y arme tests
parametrizados para verificar que el invariante se mantenga despues de hacer
operaciones de `enQueue()` y `deQueue()`.

## Archivos

- `../src/main/java/assignment2_exercises/queue/BoundedQueue.java`
- `../src/test/java/assignment2_exercises/queue/BoundedQueueParameterizedTest.java`

## Invariante que valida `repOK`

La implementacion chequea, entre otras cosas:

- consistencia basica de la estructura (`elements`, `capacity`, `size`)
- rangos validos de `front` y `back`
- relacion de cola circular: `back == (front + size) % capacity`
- en la zona ocupada no hay `null`
- fuera de la zona ocupada no hay basura (todo `null`)

## Tests parametrizados

Use `@MethodSource` con dos grupos de escenarios:

- escenarios validos: secuencias de `enQueue/deQueue` (incluyendo wrap-around)
  y control de `repOK` despues de cada operacion
- escenarios invalidos: operaciones que deben lanzar excepcion (`deQueue` en
  vacia, `enQueue(null)`, `enQueue` en llena) y verificacion de que `repOK`
  sigue en `true` despues del error

## Como correr solo este ejercicio

Desde `tp2`:

```bash
mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true -Dtest=BoundedQueueParameterizedTest test
```
