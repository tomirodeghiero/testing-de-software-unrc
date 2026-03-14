package practico1_exercises.point_set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PointTest {
    @Test
    void dosPuntosConLasMismasCoordenadasDebenSerIguales() {
        // arrange
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        // act
        boolean result = p1.equals(p2);

        // assert
        assertTrue(result);
    }

    @Test
    void dosPuntosConDistintasCoordenadasNoDebenSerIguales() {
        // arrange
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 1);

        // act
        boolean result = p1.equals(p2);

        // assert
        assertFalse(result);
    }

    @Test
    void unHashSetNoDebeGuardarDuplicadosSiLosPuntosSonIguales() {
        // arrange
        Set<Point> points = new HashSet<>();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        // act
        points.add(p1);
        points.add(p2);

        // assert
        assertEquals(1, points.size());
    }

    @Test
    void unHashSetDebeReconocerUnPuntoEquivalente() {
        // arrange
        Set<Point> points = new HashSet<>();
        Point stored = new Point(3, 4);
        Point searched = new Point(3, 4);
        points.add(stored);

        // act
        boolean result = points.contains(searched);

        // assert
        assertTrue(result);
    }
}
