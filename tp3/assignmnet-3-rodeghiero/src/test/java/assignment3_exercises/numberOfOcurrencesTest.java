package assignment3_exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class numberOfOcurrencesTest {

	private static final String NULL_LIST = "NULL_LIST";
	private static final String EMPTY_LIST = "EMPTY_LIST";
	private static final String NON_EMPTY_NO_TARGET = "NON_EMPTY_NO_TARGET";
	private static final String NON_EMPTY_ONE_TARGET = "NON_EMPTY_ONE_TARGET";
	private static final String NON_EMPTY_MULTIPLE_TARGET = "NON_EMPTY_MULTIPLE_TARGET";

	private List<Integer> emptyList;
	private List<Integer> nonEmptyNoTargetList;
	private List<Integer> nonEmptyOneTargetList;
	private List<Integer> nonEmptyMultipleTargetList;

	@BeforeEach
	void setUp() {
		emptyList = new ArrayList<>();
		nonEmptyNoTargetList = new ArrayList<>(Arrays.asList(1, 2, 3));
		nonEmptyOneTargetList = new ArrayList<>(Arrays.asList(1, 2, 3));
		nonEmptyMultipleTargetList = new ArrayList<>(Arrays.asList(4, 1, 4, 4));
	}

	@AfterEach
	void tearDown() {
		emptyList = null;
		nonEmptyNoTargetList = null;
		nonEmptyOneTargetList = null;
		nonEmptyMultipleTargetList = null;
	}

	/**
	 * Modelo MDE (cap. 6):
	 * C1: l ref = {L0:null, L1:not-null}
	 * C2: element ref = {E0:null, E1:not-null}
	 * C3: list size = {S0:empty, S1:non-empty} (si L1)
	 * C4: occurrences = {O0:0, O1:1, O2:>1} (si L1 y E1)
	 *
	 * Cobertura de pares (PWC) en invalidos:
	 * TC1 -> R01 (L0,E0)
	 * TC2 -> R02 (L0,E1)
	 * TC3 -> R03,R05,R10 (L1,E0), (L1,S0), (E0,S0)
	 * TC4 -> R03,R06,R11 (L1,E0), (L1,S1), (E0,S1)
	 */
	@ParameterizedTest(name = "{0} -> IllegalArgumentException ({3})")
	@MethodSource("invalidInputCases")
	void numberOfOcurrences_shouldThrow_whenInputIsInvalid(
			String testCaseId,
			String listScenario,
			Integer element,
			String requirementsCovered) {
		List<Integer> list = listForScenario(listScenario);

		assertThrows(IllegalArgumentException.class,
				() -> ListUtils.numberOfOcurrences(list, element),
				testCaseId + " must throw IllegalArgumentException");
	}

	/**
	 * Cobertura de pares (PWC) en validos:
	 * TC5 -> R04,R05,R07,R12,R14,R17
	 * TC6 -> R04,R06,R07,R13,R14,R18
	 * TC7 -> R04,R06,R08,R13,R15,R19
	 * TC8 -> R04,R06,R09,R13,R16,R20
	 */
	@ParameterizedTest(name = "{0} -> expected={3} ({4})")
	@MethodSource("validInputCases")
	void numberOfOcurrences_shouldCount_whenInputIsValid(
			String testCaseId,
			String listScenario,
			Integer element,
			int expectedCount,
			String requirementsCovered) {
		List<Integer> list = listForScenario(listScenario);

		int actualCount = ListUtils.numberOfOcurrences(list, element);

		assertEquals(expectedCount, actualCount,
				testCaseId + " returned an unexpected occurrence count");
	}

	@Test
	void numberOfOcurrences_shouldNotModifyInputList() {
		// Requisito adicional de robustez: la rutina no debe mutar la lista recibida.
		List<Integer> original = new ArrayList<>(nonEmptyMultipleTargetList);

		ListUtils.numberOfOcurrences(nonEmptyMultipleTargetList, 4);

		assertEquals(original, nonEmptyMultipleTargetList);
	}

	private List<Integer> listForScenario(String listScenario) {
		switch (listScenario) {
		case NULL_LIST:
			return null;
		case EMPTY_LIST:
			return emptyList;
		case NON_EMPTY_NO_TARGET:
			return nonEmptyNoTargetList;
		case NON_EMPTY_ONE_TARGET:
			return nonEmptyOneTargetList;
		case NON_EMPTY_MULTIPLE_TARGET:
			return nonEmptyMultipleTargetList;
		default:
			throw new IllegalArgumentException("Unknown list scenario: " + listScenario);
		}
	}

	private static Stream<Arguments> invalidInputCases() {
		return Stream.of(
				Arguments.of("TC1", NULL_LIST, (Integer) null, "R01"),
				Arguments.of("TC2", NULL_LIST, 7, "R02"),
				Arguments.of("TC3", EMPTY_LIST, (Integer) null, "R03,R05,R10"),
				Arguments.of("TC4", NON_EMPTY_NO_TARGET, (Integer) null, "R03,R06,R11"));
	}

	private static Stream<Arguments> validInputCases() {
		return Stream.of(
				Arguments.of("TC5", EMPTY_LIST, 5, 0, "R04,R05,R07,R12,R14,R17"),
				Arguments.of("TC6", NON_EMPTY_NO_TARGET, 9, 0, "R04,R06,R07,R13,R14,R18"),
				Arguments.of("TC7", NON_EMPTY_ONE_TARGET, 2, 1, "R04,R06,R08,R13,R15,R19"),
				Arguments.of("TC8", NON_EMPTY_MULTIPLE_TARGET, 4, 3, "R04,R06,R09,R13,R16,R20"));
	}

}
