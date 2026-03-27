package assignment3_exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IteratorArrayListTest {

	private List<Integer> emptyBase;
	private List<Integer> nonEmptyBase;
	private List<Integer> withNullBase;

	@BeforeEach
	void setUp() {
		// Colecciones base para escenarios vacio, no vacio y con null.
		emptyBase = new ArrayList<>();
		nonEmptyBase = new ArrayList<>(Arrays.asList(10, 20));
		withNullBase = new ArrayList<>(Arrays.asList((Integer) null, 30));
	}

	@AfterEach
	void tearDown() {
		// Limpieza de referencias entre ejecuciones.
		emptyBase = null;
		nonEmptyBase = null;
		withNullBase = null;
	}

	/**
	 * C1: el iterador tiene mas valores ({true,false}).
	 * TC1 -> R01 (C1=true)
	 * TC2 -> R02 (C1=false)
	 * TC3 -> R03 (C1=false en estado agotado)
	 */
	@ParameterizedTest(name = "{0} -> hasNext={2} ({3})")
	@MethodSource("hasNextCases")
	void hasNext_shouldReflectIfIteratorHasMoreValues(
			String testCaseId,
			Iterator<Integer> iterator,
			boolean expected,
			String requirementsCovered) {
		// Assert directo: hasNext debe informar si existe un proximo valor.
		assertEquals(expected, iterator.hasNext(), testCaseId + " returned unexpected hasNext()");
	}

	/**
	 * C2: next() retorna objeto no null ({true,false}) con C1=true.
	 * TC4 -> R04 (C1=true, C2=true)
	 * TC5 -> R05 (C1=true, C2=false)
	 */
	@ParameterizedTest(name = "{0} -> next={2} ({3})")
	@MethodSource("nextValueCases")
	void next_shouldReturnExpectedValue_whenHasNextIsTrue(
			String testCaseId,
			Iterator<Integer> iterator,
			Integer expectedValue,
			String requirementsCovered) {
		// Si hay siguiente elemento, next debe devolver exactamente ese valor (incluso null).
		assertEquals(expectedValue, iterator.next(), testCaseId + " returned unexpected next()");
	}

	/**
	 * next() con C1=false debe lanzar NoSuchElementException.
	 * TC6 -> R06 (C1=false)
	 * TC7 -> R07 (C1=false en estado agotado)
	 */
	@ParameterizedTest(name = "{0} -> NoSuchElementException ({2})")
	@MethodSource("nextExceptionCases")
	void next_shouldThrowNoSuchElementException_whenNoMoreValues(
			String testCaseId,
			Iterator<Integer> iterator,
			String requirementsCovered) {
		// Cuando el iterador esta agotado, next debe lanzar NoSuchElementException.
		assertThrows(NoSuchElementException.class, iterator::next);
	}

	@Test
	void remove_shouldThrowUnsupportedOperationException_whenRemoveIsNotSupported() {
		// TC8 -> R08 (C3=false, C4=true)
		// Se usa una vista no modificable para forzar que remove no este soportado.
		List<Integer> backing = new ArrayList<>(Arrays.asList(1, 2, 3));
		Iterator<Integer> iterator = Collections.unmodifiableList(backing).iterator();
		iterator.next(); // C4=true (se llamo a next())

		// remove existe en la interfaz, pero esta implementacion debe rechazarlo.
		assertThrows(UnsupportedOperationException.class, iterator::remove);
	}

	/**
	 * remove() soportado, pero precondicion falsa (C4=false) => IllegalStateException.
	 * TC9 -> R09 (C3=true, C4=false, C1=true)
	 * TC10 -> R10 (C3=true, C4=false, C1=false)
	 * TC13 -> R13 (C3=true, C4=false tras remove previo)
	 */
	@ParameterizedTest(name = "{0} -> IllegalStateException ({2})")
	@MethodSource("removeIllegalStateCases")
	void remove_shouldThrowIllegalStateException_whenPreconditionIsNotSatisfied(
			String testCaseId,
			Iterator<Integer> iterator,
			String requirementsCovered) {
		// remove() requiere haber llamado a next() previamente y no repetir remove sin nuevo next().
		assertThrows(IllegalStateException.class, iterator::remove);
	}

	@Test
	void remove_shouldDeleteLastReturnedElement_whenSupportedAndHasMoreValues() {
		// TC11 -> R11 (C3=true, C4=true, C1=true)
		// Caso feliz: remove soportado y precondicion cumplida.
		List<Integer> backing = new ArrayList<>(Arrays.asList(5, 6));
		Iterator<Integer> iterator = backing.iterator();

		assertEquals(Integer.valueOf(5), iterator.next());
		assertTrue(iterator.hasNext()); // C1=true

		iterator.remove();

		// Debe eliminarse el ultimo elemento retornado por next() (el 5).
		assertEquals(Arrays.asList(6), backing);
	}

	@Test
	void remove_shouldDeleteLastReturnedElement_whenSupportedAndNoMoreValues() {
		// TC12 -> R12 (C3=true, C4=true, C1=false)
		// Aunque no queden mas elementos, remove sigue siendo valido despues de next().
		List<Integer> backing = new ArrayList<>(Arrays.asList(42));
		Iterator<Integer> iterator = backing.iterator();

		assertEquals(Integer.valueOf(42), iterator.next());
		assertFalse(iterator.hasNext()); // C1=false

		iterator.remove();

		// Se elimino el unico elemento de la lista.
		assertTrue(backing.isEmpty());
	}

	private Stream<Arguments> hasNextCases() {
		// Iterador agotado artificialmente para cubrir estado post-consumo total.
		Iterator<Integer> exhausted = new ArrayList<>(Arrays.asList(99)).iterator();
		exhausted.next();
		return Stream.of(
				Arguments.of("TC1", new ArrayList<>(nonEmptyBase).iterator(), true, "R01"),
				Arguments.of("TC2", new ArrayList<>(emptyBase).iterator(), false, "R02"),
				Arguments.of("TC3", exhausted, false, "R03"));
	}

	private Stream<Arguments> nextValueCases() {
		// Casos con valor no nulo y con valor nulo como primer elemento.
		return Stream.of(
				Arguments.of("TC4", new ArrayList<>(nonEmptyBase).iterator(), Integer.valueOf(10), "R04"),
				Arguments.of("TC5", new ArrayList<>(withNullBase).iterator(), null, "R05"));
	}

	private Stream<Arguments> nextExceptionCases() {
		// Segundo iterador agotado para validar excepcion en estado consumido.
		Iterator<Integer> exhausted = new ArrayList<>(Arrays.asList(88)).iterator();
		exhausted.next();
		return Stream.of(
				Arguments.of("TC6", new ArrayList<>(emptyBase).iterator(), "R06"),
				Arguments.of("TC7", exhausted, "R07"));
	}

	private Stream<Arguments> removeIllegalStateCases() {
		// Caso 1: hay elementos, pero nunca se llamo next().
		Iterator<Integer> hasMoreButNoNextYet = new ArrayList<>(Arrays.asList(1, 2)).iterator();
		// Caso 2: iterador vacio y sin next previo.
		Iterator<Integer> noMoreAndNoNext = new ArrayList<Integer>().iterator();

		// Caso 3: next() seguido de remove(), y luego un segundo remove sin next intermedio.
		Iterator<Integer> afterRemoveAlreadyCalled = new ArrayList<>(Arrays.asList(7)).iterator();
		afterRemoveAlreadyCalled.next();
		afterRemoveAlreadyCalled.remove();

		return Stream.of(
				Arguments.of("TC9", hasMoreButNoNextYet, "R09"),
				Arguments.of("TC10", noMoreAndNoNext, "R10"),
				Arguments.of("TC13", afterRemoveAlreadyCalled, "R13"));
	}
}
