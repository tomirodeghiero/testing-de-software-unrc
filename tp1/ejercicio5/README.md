# Ejercicio 5 — Contrato de `equals` en `Point` y `ColorPoint`

## Consigna

Dos clases del paquete `practico1_exercises.color_points`, tomadas del ejemplo de Bloch en *Effective Java* (capítulo 3, sobre `equals`):

- `Point` define un punto con coordenadas `x` e `y` e igualdad por valor.
- `ColorPoint` intenta sumarle un componente de valor extra —el color— extendiendo de `Point`.

Para cada una hay que:

- a) decir qué tiene de malo y proponer una modificación;
- b) dar un test que **no ejecute** la falla, si se puede;
- c) dar un test que **ejecute la falla pero no produzca error**;
- d) dar un test que **produzca error pero no falla**, si se puede.

El problema clásico es justo este: extender una clase con igualdad por valor y agregarle más estado rompe la simetría y la transitividad de `equals`.

## Archivos

- [`Point.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio5/practico1_exercises/color_points/Point.java) — versión base.
- [`ColorPoint.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio5/practico1_exercises/color_points/ColorPoint.java) — versión defectuosa por herencia.
- [`ColorPointFixed.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp1/ejercicio5/practico1_exercises/color_points/ColorPointFixed.java) — corrección por composición.

## Resolución

### 1. `Point`

**a)** El `equals` de `Point` no falla cuando se lo compara con otro `Point`. El problema es que `Point` es instanciable y no es final, y su `equals` acepta cualquier `instanceof Point`:

```java
if (!(o instanceof Point)) {
    return false;
}
```

Una subclase como `ColorPoint` también va a ser vista como `Point`, y el `equals` va a ignorar el color. Para evitarlo hay dos caminos: marcar `Point` como `final`, o no usar herencia y pasar a composición. Lo correcto es lo segundo: que `ColorPoint` tenga un `Point` adentro en lugar de heredar.

**b)** Comparando solo `Point` con `Point`, la falla no aparece:

```java
Point p1 = new Point(1, 2);
Point p2 = new Point(1, 2);
assert p1.equals(p2);
```

**c)** Acá se ejecuta la falla pero el resultado sigue siendo correcto:

```java
Point p = new Point(1, 2);
ColorPoint cp = new ColorPoint(2, 3, Color.RED);
assert !p.equals(cp);
```

`Point.equals` acepta comparar contra un `ColorPoint`, pero como las coordenadas ya son distintas, igual devuelve `false`.

**d)** No lo encuentro. Cuando aparece el error, se ve directo en el valor que devuelve `equals`. No hay un estado interno oculto que pueda no propagarse.

### 2. `ColorPoint`

**a)** Hereda de `Point` y redefine `equals` exigiendo que el otro objeto también sea `ColorPoint`:

```java
if (!(o instanceof ColorPoint)) {
    return false;
}
```

Eso rompe la simetría. Por ejemplo:

```java
Point p = new Point(1, 2);
ColorPoint cp = new ColorPoint(1, 2, Color.RED);

p.equals(cp);   // true
cp.equals(p);   // false
```

`p.equals(cp)` devuelve `true` porque `Point` solo mira `x` e `y`. `cp.equals(p)` devuelve `false` porque exige que el otro sea `ColorPoint`. Esa asimetría viola el contrato. La solución es no heredar y usar composición; esa versión está en `ColorPointFixed.java`.

**b)** `ColorPoint` con `ColorPoint`, sin mezclar tipos:

```java
ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
ColorPoint cp2 = new ColorPoint(1, 2, Color.RED);
assert cp1.equals(cp2);
```

**c)**

```java
ColorPoint cp = new ColorPoint(1, 2, Color.RED);
Point p = new Point(4, 5);
assert !cp.equals(p);
```

La rama defectuosa se ejecuta (`p` no es `ColorPoint`), pero el resultado sigue siendo el esperado.

**d)** Tampoco lo encuentro acá. Cuando el problema aparece, se manifiesta directo en lo que devuelve `equals`.

## Síntesis

- `Point` queda mal diseñado para ser extendido si define igualdad por valor.
- `ColorPoint` por herencia rompe el contrato.
- La salida es composición, no herencia. Eso es lo que hace `ColorPointFixed`.

## Enlaces

- Enunciado: [`practico1.pdf`](/pdfs/tp1/practico1.pdf)
- Resolución: [`resolucion_practico1.pdf`](/pdfs/tp1/resolucion_practico1.pdf)
