package practico1_exercises.point_set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PointSetTest {
    @Test
    void unConjuntoNuevoDebeComenzarVacio() {
        // arrange
        PointSet pointSet = new PointSet();

        // act
        boolean result = pointSet.isEmpty();

        // assert
        assertTrue(result);
    }

    @Test
    void agregarDosPuntosIgualesNoDebeDuplicarlos() {
        // arrange
        PointSet pointSet = new PointSet();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        // act
        pointSet.add(p1);
        pointSet.add(p2);

        // assert
        assertEquals(1, pointSet.size());
    }

    @Test
    void containsDebeReconocerUnPuntoEquivalente() {
        // arrange
        PointSet pointSet = new PointSet();
        Point stored = new Point(3, 4);
        Point searched = new Point(3, 4);
        pointSet.add(stored);

        // act
        boolean result = pointSet.contains(searched);

        // assert
        assertTrue(result);
    }

    @Test
    void removeDebeEliminarUnPuntoEquivalente() {
        // arrange
        PointSet pointSet = new PointSet();
        Point stored = new Point(5, 6);
        Point removed = new Point(5, 6);
        pointSet.add(stored);

        // act
        boolean removedResult = pointSet.remove(removed);

        // assert
        assertTrue(removedResult);
        assertEquals(0, pointSet.size());
    }

    @Test
    void containsDebeDarFalseSiElPuntoNoEsta() {
        // arrange
        PointSet pointSet = new PointSet();
        pointSet.add(new Point(1, 1));

        // act
        boolean result = pointSet.contains(new Point(9, 9));

        // assert
        assertFalse(result);
    }
}
