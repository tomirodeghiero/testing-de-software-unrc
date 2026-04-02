---
title: "Ejercicio 1"
sidebar_position: 1
slug: "/tp7/ejercicio1/"
description: "Contenido importado desde tp7/ejercicio1/README.md"
---

# Ejercicio 1

En este ejercicio se desarrolla sobre `NodeCachingLinkedList` (`assignment7_exercises.ncl`).
La consigna pedía:

1. analizar la implementación,
2. completar `repOK()`,
3. escribir propiedades con generadores apropiados en `jqwik`.

## Código resuelto

- Implementación: [NodeCachingLinkedList.java](../assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/ncl/NodeCachingLinkedList.java)
- Propiedades PBT: [NodeCachingLinkedListPropertiesTest.java](../assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/ncl/NodeCachingLinkedListPropertiesTest.java)

## Qué implementé

### 1) `repOK()` completo

Se implementó el chequeo de invariantes pedidos en la consigna:

- validez de `header` y sus enlaces,
- consistencia de `size`, `cacheSize` y `maximumCacheSize`,
- chequeo de `DEFAULT_MAXIMUM_CACHE_SIZE == 20`,
- recorrido de la lista principal verificando enlaces doblemente encadenados,
- verificación de tamaño real de lista (`size == nodos - 1`),
- recorrido de la cache verificando:
  - aciclicidad,
  - `previous == null`,
  - `value == null`,
  - consistencia exacta con `cacheSize`.

También se asegura que nodos de la cache no pertenezcan simultáneamente a la lista principal.

### 2) Ajuste de inicialización de cache

En el constructor se inicializa `maximumCacheSize` con `DEFAULT_MAXIMUM_CACHE_SIZE`.
Esto deja el comportamiento alineado con la semántica de Node Caching Linked List (siempre existe capacidad de cache por defecto).

## Propiedades escritas en `jqwik`

Se implementaron las 3 propiedades pedidas con generadores específicos:

1. **Luego de remover un elemento de la lista, la cache aumenta en 1**.
2. **Si la cache no está vacía, al agregar un elemento se conserva la suma**:
   `nodos_lista + nodos_cache`.
3. **Eliminar un elemento mantiene `repOK()`**.

Para evitar casos triviales o inválidos, los generadores crean escenarios válidos con:

- listas no vacías,
- índices de remoción dentro de rango,
- estados con cache no vacía para la segunda propiedad.

## Ejecución

Desde `tp7/assignmnet-7-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado: **BUILD SUCCESS** con las 3 propiedades ejecutadas correctamente.

## Nota de entorno

Con Java 25, el `jacoco-maven-plugin 0.8.2` del template falla por incompatibilidad.
Por eso la validación se corrió con Java 17 y `jacoco.skip=true`.
