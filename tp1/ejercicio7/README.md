# Ejercicio 7

## Aclaración inicial

En el enunciado se habla de la clase `PointSet` y de tests dados en `PointSetTest`, pero en el material disponible para este repo **no se encuentran provistos** ni esa clase ni esos tests.

Para poder resolver el ejercicio, creé yo mismo:

- una implementación de `PointSet`
- una clase `PointSetTest`
- y algunos tests adicionales necesarios para verificar el comportamiento del conjunto

En base a eso resolví el ejercicio.

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

Como no estaban los tests dados, creé estos tests para poder trabajar sobre la clase:

- verificar que un `PointSet` nuevo empieza vacío
- verificar que no se agreguen duplicados si los puntos son equivalentes
- verificar que `contains` reconozca un punto equivalente
- verificar que `remove` elimine un punto equivalente
- verificar que `contains` devuelva `false` si el punto no está

### Resultado de los tests

Con la implementación actual, los tests pasan. No encontré una falla nueva en `PointSet`.

Eso también tiene sentido porque la clase se apoya en un `HashSet<Point>` y en el ejercicio 6 ya se había corregido `Point` agregando un `hashCode` consistente con `equals`.

### Arrange, act, assert

En cada test de `PointSetTest` dejé marcadas las tres partes con comentarios:

- `// arrange`
- `// act`
- `// assert`

Por ejemplo, en el test de borrado:

- en `arrange` se crea el conjunto y se agrega un punto
- en `act` se llama a `remove`
- en `assert` se verifica que el borrado haya dado `true` y que el tamaño final sea `0`

## Conclusión

Como ni `PointSet` ni `PointSetTest` estaban provistos, creé ambos para poder resolver el ejercicio. En base a los tests creados no aparecieron fallas adicionales, y la implementación actual de `PointSet` pasa todas las verificaciones.
