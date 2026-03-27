package practico1_exercises.point_set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PointSetTest {
    @Test
    void unConjuntoNuevoDebeComenzarVacio() {
        // arrange: se crea un PointSet recien inicializado.
        PointSet pointSet = new PointSet();

        // act: consultamos su estado de vacio.
        boolean result = pointSet.isEmpty();

        // assert: un conjunto nuevo no debe contener elementos.
        assertTrue(result);
    }

    @Test
    void agregarDosPuntosIgualesNoDebeDuplicarlos() {
        // arrange: preparamos dos puntos equivalentes para verificar unicidad logica.
        PointSet pointSet = new PointSet();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        // act: intentamos agregar ambos al conjunto.
        pointSet.add(p1);
        pointSet.add(p2);

        // assert: la cardinalidad debe mantenerse en 1.
        assertEquals(1, pointSet.size());
    }

    @Test
    void containsDebeReconocerUnPuntoEquivalente() {
        // arrange: agregamos una instancia y buscamos otra con mismas coordenadas.
        PointSet pointSet = new PointSet();
        Point stored = new Point(3, 4);
        Point searched = new Point(3, 4);
        pointSet.add(stored);

        // act: consultamos pertenencia por equivalencia de estado.
        boolean result = pointSet.contains(searched);

        // assert: contains debe responder true.
        assertTrue(result);
    }

    @Test
    void removeDebeEliminarUnPuntoEquivalente() {
        // arrange: cargamos un punto y creamos otro equivalente para remover.
        PointSet pointSet = new PointSet();
        Point stored = new Point(5, 6);
        Point removed = new Point(5, 6);
        pointSet.add(stored);

        // act: removemos usando un objeto distinto pero equivalente.
        boolean removedResult = pointSet.remove(removed);

        // assert: la operacion debe informar exito y el conjunto quedar vacio.
        assertTrue(removedResult);
        assertEquals(0, pointSet.size());
    }

    @Test
    void containsDebeDarFalseSiElPuntoNoEsta() {
        // arrange: el conjunto contiene solo (1,1).
        PointSet pointSet = new PointSet();
        pointSet.add(new Point(1, 1));

        // act: consultamos por un punto nunca agregado.
        boolean result = pointSet.contains(new Point(9, 9));

        // assert: el resultado esperado es false.
        assertFalse(result);
    }
}
