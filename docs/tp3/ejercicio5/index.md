---
title: "Ejercicio 5"
sidebar_position: 5
slug: "/tp3/ejercicio5/"
description: "Contenido importado desde tp3/ejercicio5/README.md"
---

# Ejercicio 5 — `Iterator` sobre `ArrayList` con *Pair-Wise*

## Consigna

Aplicar *Input Space Partitioning* sobre la interfaz `java.util.Iterator` usando como implementación de referencia el iterador de `ArrayList`. La consigna entrega las cuatro características del MDE y pide derivar los requisitos, instanciar los casos en JUnit 5 y reportar fallas si las hay.

## Referencia usada

- Oracle Java SE 7 — `java.util.Iterator`: [docs.oracle.com](https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html)

Puntos clave tomados de la especificación oficial:

- `hasNext()` devuelve `true` si hay más elementos.
- `next()` devuelve el siguiente elemento y lanza `NoSuchElementException` si no hay más.
- `remove()` es operación opcional.
- `remove()` lanza `UnsupportedOperationException` si no está soportado.
- `remove()` lanza `IllegalStateException` si no hubo `next()` previo, o si ya se llamó `remove()` después del último `next()`.

## Modelo del Dominio de Entradas (según consigna)

Características:

- **C1**: el iterador tiene más valores `{true, false}`.
- **C2**: `next()` retorna objeto no `null` `{true, false}`.
- **C3**: `remove()` está soportado `{true, false}`.
- **C4**: la restricción de `remove()` se satisface `{true, false}`.

Decisiones para instanciar los casos:

- Para C3 = `true`, se usa `ArrayList.iterator()`.
- Para C3 = `false`, se usa `Collections.unmodifiableList(new ArrayList<>(...)).iterator()`. La colección subyacente sigue siendo un `ArrayList`, pero el iterador expuesto no soporta `remove()`.

## Requisitos de test (PWC)

Pares relevantes y factibles:

- **R01**: C1 = `true` (`hasNext()` devuelve `true`).
- **R02**: C1 = `false` (`hasNext()` devuelve `false` en iterador vacío).
- **R03**: C1 = `false` (`hasNext()` devuelve `false` en iterador agotado).
- **R04**: C1 = `true`, C2 = `true` (`next()` retorna un objeto no `null`).
- **R05**: C1 = `true`, C2 = `false` (`next()` retorna `null`).
- **R06**: C1 = `false` (`next()` lanza `NoSuchElementException` en vacío).
- **R07**: C1 = `false` (`next()` lanza `NoSuchElementException` en agotado).
- **R08**: C3 = `false`, C4 = `true` (`remove()` lanza `UnsupportedOperationException`).
- **R09**: C3 = `true`, C4 = `false`, C1 = `true` (`remove()` antes de `next()` con elementos).
- **R10**: C3 = `true`, C4 = `false`, C1 = `false` (`remove()` antes de `next()` sin elementos).
- **R11**: C3 = `true`, C4 = `true`, C1 = `true` (`remove()` exitoso con elementos restantes).
- **R12**: C3 = `true`, C4 = `true`, C1 = `false` (`remove()` exitoso al final).
- **R13**: C3 = `true`, C4 = `false` después de un `remove()` previo.

## Casos implementados

Cada caso TC*i* cubre el requisito R*i* correspondiente. La suite `IteratorArrayListTest` tiene 13 tests.

## Resultado

No se encontraron fallas en la implementación de `Iterator` de Java para estos escenarios. Los tests confirman el comportamiento esperado por especificación sobre `ArrayList`, incluyendo el caso `unmodifiableList` en el que `remove()` no está soportado.

## Cómo ejecutar

Desde `tp3/assignmnet-3-rodeghiero`:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=IteratorArrayListTest test
```

## Código

- [`IteratorArrayListTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/IteratorArrayListTest.java) — suite con los 13 casos PWC sobre `Iterator`.

## Enlaces relacionados

- Enunciado del práctico: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución completa: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
- Resumen teórico: [`resumen_teorico_practico3.pdf`](/pdfs/tp3/resumen_teorico_practico3.pdf)
