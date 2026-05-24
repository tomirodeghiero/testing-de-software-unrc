---
title: "Ejercicio 6"
sidebar_position: 6
slug: "/tp1/ejercicio6/"
description: "Contenido importado desde tp1/ejercicio6/README.md"
---

# Ejercicio 6 — Consistencia entre `equals` y `hashCode` en `Point`

## Consigna

A partir de la clase `Point` y la suite `PointTest` provistas por la cátedra, el ejercicio pide:

- **a)** Agregar nuevos tests, detectar una falla y aplicar la corrección.
- **b)** Marcar explícitamente las tres fases del patrón **Arrange–Act–Assert** en cada test.

### Aclaración sobre el material

En el enunciado se menciona que hay tests dados en `PointTest`, pero en el material disponible en el Classroom no estaban ni la clase, ni el test, ni el paquete `practico1_exercises.point_set`.

Para poder resolver el ejercicio:

1. Creé una implementación propia de `Point` en el paquete pedido.
2. Creé la clase `PointTest`.
3. Sobre esos tests resolví los puntos a) y b).

## Archivos

- `src/main/java/practico1_exercises/point_set/Point.java`
- `src/test/java/practico1_exercises/point_set/PointTest.java`

## Cómo ejecutar los tests

Desde `tp1/ejercicio6`:

```bash
mvn -Dmaven.repo.local=.m2 test
```

## Resolución

### a) Nuevos tests, detección de falla y corrección

Como no estaban los tests dados, agregué estos tests nuevos:

- igualdad entre dos puntos con las mismas coordenadas;
- desigualdad entre puntos distintos;
- comportamiento correcto dentro de un `HashSet` cuando hay dos puntos equivalentes;
- búsqueda correcta en un `HashSet` usando un punto equivalente.

Los dos últimos tests son importantes porque el nombre del paquete es `point_set`, así que tiene sentido verificar el comportamiento de `Point` dentro de un conjunto.

Con esos tests, la falla que se detecta es la clásica inconsistencia entre `equals` y `hashCode`: si `Point` redefine `equals` pero no redefine `hashCode` de manera consistente, dos puntos iguales pueden comportarse como distintos dentro de un `HashSet`, lo que rompe la promesa de `HashSet` y `HashMap`.

La corrección aplicada fue agregar:

```java
@Override
public int hashCode() {
    return Objects.hash(x, y);
}
```

De esa manera, dos objetos `Point` con el mismo `x` e `y` quedan iguales tanto para `equals` como para `hashCode`, y los tests sobre conjuntos pasan.

### b) Arrange–Act–Assert

En la clase `PointTest` dejé marcadas claramente las tres fases con comentarios:

- `// arrange` — preparación de los objetos y datos necesarios.
- `// act` — ejecución de la operación que se quiere probar.
- `// assert` — verificación del resultado esperado.

Por ejemplo, en el test del `HashSet`:

- en `arrange` se crean el set y los puntos;
- en `act` se agregan los puntos al conjunto;
- en `assert` se verifica que el tamaño sea `1`.

## Resultado

La versión actual de `Point` queda corregida para funcionar correctamente dentro de estructuras basadas en hashing.

## Enlaces relacionados

- Enunciado del práctico: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución completa: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
- Resumen teórico: [`resumen-teorico-testing-tp1.pdf`](/pdfs/tp1/resumen-teorico-testing-tp1.pdf)
