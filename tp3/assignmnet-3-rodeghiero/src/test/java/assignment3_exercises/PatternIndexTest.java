package assignment3_exercises;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PatternIndexTest {

	private String nullString;
	private String emptyString;
	private String shortText;
	private String longText;

	@BeforeEach
	void setUp() {
		nullString = null;
		emptyString = "";
		shortText = "abc";
		longText = "abcde";
	}

	@AfterEach
	void tearDown() {
		nullString = null;
		emptyString = null;
		shortText = null;
		longText = null;
	}

	/**
	 * PWC (casos invalidos):
	 * TC1 -> R01 (subject null, pattern null)
	 * TC2 -> R02 (subject null, pattern non-null)
	 * TC3 -> R03 (subject non-null, pattern null)
	 */
	@ParameterizedTest(name = "{0} -> IllegalArgumentException ({3})")
	@MethodSource("invalidCases")
	void patternIndex_shouldThrowIllegalArgumentException_whenAnyInputIsNull(
			String testCaseId,
			String subject,
			String pattern,
			String requirementsCovered) {
		assertThrows(IllegalArgumentException.class,
				() -> PatternIndex.patternIndex(subject, pattern),
				testCaseId + " must throw IllegalArgumentException");
	}

	/**
	 * PWC (casos validos):
	 * TC4  -> R04,R05,R11
	 * TC5  -> R04,R06,R12
	 * TC6  -> R04,R07,R15
	 * TC7  -> R04,R08,R13
	 * TC8  -> R04,R08,R14
	 * TC9  -> R04,R08,R16
	 * TC10 -> R04,R09,R17
	 * TC11 -> R04,R09,R18
	 * TC12 -> R04,R09,R19
	 * TC13 -> R04,R09,R20
	 * TC14 -> R04,R08,R15
	 * TC15 -> R04,R10,R20
	 */
	@ParameterizedTest(name = "{0} -> expected={3} ({4})")
	@MethodSource("validCases")
	void patternIndex_shouldReturnExpectedIndex_forValidInputs(
			String testCaseId,
			String subject,
			String pattern,
			int expectedIndex,
			String requirementsCovered) {
		int actualIndex = PatternIndex.patternIndex(subject, pattern);
		assertEquals(expectedIndex, actualIndex, testCaseId + " returned an unexpected index");
	}

	private Stream<Arguments> invalidCases() {
		return Stream.of(
				Arguments.of("TC1", nullString, nullString, "R01"),
				Arguments.of("TC2", nullString, "a", "R02"),
				Arguments.of("TC3", shortText, nullString, "R03"));
	}

	private Stream<Arguments> validCases() {
		return Stream.of(
				Arguments.of("TC4", emptyString, emptyString, 0, "R04,R05,R11"),
				Arguments.of("TC5", shortText, emptyString, 0, "R04,R06,R12"),
				Arguments.of("TC6", emptyString, "a", -1, "R04,R07,R15"),
				Arguments.of("TC7", shortText, "a", 0, "R04,R08,R13"),
				Arguments.of("TC8", shortText, "b", 1, "R04,R08,R14"),
				Arguments.of("TC9", shortText, "c", 2, "R04,R08,R16"),
				Arguments.of("TC10", longText, "ab", 0, "R04,R09,R17"),
				Arguments.of("TC11", longText, "cd", 2, "R04,R09,R18"),
				Arguments.of("TC12", longText, "de", 3, "R04,R09,R19"),
				Arguments.of("TC13", longText, "fg", -1, "R04,R09,R20"),
				Arguments.of("TC14", shortText, "z", -1, "R04,R08,R15"),
				Arguments.of("TC15", emptyString, "ab", -1, "R04,R10,R20"));
	}
}
