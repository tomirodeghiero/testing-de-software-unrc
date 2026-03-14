# Ejercicio 5

En base al ejemplo del libro _Effective Java_:

- `class Point` es la clase base que representa un punto con coordenadas `x` e `y` y define igualdad por valor.
- `class ColorPoint` es la clase que intenta agregar un nuevo componente de valor, el color, heredando de `Point`.

La falla OO aparece justamente ahi: cuando se quiere extender una clase con igualdad por valor y agregarle mas estado sin romper el contrato de `equals`.

En esta carpeta se encuentra:

- `practico1_exercises/color_points/Point.java`: versión base del ejercicio.
- `practico1_exercises/color_points/ColorPoint.java`: version defectuosa por herencia.
- `practico1_exercises/color_points/ColorPointFixed.java`: una corrección posible usando composicion.

## 1. `Point`

### a) Qué tiene de malo y cómo lo modificaría

El problema de `Point` no es que su `equals` falle cuando se compara con otro `Point`. Ahí anda bien. El problema es que `Point` es una clase instanciable, no final, y define igualdad por valor usando:

```java
if (!(o instanceof Point)) {
    return false;
}
```

Eso deja abierta la puerta a que una subclase como `ColorPoint` tambien sea vista como un `Point`, aunque agregue estado extra. Entonces `Point` termina ignorando el color.

Una forma de evitar esto es:

- hacer `Point` final, o
- no usar herencia para agregar color y pasar a composición.

La solución es no hacer `ColorPoint extends Point`, sino tener un `Point` adentro.

### b) Test que no ejecute la falla

Sí se puede, alcanzaria con comparar solo objetos `Point`:

```java
Point p1 = new Point(1, 2);
Point p2 = new Point(1, 2);

assert p1.equals(p2);
```

Acá no aparece el problema porque no interviene ninguna subclase.

### c) Test que ejecute la falla, pero que no produzca error

Sí se puede, sería por ejemplo:

```java
Point p = new Point(1, 2);
ColorPoint cp = new ColorPoint(2, 3, Color.RED);

assert !p.equals(cp);
```

La falla se ejecuta porque `Point.equals` acepta comparar contra un `ColorPoint` como si fuera un `Point`, pero en este caso no hay error observable porque las coordenadas ya son distintas y el resultado correcto igual era `false`.

### d) Test que produzca error, pero no falla

No lo veo posible. En este caso, cuando aparece el error, se observa directamente en el valor que devuelve `equals`. No hay un estado interno oculto que despues pueda o no propagarse.

## 2. `ColorPoint`

### a) Que tiene de malo y como lo modificaria

El problema de esta clase es que hereda de `Point` y redefine `equals` para exigir que el otro objeto tambien sea `ColorPoint`:

```java
if (!(o instanceof ColorPoint)) {
    return false;
}
```

Eso rompe la simetria. Por ejemplo:

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

La modificacion correcta es no heredar de `Point` y usar composicion. Esa version la deje en `ColorPointFixed.java`.

### b) Test que no ejecute la falla

Si:

```java
ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
ColorPoint cp2 = new ColorPoint(1, 2, Color.RED);

assert cp1.equals(cp2);
```

Aca se usa `ColorPoint.equals`, pero no aparece el problema de mezclar `Point` con `ColorPoint`.

### c) Test que ejecute la falla, pero que no produzca error

Si:

```java
ColorPoint cp = new ColorPoint(1, 2, Color.RED);
Point p = new Point(4, 5);

assert !cp.equals(p);
```

La rama defectuosa se ejecuta porque `p` no es `ColorPoint`, pero igual no aparece error observable porque el resultado esperado tambien era `false`.

### d) Test que produzca error, pero no falla

Tampoco lo veo posible acá. Cuando el problema aparece, se manifiesta directamente en el resultado de `equals`, por ejemplo en la perdida de simetria. No hay una etapa intermedia donde exista error interno sin falla observable.

## Resumen

- `Point` queda mal diseñado para ser extendido si define igualdad por valor.
- `ColorPoint` por herencia rompe el contrato de `equals`.
- La salida correcta es usar composición, no herencia. Eso es lo que hace `ColorPointFixed` en su respectiva clase.
