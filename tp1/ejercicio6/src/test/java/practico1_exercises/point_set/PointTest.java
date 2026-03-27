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
        // arrange: creamos dos instancias distintas con los mismos valores x,y.
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        // act: evaluamos la igualdad semantica entre ambos puntos.
        boolean result = p1.equals(p2);

        // assert: deben considerarse iguales por estado, no por referencia.
        assertTrue(result);
    }

    @Test
    void dosPuntosConDistintasCoordenadasNoDebenSerIguales() {
        // arrange: solo cambiamos el orden de coordenadas para romper la igualdad.
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 1);

        // act: comparamos ambos puntos.
        boolean result = p1.equals(p2);

        // assert: al no tener mismo estado interno, equals debe devolver false.
        assertFalse(result);
    }

    @Test
    void unHashSetNoDebeGuardarDuplicadosSiLosPuntosSonIguales() {
        // arrange: preparamos un Set y dos objetos equivalentes.
        // Si equals/hashCode estan bien implementados, ambos representan el mismo elemento logico.
        Set<Point> points = new HashSet<>();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        // act: intentamos agregar ambos puntos.
        points.add(p1);
        points.add(p2);

        // assert: el set debe conservar un unico elemento, sin duplicados.
        assertEquals(1, points.size());
    }

    @Test
    void unHashSetDebeReconocerUnPuntoEquivalente() {
        // arrange: guardamos un punto y luego buscamos otro punto equivalente.
        Set<Point> points = new HashSet<>();
        Point stored = new Point(3, 4);
        Point searched = new Point(3, 4);
        points.add(stored);

        // act: contains usa equals/hashCode para determinar pertenencia.
        boolean result = points.contains(searched);

        // assert: aunque sea otra instancia, debe ser reconocido como presente.
        assertTrue(result);
    }
}
