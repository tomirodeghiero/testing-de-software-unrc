package assignment2_exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class SimpleRoutinesParameterizedTest {

    @ParameterizedTest(name = "findLast({0}, {1}) -> {2}")
    @CsvSource({
        "'5,2,3', 2, 1",
        "'2,3,5', 2, 0"
    })
    void findLast_casosDelEjercicio3(String valores, int objetivo, int esperado) {
        assertEquals(esperado, SimpleRoutines.findLast(parseArray(valores), objetivo));
    }

    @ParameterizedTest(name = "lastZero({0}) -> {1}")
    @MethodSource("lastZeroCases")
    void lastZero_casosDelEjercicio3(int[] entrada, int esperado) {
        assertEquals(esperado, SimpleRoutines.lastZero(entrada));
    }

    @ParameterizedTest(name = "countPositive({0}) -> {1}")
    @MethodSource("countPositiveCases")
    void countPositive_casosDelEjercicio3(int[] entrada, int esperado) {
        assertEquals(esperado, SimpleRoutines.countPositive(entrada));
    }

    @ParameterizedTest(name = "oddOrPos({0}) -> {1}")
    @CsvFileSource(resources = "/assignment2_exercises/odd_or_pos_cases.csv", numLinesToSkip = 1)
    void oddOrPos_casosDelEjercicio3(String valores, int esperado) {
        assertEquals(esperado, SimpleRoutines.oddOrPos(parseArray(valores)));
    }

    private static Stream<Arguments> lastZeroCases() {
        return Stream.of(
            Arguments.of(new int[] {1, 0, 2}, 1),
            Arguments.of(new int[] {0, 1, 0}, 2)
        );
    }

    private static Stream<Arguments> countPositiveCases() {
        return Stream.of(
            Arguments.of(new int[] {}, 0),
            Arguments.of(new int[] {-4, 2, 2}, 2),
            Arguments.of(new int[] {-4, 2, 0, 2}, 2)
        );
    }

    private static int[] parseArray(String csvValues) {
        if (csvValues == null || csvValues.trim().isEmpty()) {
            return new int[] {};
        }

        return Arrays.stream(csvValues.split(","))
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}
