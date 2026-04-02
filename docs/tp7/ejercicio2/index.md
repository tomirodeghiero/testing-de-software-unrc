---
title: "Ejercicio 2"
sidebar_position: 2
slug: "/tp7/ejercicio2/"
description: "Contenido importado desde tp7/ejercicio2/README.md"
---

# Ejercicio 2

En este ejercicio trabajé sobre `assignment7_exercises.point.Point`.
La consigna pedía:

1. explicar la relación entre `equals` y `hashCode`,
2. implementar ambos métodos,
3. escribir propiedades con generador de puntos,
4. testear la propiedad geométrica de distancia en recta paralela al eje X.

## Relación entre `equals` y `hashCode`

El contrato de Java exige:

- si `a.equals(b)` es `true`, entonces `a.hashCode() == b.hashCode()`.

La inversa no es obligatoria: dos objetos pueden tener el mismo hash y no ser iguales.

## Código resuelto

- Implementación de `Point`: [Point.java](../assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/point/Point.java)
- Propiedades `jqwik`: [PointPropertiesTest.java](../assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/point/PointPropertiesTest.java)

## Qué implementé

### 1) `equals` y `hashCode`

En `Point` se agregó:

- `equals(Object)` comparando coordenadas `x` e `y` con `Float.compare(...)`,
- `hashCode()` consistente con esa definición, usando `Float.floatToIntBits(...)`.

Con esto, dos puntos con las mismas coordenadas son iguales y comparten hash.

### 2) Propiedad para contrato `equals/hashCode`

Se definió una propiedad que genera puntos y construye una copia con las mismas coordenadas.
Luego verifica:

- `p.equals(copia)`
- `p.hashCode() == copia.hashCode()`

Además se creó un generador de puntos con `jqwik` (`@Provide puntos`) a partir de coordenadas float en rango `[-10000, 10000]`.

### 3) Propiedad geométrica de distancia

Se definió una propiedad para puntos sobre una recta paralela al eje X (misma ordenada `y`):

- `p1 = (x1, y)`
- `p2 = (x2, y)`

y se verifica que:

- `distance(p1, p2) == |x2 - x1|`

con tolerancia numérica `1e-6`.

## Ejecución

Desde `tp7/assignmnet-7-rodeghiero`:

```bash
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true test
```

Resultado: las propiedades del ejercicio 2 pasan correctamente.
