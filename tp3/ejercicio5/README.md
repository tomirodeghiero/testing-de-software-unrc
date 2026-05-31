# Ejercicio 5 — `Iterator` sobre `ArrayList` con *Pair-Wise*

## Consigna

Aplicar Input Space Partitioning sobre la interfaz `java.util.Iterator`, usando el iterador de `ArrayList` como implementación de referencia. La consigna entrega las cuatro características del MDE y pide derivar los requisitos, implementar los casos en JUnit 5 y reportar fallas si las hay.

## Especificación de referencia

De Oracle Java SE 7, [`java.util.Iterator`](https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html):

- `hasNext()` devuelve `true` si hay más elementos.
- `next()` devuelve el siguiente; lanza `NoSuchElementException` si no hay más.
- `remove()` es opcional. Lanza `UnsupportedOperationException` si no está soportada. Si lo está, lanza `IllegalStateException` si no hubo `next()` previo, o si ya se llamó `remove()` después del último `next()`.

## MDE (según consigna)

- **C1**: el iterador tiene más valores `{true, false}`.
- **C2**: `next()` retorna no `null` `{true, false}`.
- **C3**: `remove()` está soportado `{true, false}`.
- **C4**: la precondición de `remove()` se satisface `{true, false}`.

Decisiones para instanciar los casos:

- Para C3 = `true`, uso `ArrayList.iterator()`.
- Para C3 = `false`, uso `Collections.unmodifiableList(new ArrayList<>(...)).iterator()`. La colección subyacente sigue siendo un `ArrayList`, pero el iterador expuesto no soporta `remove()`.

## Requisitos PWC

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

13 tests, uno por requisito (`TC1` cubre `R01`, etc.), en `IteratorArrayListTest`.

## Resultado

No encontré fallas. El iterador de `ArrayList` (y la vista de `unmodifiableList` para el caso C3 = false) se comportan según la especificación en todos los escenarios.

## Cómo correr

```bash
cd tp3/assignmnet-3-rodeghiero
mvn -Dmaven.repo.local=.m2 -Dtest=IteratorArrayListTest test
```

## Archivos

- [`IteratorArrayListTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp3/assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/IteratorArrayListTest.java) — los 13 casos PWC sobre `Iterator`.

## Enlaces

- Enunciado: [`practico3.pdf`](/pdfs/tp3/practico3.pdf)
- Resolución: [`resolucion_practico3.pdf`](/pdfs/tp3/resolucion_practico3.pdf)
