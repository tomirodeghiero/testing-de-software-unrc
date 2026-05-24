---
title: "Ejercicio 5"
sidebar_position: 5
slug: "/tp1/ejercicio5/"
description: "Contenido importado desde tp1/ejercicio5/README.md"
---

# Ejercicio 5 — Contrato de `equals` en `Point` y `ColorPoint`

## Consigna

Se analizan dos clases del paquete `practico1_exercises.color_points`, tomadas del ejemplo clásico de Bloch en *Effective Java* (capítulo 3, sobre el contrato de `equals`):

- `Point` define un punto con coordenadas `x` e `y` e igualdad por valor.
- `ColorPoint` intenta agregar un componente de valor extra —el color— extendiendo de `Point`.

Para cada clase hay que:

- **a)** Indicar qué tiene de malo y proponer una modificación.
- **b)** Dar un test que **no ejecute** la falla, si es posible.
- **c)** Dar un test que **ejecute la falla pero no produzca error observable**.
- **d)** Dar un test que **produzca error pero no falla**, si es posible.

La falla orientada a objetos aparece justo ahí: extender una clase con igualdad por valor y sumarle más estado sin romper la simetría y la transitividad de `equals`.

## Archivos

- `practico1_exercises/color_points/Point.java` — versión base del ejercicio.
- `practico1_exercises/color_points/ColorPoint.java` — versión defectuosa por herencia.
- `practico1_exercises/color_points/ColorPointFixed.java` — corrección por composición.

## Resolución

### 1. `Point`

#### a) Qué tiene de malo y cómo lo modificaría

El problema de `Point` no es que su `equals` falle cuando se compara con otro `Point`. Ahí anda bien. El problema es que `Point` es una clase instanciable, no final, y define igualdad por valor usando:

```java
if (!(o instanceof Point)) {
    return false;
}
```

Eso deja abierta la puerta a que una subclase como `ColorPoint` también sea vista como un `Point`, aunque agregue estado extra. Entonces `Point` termina ignorando el color.

Una forma de evitar esto es:

- hacer `Point` final, o
- no usar herencia para agregar color y pasar a composición.

La salida correcta es no hacer `ColorPoint extends Point`, sino tener un `Point` adentro.

#### b) Test que no ejecute la falla

Sí se puede, alcanza con comparar solo objetos `Point`:

```java
Point p1 = new Point(1, 2);
Point p2 = new Point(1, 2);

assert p1.equals(p2);
```

Acá no aparece el problema porque no interviene ninguna subclase.

#### c) Test que ejecute la falla, pero que no produzca error

Sí se puede, sería por ejemplo:

```java
Point p = new Point(1, 2);
ColorPoint cp = new ColorPoint(2, 3, Color.RED);

assert !p.equals(cp);
```

La falla se ejecuta porque `Point.equals` acepta comparar contra un `ColorPoint` como si fuera un `Point`, pero en este caso no hay error observable porque las coordenadas ya son distintas y el resultado correcto igual era `false`.

#### d) Test que produzca error, pero no falla

No lo veo posible. Cuando aparece el error, se observa directamente en el valor que devuelve `equals`. No hay un estado interno oculto que después pueda o no propagarse.

### 2. `ColorPoint`

#### a) Qué tiene de malo y cómo lo modificaría

El problema de esta clase es que hereda de `Point` y redefine `equals` para exigir que el otro objeto también sea `ColorPoint`:

```java
if (!(o instanceof ColorPoint)) {
    return false;
}
```

Eso rompe la simetría. Por ejemplo:

```java
Point p = new Point(1, 2);
ColorPoint cp = new ColorPoint(1, 2, Color.RED);
```

Entonces:

```java
p.equals(cp)    // true
cp.equals(p)    // false
```

El primer resultado da `true` porque `Point` solo mira `x` e `y`. El segundo da `false` porque `ColorPoint` exige que el otro sea `ColorPoint`. Esa diferencia viola el contrato de `equals`.

La modificación correcta es no heredar de `Point` y usar composición. Esa versión está en `ColorPointFixed.java`.

#### b) Test que no ejecute la falla

Sí:

```java
ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
ColorPoint cp2 = new ColorPoint(1, 2, Color.RED);

assert cp1.equals(cp2);
```

Acá se usa `ColorPoint.equals`, pero no aparece el problema de mezclar `Point` con `ColorPoint`.

#### c) Test que ejecute la falla, pero que no produzca error

Sí:

```java
ColorPoint cp = new ColorPoint(1, 2, Color.RED);
Point p = new Point(4, 5);

assert !cp.equals(p);
```

La rama defectuosa se ejecuta porque `p` no es `ColorPoint`, pero igual no aparece error observable porque el resultado esperado también era `false`.

#### d) Test que produzca error, pero no falla

Tampoco lo veo posible acá. Cuando el problema aparece, se manifiesta directamente en el resultado de `equals`, por ejemplo en la pérdida de simetría. No hay una etapa intermedia donde exista error interno sin falla observable.

## Síntesis

- `Point` queda mal diseñado para ser extendido si define igualdad por valor.
- `ColorPoint` por herencia rompe el contrato de `equals`.
- La salida correcta es usar composición, no herencia. Eso es lo que hace `ColorPointFixed`.

## Enlaces relacionados

- Enunciado del práctico: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución completa: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
- Resumen teórico: [`resumen-teorico-testing-tp1.pdf`](/pdfs/tp1/resumen-teorico-testing-tp1.pdf)
