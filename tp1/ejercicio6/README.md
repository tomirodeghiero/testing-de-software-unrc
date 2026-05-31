# Ejercicio 6 — `equals` y `hashCode` consistentes en `Point`

## Consigna

A partir de `Point` y la suite `PointTest` provistas por la cátedra:

- a) agregar nuevos tests, detectar una falla y aplicar la corrección;
- b) marcar las tres fases del patrón **Arrange–Act–Assert** en cada test.

> El enunciado dice que `PointTest` viene dado, pero en el material del Classroom no estaban ni la clase, ni el test, ni el paquete `practico1_exercises.point_set`. Para poder resolverlo armé mi propia `Point`, mi propia `PointTest`, y sobre eso trabajé los puntos a) y b).

## Archivos

- [`src/main/java/practico1_exercises/point_set/Point.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio6/src/main/java/practico1_exercises/point_set/Point.java)
- [`src/test/java/practico1_exercises/point_set/PointTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio6/src/test/java/practico1_exercises/point_set/PointTest.java)
- [`pom.xml`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio6/pom.xml)

## Cómo correr los tests

```bash
cd tp1/ejercicio6
mvn -Dmaven.repo.local=.m2 test
```

## Resolución

### a) Tests, falla y corrección

Como no estaban los tests originales, agregué estos:

- igualdad entre dos puntos con las mismas coordenadas;
- desigualdad entre puntos distintos;
- comportamiento dentro de un `HashSet` cuando se agregan dos puntos equivalentes;
- búsqueda en el `HashSet` usando un punto equivalente.

Los dos últimos son los importantes: el paquete se llama `point_set`, así que tiene sentido ver cómo se comporta `Point` adentro de un conjunto.

Con esos tests aparece la falla clásica: si `Point` redefine `equals` pero no redefine `hashCode` de forma consistente, dos puntos iguales pueden comportarse como distintos en un `HashSet`. Eso rompe la promesa de `HashSet` y `HashMap`.

La corrección fue agregar:

```java
@Override
public int hashCode() {
    return Objects.hash(x, y);
}
```

Con eso, dos `Point` con los mismos `x` e `y` quedan iguales para `equals` y para `hashCode`, y los tests sobre conjuntos pasan.

### b) Arrange–Act–Assert

En cada test dejé las tres fases marcadas con comentarios `// arrange`, `// act`, `// assert`. Por ejemplo, en el test del `HashSet`: en `arrange` se crean el set y los puntos, en `act` se agregan al conjunto, y en `assert` se verifica que el tamaño quede en `1`.

## Enlaces

- Enunciado: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
