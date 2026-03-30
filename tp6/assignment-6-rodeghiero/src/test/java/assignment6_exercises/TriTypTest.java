package assignment6_exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriTypTest {

	@Test
	void test() {
	   assertEquals(3, TriTyp.triang(3, 3, 3));
	}

	@Test
	void testEscalenoValido() {
	   assertEquals(1, TriTyp.triang(3, 4, 5));
	}

	@Test
	void testNoTrianguloEscalenoPorDesigualdad() {
	   assertEquals(4, TriTyp.triang(1, 2, 3));
	}

	@Test
	void testNoTrianguloEscalenoPorDesigualdadPermutacionMayorEnLado1() {
	   assertEquals(4, TriTyp.triang(5, 2, 3));
	}

	@Test
	void testNoTrianguloEscalenoPorDesigualdadPermutacionMayorEnLado2() {
	   assertEquals(4, TriTyp.triang(2, 5, 3));
	}

	@Test
	void testNoTrianguloEscalenoPorDesigualdadEstrica() {
	   assertEquals(4, TriTyp.triang(2, 3, 10));
	}

	@Test
	void testIsoscelesLados12Valido() {
	   assertEquals(2, TriTyp.triang(2, 2, 3));
	}

	@Test
	void testIsoscelesLados12NoTriangulo() {
	   assertEquals(4, TriTyp.triang(1, 1, 2));
	}

	@Test
	void testIsoscelesLados13Valido() {
	   assertEquals(2, TriTyp.triang(2, 3, 2));
	}

	@Test
	void testIsoscelesLados13NoTriangulo() {
	   assertEquals(4, TriTyp.triang(1, 2, 1));
	}

	@Test
	void testIsoscelesLados23Valido() {
	   assertEquals(2, TriTyp.triang(3, 2, 2));
	}

	@Test
	void testIsoscelesLados23NoTriangulo() {
	   assertEquals(4, TriTyp.triang(2, 1, 1));
	}

	@Test
	void testLado1NoPositivo() {
	   assertEquals(4, TriTyp.triang(0, 2, 2));
	}

	@Test
	void testLado2NoPositivo() {
	   assertEquals(4, TriTyp.triang(2, 0, 2));
	}

	@Test
	void testLado3NoPositivo() {
	   assertEquals(4, TriTyp.triang(2, 2, 0));
	}

}
