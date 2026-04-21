---
title: "Ejercicio 2"
sidebar_position: 2
slug: "/tp7/ejercicio2/"
description: "Contenido importado desde tp7/ejercicio2/README.md"
---

# Ejercicio 2

Este ejercicio trabaja sobre la clase `assignment7_exercises.point.Point`, que modela un punto en el plano con coordenadas `x` e `y` de tipo `float`.

La consigna planteaba cuatro tareas:

1. explicar la relación entre `equals` y `hashCode`,
2. implementar ambos métodos respetando el contrato de Java,
3. escribir propiedades con un generador de puntos en `jqwik`,
4. validar con una propiedad geométrica: la distancia entre dos puntos sobre una recta paralela al eje X.

## Archivos relevantes

- Implementación de `Point`: [Point.java](../assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/point/Point.java)
- Propiedades `jqwik`: [PointPropertiesTest.java](../assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/point/PointPropertiesTest.java)

## Relación entre `equals` y `hashCode`

El contrato de `Object` en Java establece dos reglas que son clave cuando una clase va a usarse en estructuras como `HashMap` o `HashSet`:

- **Si dos objetos son iguales según `equals`, entonces deben tener el mismo `hashCode`.** Esto es obligatorio: si se rompe, las estructuras basadas en hashing dejan de funcionar correctamente (un objeto podría no encontrarse nunca porque se estaría buscando en el *bucket* equivocado).
- **La inversa no es obligatoria.** Dos objetos con el mismo `hashCode` no tienen por qué ser iguales. Eso se conoce como *colisión* y es un comportamiento esperado: el hash es un entero con un rango finito, por lo que es inevitable que haya colisiones para objetos distintos.

Por eso, al sobrescribir `equals` también hay que sobrescribir `hashCode` de manera **consistente con esa definición**. Si se modifica uno sin el otro, se rompe el contrato.

## Desarrollo de la resolución

### 1) `equals` y `hashCode`

En `Point` se agregaron ambos métodos cuidando que queden alineados entre sí:

- `equals(Object)` primero cubre los dos casos rápidos (misma referencia y objeto `null` o de otra clase), y después compara las coordenadas con `Float.compare(...)`. Se usa `Float.compare` en lugar de `==` porque trata correctamente los casos especiales del IEEE 754 como `NaN` y `-0.0f` vs `+0.0f`. Con `==`, por ejemplo, `NaN == NaN` da `false`, lo cual rompería la reflexividad de `equals` si un punto tuviera una coordenada `NaN`.
- `hashCode()` combina las dos coordenadas usando `Float.floatToIntBits(...)`, que convierte el `float` a su representación binaria como `int`. Esto garantiza que dos `float` "iguales" según `Float.compare` produzcan el mismo `int`, y por lo tanto el mismo hash. Se combinan con la fórmula clásica `31 * result + ...` para reducir colisiones.

De esta manera, si dos puntos tienen las mismas coordenadas, `equals` da `true` **y** los dos hashes coinciden, cumpliendo el contrato.

### 2) Generador de puntos y propiedad del contrato `equals/hashCode`

Se definió un generador `@Provide` llamado `puntos` que construye instancias de `Point` a partir de dos coordenadas generadas por el provider `coordenadas`, que devuelve `float` en el rango `[-10_000, 10_000]`. El rango se acotó a propósito para evitar que aparezcan valores extremos (como `Float.NaN` o `Float.POSITIVE_INFINITY`) que podrían ser poco representativos del uso real y generar ruido en otras propiedades.

Sobre ese generador se escribió la propiedad `puntosIgualesDebenTenerMismoHashCode`: genera un punto, construye manualmente una copia con las mismas coordenadas y verifica que:

- `p.equals(copia)` sea `true`,
- `p.hashCode() == copia.hashCode()`.

Son 250 iteraciones (`tries = 250`), cantidad suficiente para cubrir variedad de combinaciones sin penalizar el tiempo de build.

### 3) Propiedad geométrica: distancia sobre una recta paralela al eje X

Cuando dos puntos comparten la ordenada `y`, están sobre una recta horizontal, y su distancia se reduce a la diferencia (en valor absoluto) de las abscisas:

- `p1 = (x1, y)`
- `p2 = (x2, y)`
- `distance(p1, p2) == |x2 - x1|`

Esta es una buena propiedad para *property-based testing* porque es independiente de los valores concretos y captura una invariante geométrica real, no un caso puntual.

La propiedad `distanciaEnRectaParalelaAlEjeXEsDiferenciaDeAbscisas` genera tres coordenadas (`x1`, `x2`, `y`) con el mismo provider de antes, construye los dos puntos compartiendo `y`, y compara el resultado de `distanceTo` contra `Math.abs(x2 - x1)`. Se usa una **tolerancia numérica de `1e-6`** en el `assertEquals` porque `distanceTo` implementa la fórmula euclídea con `Math.sqrt(Math.pow(...))`, y esas operaciones introducen errores de redondeo inevitables en aritmética de punto flotante. Sin tolerancia, la propiedad fallaría por diferencias ínfimas en el último bit.

## Ejecución

Desde `tp7/assignmnet-7-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado: las dos propiedades del ejercicio 2 pasan correctamente tras las 250 iteraciones cada una.
