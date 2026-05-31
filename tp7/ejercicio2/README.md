# Ejercicio 2 — `Point`: `equals`/`hashCode` y propiedad geométrica

Trabajo sobre `assignment7_exercises.point.Point`, que modela un punto en el plano con coordenadas `x` e `y` de tipo `float`.

La consigna pide cuatro cosas:

1. explicar la relación entre `equals` y `hashCode`,
2. implementar ambos respetando el contrato,
3. escribir propiedades con un generador de puntos en `jqwik`,
4. validar con una propiedad geométrica: la distancia entre dos puntos sobre una recta paralela al eje X.

## La relación entre `equals` y `hashCode`

El contrato de `Object` establece dos reglas que son clave cuando una clase se va a usar en `HashMap` o `HashSet`:

- **Si dos objetos son iguales según `equals`, deben tener el mismo `hashCode`.** Es obligatorio. Si se rompe, las estructuras basadas en hashing dejan de funcionar (un objeto podría no encontrarse nunca porque se busca en el *bucket* equivocado).
- **La inversa no es obligatoria.** Dos objetos con el mismo hash no tienen por qué ser iguales: eso es una *colisión*. Es esperable, el hash es un entero con rango finito.

Al sobrescribir `equals` también hay que sobrescribir `hashCode` **consistentemente con esa definición**.

## `equals` y `hashCode`

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Point other = (Point) obj;
    return Float.compare(this.x, other.x) == 0
        && Float.compare(this.y, other.y) == 0;
}

@Override
public int hashCode() {
    int result = Float.floatToIntBits(x);
    result = 31 * result + Float.floatToIntBits(y);
    return result;
}
```

Detalles:

- `equals` usa `Float.compare(...)` en lugar de `==`. `==` trata mal los casos especiales de IEEE 754: `NaN == NaN` da `false` (rompería la reflexividad si un punto tuviera `NaN`); `-0.0f == +0.0f` da `true` aunque los bits son distintos. `Float.compare` resuelve los dos casos correctamente.
- `hashCode` combina las coordenadas usando `Float.floatToIntBits(...)`, que mapea el `float` a su representación binaria como `int`. Eso garantiza que dos `float` "iguales" según `Float.compare` produzcan el mismo `int`, y por lo tanto el mismo hash. La fórmula `31 * result + ...` es la clásica para mezclar campos.

## Generador y propiedad del contrato

```java
@Provide
Arbitrary<Point> puntos() {
    return Combinators.combine(coordenadas(), coordenadas())
        .as(Point::new);
}

@Provide
Arbitrary<Float> coordenadas() {
    return Arbitraries.floats().between(-10_000f, 10_000f);
}
```

El rango se acotó a `[-10_000, 10_000]` a propósito: evita `Float.NaN` o `Float.POSITIVE_INFINITY`, que son poco representativos del uso real y solo generarían ruido.

```java
@Property(tries = 250)
void puntosIgualesDebenTenerMismoHashCode(@ForAll("puntos") Point punto) {
    Point mismoPunto = new Point(punto.getX(), punto.getY());

    assertTrue(punto.equals(mismoPunto));
    assertEquals(punto.hashCode(), mismoPunto.hashCode());
}
```

## Propiedad geométrica: distancia sobre una recta paralela al eje X

Cuando dos puntos comparten la ordenada `y`, están sobre una recta horizontal y su distancia se reduce a `|x2 - x1|`. Es una buena propiedad para PBT: captura una invariante geométrica real, independiente de los valores concretos.

```java
@Property(tries = 250)
void distanciaEnRectaParalelaAlEjeXEsDiferenciaDeAbscisas(
    @ForAll("coordenadas") float x1,
    @ForAll("coordenadas") float x2,
    @ForAll("coordenadas") float y
) {
    Point p1 = new Point(x1, y);
    Point p2 = new Point(x2, y);

    double distanciaEsperada = Math.abs((double) (x2 - x1));
    double distanciaReal = p1.distanceTo(p2);

    assertEquals(distanciaEsperada, distanciaReal, 1.0e-6);
}
```

Se usa una **tolerancia numérica de `1e-6`** porque `distanceTo` implementa la fórmula euclídea con `Math.sqrt(Math.pow(...))`, y esas operaciones introducen errores de redondeo inevitables en aritmética de punto flotante. Sin tolerancia, la propiedad fallaría por diferencias ínfimas en el último bit.

## Cómo correr

```bash
cd tp7/assignmnet-7-rodeghiero
JAVA_HOME=$(/usr/libexec/java_home -v 17) mvn -Dmaven.repo.local=.m2 -Djacoco.skip=true \
    -Dtest=PointPropertiesTest test
```

Las dos propiedades pasan después de 250 iteraciones cada una.

## Archivos

- [`Point.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp7/assignmnet-7-rodeghiero/src/main/java/assignment7_exercises/point/Point.java) — implementación con `equals` y `hashCode`.
- [`PointPropertiesTest.java`](https://github.com/tomirodeghiero/testing-de-software-unrc/blob/main/tp7/assignmnet-7-rodeghiero/src/test/java/assignment7_exercises/point/PointPropertiesTest.java) — propiedades + generadores.

## Enlaces

- Resolución: [`resolucion_practico7.pdf`](/pdfs/tp7/resolucion_practico7.pdf)
