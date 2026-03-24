# Ejercicio 5 - Practico 3

## Referencia usada

- Oracle Java SE 7 - `java.util.Iterator`:
  - https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html

Puntos clave tomados de la especificacion oficial:

- `hasNext()` devuelve `true` si hay mas elementos.
- `next()` devuelve el siguiente elemento y lanza `NoSuchElementException` si no hay mas.
- `remove()` es operacion opcional.
- `remove()` lanza `UnsupportedOperationException` si no esta soportado.
- `remove()` lanza `IllegalStateException` si no hubo `next()` previo o si ya se llamo `remove()` despues del ultimo `next()`.

## Archivos trabajados

- `../assignmnet-3-rodeghiero/src/test/java/assignment3_exercises/IteratorArrayListTest.java`

## MDE usado (segun consigna)

Caracteristicas:

- C1: el iterador tiene mas valores `{true,false}`
- C2: `next()` retorna objeto no null `{true,false}`
- C3: `remove()` esta soportado `{true,false}`
- C4: la restriccion de `remove()` se satisface `{true,false}`

Decisiones para instanciar tests concretos:

- Para C3=`true`, se usa `ArrayList.iterator()`.
- Para C3=`false`, se usa `Collections.unmodifiableList(new ArrayList<>(...)).iterator()`.
  La coleccion subyacente sigue siendo un `ArrayList`, pero el iterador expuesto no soporta `remove()`.

## Requisitos de test (cobertura de pares)

Se modelaron los pares relevantes y factibles:

- R01: C1=true (`hasNext()` true)
- R02: C1=false (`hasNext()` false en iterador vacio)
- R03: C1=false (`hasNext()` false en iterador agotado)
- R04: C1=true, C2=true (`next()` retorna no null)
- R05: C1=true, C2=false (`next()` retorna null)
- R06: C1=false (`next()` lanza `NoSuchElementException` en vacio)
- R07: C1=false (`next()` lanza `NoSuchElementException` en agotado)
- R08: C3=false, C4=true (`remove()` lanza `UnsupportedOperationException`)
- R09: C3=true, C4=false, C1=true (`remove()` antes de `next()` con elementos)
- R10: C3=true, C4=false, C1=false (`remove()` antes de `next()` sin elementos)
- R11: C3=true, C4=true, C1=true (`remove()` exitoso con elementos restantes)
- R12: C3=true, C4=true, C1=false (`remove()` exitoso al final)
- R13: C3=true, C4=false despues de un `remove()` previo

## Casos implementados

- TC1 -> R01
- TC2 -> R02
- TC3 -> R03
- TC4 -> R04
- TC5 -> R05
- TC6 -> R06
- TC7 -> R07
- TC8 -> R08
- TC9 -> R09
- TC10 -> R10
- TC11 -> R11
- TC12 -> R12
- TC13 -> R13

## Resultado

No se encontraron fallas en la implementacion de `Iterator` de Java para estos escenarios.
Los tests confirman el comportamiento esperado por especificacion para `ArrayList` y para el caso no soportado de `remove()`.

## Ejecucion

Desde `tp3/assignmnet-3-rodeghiero`:

```bash
mvn -Dmaven.repo.local=.m2 -Dtest=IteratorArrayListTest test
```
