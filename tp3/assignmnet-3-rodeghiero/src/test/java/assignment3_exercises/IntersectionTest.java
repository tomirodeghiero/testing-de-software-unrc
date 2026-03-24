package assignment3_exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntersectionTest {

	private static final String NULL_SET = "NULL_SET";
	private static final String EMPTY_SET = "EMPTY_SET";
	private static final String BASE_SET = "BASE_SET";
	private static final String EQUAL_SET = "EQUAL_SET";
	private static final String SUBSET_OF_BASE = "SUBSET_OF_BASE";
	private static final String SUPERSET_OF_BASE = "SUPERSET_OF_BASE";
	private static final String DISJOINT_SET = "DISJOINT_SET";
	private static final String PARTIAL_OVERLAP_SET = "PARTIAL_OVERLAP_SET";

	private Set<Integer> baseSet;
	private Set<Integer> equalSet;
	private Set<Integer> emptySet;
	private Set<Integer> subsetOfBaseSet;
	private Set<Integer> supersetOfBaseSet;
	private Set<Integer> disjointSet;
	private Set<Integer> partialOverlapSet;

	@BeforeEach
	void setUp() {
		baseSet = setOf(1, 2, 3);
		equalSet = setOf(1, 2, 3);
		emptySet = setOf();
		subsetOfBaseSet = setOf(1, 2);
		supersetOfBaseSet = setOf(1, 2, 3, 4);
		disjointSet = setOf(4, 5, 6);
		partialOverlapSet = setOf(3, 4, 5);
	}

	@AfterEach
	void tearDown() {
		baseSet = null;
		equalSet = null;
		emptySet = null;
		subsetOfBaseSet = null;
		supersetOfBaseSet = null;
		disjointSet = null;
		partialOverlapSet = null;
	}

	/**
	 * Requisitos BC invalidos (C3 no aplica por null):
	 * TC2 -> TR-BC2 (C1.b1)
	 * TC4 -> TR-BC4 (C2.b1)
	 */
	@ParameterizedTest(name = "{0} -> NullPointerException ({3})")
	@MethodSource("invalidCases")
	void intersection_shouldThrowNullPointerException_whenInputIsNull(
			String testCaseId,
			String set1Scenario,
			String set2Scenario,
			String requirementCovered) {
		Set<Integer> set1 = setForScenario(set1Scenario);
		Set<Integer> set2 = setForScenario(set2Scenario);

		assertThrows(NullPointerException.class, () -> SetUtils.intersection(set1, set2));
	}

	/**
	 * Requisitos BC validos:
	 * TC1 -> TR-BC1 (base)
	 * TC3 -> TR-BC3 (C1.b2 ajustado por factibilidad)
	 * TC5 -> TR-BC5 (C2.b2 ajustado por factibilidad)
	 * TC6 -> TR-BC6 (C3.b2)
	 * TC7 -> TR-BC7 (C3.b3)
	 * TC8 -> TR-BC8 (C3.b4)
	 * TC9 -> TR-BC9 (C3.b5)
	 */
	@ParameterizedTest(name = "{0} -> expected={3} ({4})")
	@MethodSource("validCases")
	void intersection_shouldReturnExpectedSet_withoutModifyingInputs(
			String testCaseId,
			String set1Scenario,
			String set2Scenario,
			Set<Integer> expectedIntersection,
			String requirementCovered) {
		Set<Integer> set1 = setForScenario(set1Scenario);
		Set<Integer> set2 = setForScenario(set2Scenario);

		Set<Integer> beforeSet1 = new HashSet<>(set1);
		Set<Integer> beforeSet2 = new HashSet<>(set2);

		Set<Integer> result = SetUtils.intersection(set1, set2);

		assertEquals(expectedIntersection, result, testCaseId + " returned incorrect intersection");
		assertEquals(beforeSet1, set1, testCaseId + " must not modify set1");
		assertEquals(beforeSet2, set2, testCaseId + " must not modify set2");
		assertNotSame(set1, result, testCaseId + " must return a new set instance");
		assertNotSame(set2, result, testCaseId + " must return a new set instance");
	}

	@Test
	void intersection_shouldReturnEmptySet_whenBothSetsAreEmpty() {
		// Cobertura adicional de borde: C1.b2 + C2.b2 + C3.b1 (igualdad vacia).
		Set<Integer> result = SetUtils.intersection(emptySet, emptySet);
		assertEquals(Collections.emptySet(), result);
	}

	private static Stream<Arguments> invalidCases() {
		return Stream.of(
				Arguments.of("TC2", NULL_SET, BASE_SET, "TR-BC2"),
				Arguments.of("TC4", BASE_SET, NULL_SET, "TR-BC4"));
	}

	private static Stream<Arguments> validCases() {
		return Stream.of(
				Arguments.of("TC1", BASE_SET, EQUAL_SET, setOf(1, 2, 3), "TR-BC1"),
				Arguments.of("TC3", EMPTY_SET, BASE_SET, setOf(), "TR-BC3"),
				Arguments.of("TC5", BASE_SET, EMPTY_SET, setOf(), "TR-BC5"),
				Arguments.of("TC6", SUBSET_OF_BASE, SUPERSET_OF_BASE, setOf(1, 2), "TR-BC6"),
				Arguments.of("TC7", SUPERSET_OF_BASE, SUBSET_OF_BASE, setOf(1, 2), "TR-BC7"),
				Arguments.of("TC8", BASE_SET, DISJOINT_SET, setOf(), "TR-BC8"),
				Arguments.of("TC9", BASE_SET, PARTIAL_OVERLAP_SET, setOf(3), "TR-BC9"));
	}

	private Set<Integer> setForScenario(String scenario) {
		switch (scenario) {
		case NULL_SET:
			return null;
		case EMPTY_SET:
			return copy(emptySet);
		case BASE_SET:
			return copy(baseSet);
		case EQUAL_SET:
			return copy(equalSet);
		case SUBSET_OF_BASE:
			return copy(subsetOfBaseSet);
		case SUPERSET_OF_BASE:
			return copy(supersetOfBaseSet);
		case DISJOINT_SET:
			return copy(disjointSet);
		case PARTIAL_OVERLAP_SET:
			return copy(partialOverlapSet);
		default:
			throw new IllegalArgumentException("Unknown set scenario: " + scenario);
		}
	}

	private static Set<Integer> setOf(Integer... values) {
		return new HashSet<>(Arrays.asList(values));
	}

	private static Set<Integer> copy(Set<Integer> source) {
		return source == null ? null : new HashSet<>(source);
	}
}
