# Ejercicio 6

## Aclaración inicial

En el enunciado se menciona que hay tests dados en `PointTest`, pero en el material disponible que tengo en el Classroom no estaban la clase, el test, ni el package `practico1_exercises.point_set`.

Por eso, para poder resolver el ejercicio, hice lo siguiente:

1. Cree una implementación de `Point` en el package pedido.
2. Cree la clase `PointTest`.
3. En base a esos tests resolví los puntos a) y b).

## Archivos

- `src/main/java/practico1_exercises/point_set/Point.java`
- `src/test/java/practico1_exercises/point_set/PointTest.java`

## Como ejecutar los tests

Desde `tp1/ejercicio6`:

```bash
mvn -Dmaven.repo.local=.m2 test
```

## Resolucion

### a) Nuevos tests, deteccion de falla y correccion

Como no estaban los tests dados, agregue estos tests nuevos:

- igualdad entre dos puntos con las mismas coordenadas
- desigualdad entre puntos distintos
- comportamiento correcto dentro de un `HashSet` cuando hay dos puntos equivalentes
- busqueda correcta en un `HashSet` usando un punto equivalente

Los dos últimos tests son importantes porque el nombre del package es `point_set`, así que tiene sentido verificar el comportamiento de `Point` dentro de un conjunto.

Con esos tests, la falla que se detecta es la clasica inconsistencia entre `equals` y `hashCode`. Si `Point` redefine `equals` pero no redefine `hashCode` de manera consistente, dos puntos iguales pueden comportarse como distintos dentro de un `HashSet`.

La corrección aplicada fue agregar:

```java
@Override
public int hashCode() {
    return Objects.hash(x, y);
}
```

De esa manera, dos objetos `Point` con el mismo `x` e `y` quedan iguales tanto para `equals` como para `hashCode`, y los tests de conjunto pasan.

### b) Partes de cada test: arrange, act, assert

En la clase `PointTest` deje marcadas claramente las tres partes en cada test con comentarios:

- `// arrange`: preparación de los objetos y datos necesarios
- `// act`: ejecución de la operacion que se quiere probar
- `// assert`: verificación del resultado esperado

Por ejemplo, en el test del `HashSet`:

- en `arrange` se crean el set y los puntos
- en `act` se agregan los puntos al conjunto
- en `assert` se verifica que el tamaño sea `1`

## Resultado final

La version actual de `Point` ya queda corregida para funcionar correctamente dentro de estructuras de tipo set.
