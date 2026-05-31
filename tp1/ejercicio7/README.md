# Ejercicio 7 — `PointSet` sobre `HashSet<Point>`

## Consigna

A partir de `PointSet` y `PointSetTest` provistas por la cátedra:

- agregar tests adicionales para cubrir el comportamiento del conjunto;
- identificar fallas y aplicar correcciones si aparecen;
- marcar las tres fases de **Arrange–Act–Assert** en cada test.

> El enunciado menciona estas clases como dadas, pero en el material no estaban. Para poder hacer el ejercicio armé `PointSet`, `PointSetTest` y los tests que cubren el comportamiento del conjunto.

## Archivos

- [`src/main/java/practico1_exercises/point_set/Point.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio7/src/main/java/practico1_exercises/point_set/Point.java)
- [`src/main/java/practico1_exercises/point_set/PointSet.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio7/src/main/java/practico1_exercises/point_set/PointSet.java)
- [`src/test/java/practico1_exercises/point_set/PointSetTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio7/src/test/java/practico1_exercises/point_set/PointSetTest.java)
- [`pom.xml`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio7/pom.xml)

## Cómo correr los tests

```bash
cd tp1/ejercicio7
mvn -Dmaven.repo.local=.m2 test
```

## Resolución

### Tests

Los que armé:

- un `PointSet` recién creado empieza vacío;
- no se agregan duplicados cuando los puntos son equivalentes;
- `contains` reconoce un punto equivalente;
- `remove` elimina un punto equivalente;
- `contains` devuelve `false` cuando el punto no está.

### Resultado

Con la implementación actual los tests pasan; no encontré una falla nueva en `PointSet`. Tiene sentido: `PointSet` se apoya en un `HashSet<Point>`, y en el ejercicio 6 ya se había corregido `Point` agregando el `hashCode` consistente con `equals`. Una vez que esas dos operaciones quedan alineadas, `HashSet` funciona como tiene que funcionar y `PointSet` hereda ese buen comportamiento sin tener que ajustar nada propio.

### Arrange–Act–Assert

Cada test tiene las tres fases marcadas con `// arrange`, `// act`, `// assert`. Por ejemplo, en el test de borrado: en `arrange` se crea el conjunto y se agrega un punto; en `act` se llama a `remove`; en `assert` se verifica que el retorno haya sido `true` y que el tamaño final sea `0`.

## Enlaces

- Enunciado: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
