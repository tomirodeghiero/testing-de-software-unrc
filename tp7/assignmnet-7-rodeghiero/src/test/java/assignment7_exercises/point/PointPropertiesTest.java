package assignment7_exercises.point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

class PointPropertiesTest {

    @Property(tries = 250)
    void puntosIgualesDebenTenerMismoHashCode(@ForAll("puntos") Point punto) {
        Point mismoPunto = new Point(punto.getX(), punto.getY());

        assertTrue(punto.equals(mismoPunto));
        assertEquals(punto.hashCode(), mismoPunto.hashCode());
    }

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

    @Provide
    Arbitrary<Point> puntos() {
        return Combinators.combine(coordenadas(), coordenadas())
            .as(Point::new);
    }

    @Provide
    Arbitrary<Float> coordenadas() {
        return Arbitraries.floats().between(-10_000f, 10_000f);
    }
}
