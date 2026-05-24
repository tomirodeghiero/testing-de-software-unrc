---
title: "Ejercicio 7"
sidebar_position: 7
slug: "/tp1/ejercicio7/"
description: "Contenido importado desde tp1/ejercicio7/README.md"
---

# Ejercicio 7 — `PointSet` sobre `HashSet<Point>`

## Consigna

A partir de la clase `PointSet` y la suite `PointSetTest` provistas por la cátedra, el ejercicio pide:

- Agregar tests adicionales para cubrir el comportamiento del conjunto.
- Identificar posibles fallas y aplicar correcciones si aparecen.
- Marcar explícitamente las tres fases del patrón **Arrange–Act–Assert** en cada test.

### Aclaración sobre el material

En el enunciado se habla de la clase `PointSet` y de tests dados en `PointSetTest`, pero en el material disponible para este repo **no se encuentran provistos** ni esa clase ni esos tests.

Para poder resolver el ejercicio creé:

- una implementación de `PointSet`,
- una clase `PointSetTest`,
- y tests adicionales necesarios para verificar el comportamiento del conjunto.

## Archivos

- `src/main/java/practico1_exercises/point_set/Point.java`
- `src/main/java/practico1_exercises/point_set/PointSet.java`
- `src/test/java/practico1_exercises/point_set/PointSetTest.java`

## Cómo ejecutar los tests

Desde `tp1/ejercicio7`:

```bash
mvn -Dmaven.repo.local=.m2 test
```

## Resolución

### Tests creados

Como no estaban los tests dados, creé estos tests para trabajar sobre la clase:

- verificar que un `PointSet` nuevo empieza vacío;
- verificar que no se agregan duplicados si los puntos son equivalentes;
- verificar que `contains` reconozca un punto equivalente;
- verificar que `remove` elimine un punto equivalente;
- verificar que `contains` devuelva `false` si el punto no está.

### Resultado de los tests

Con la implementación actual los tests pasan; no encontré una falla nueva en `PointSet`.

Esto es coherente con el ejercicio anterior: `PointSet` se apoya internamente en un `HashSet<Point>`, y en el Ejercicio 6 se había corregido `Point` agregando un `hashCode` consistente con `equals`. Una vez que las dos operaciones quedan alineadas, `HashSet` se comporta correctamente y `PointSet` hereda ese buen comportamiento sin necesidad de ajustes propios.

### Arrange–Act–Assert

En cada test de `PointSetTest` dejé marcadas las tres fases con comentarios:

- `// arrange`
- `// act`
- `// assert`

Por ejemplo, en el test de borrado:

- en `arrange` se crea el conjunto y se agrega un punto;
- en `act` se llama a `remove`;
- en `assert` se verifica que el borrado haya dado `true` y que el tamaño final sea `0`.

## Conclusión

`PointSet` y `PointSetTest` no estaban provistos, así que creé ambos para poder resolver el ejercicio. Sobre los tests construidos la implementación pasa todas las verificaciones, lo cual valida la corrección de `Point` aplicada en el Ejercicio 6.

## Código

- [`Point.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio7/src/main/java/practico1_exercises/point_set/Point.java) — `Point` con la corrección de `equals`/`hashCode` traída del Ejercicio 6.
- [`PointSet.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio7/src/main/java/practico1_exercises/point_set/PointSet.java) — conjunto de puntos apoyado en `HashSet<Point>`.
- [`PointSetTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio7/src/test/java/practico1_exercises/point_set/PointSetTest.java) — suite JUnit con `add`, `contains`, `remove` y el patrón Arrange–Act–Assert.
- [`pom.xml`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio7/pom.xml) — configuración Maven del módulo.

## Enlaces relacionados

- Enunciado del práctico: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución completa: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
- Resumen teórico: [`resumen-teorico-testing-tp1.pdf`](/pdfs/tp1/resumen-teorico-testing-tp1.pdf)
