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
        // Se parsea la cadena CSV a arreglo y se valida el indice esperado.
        // Este test replica casos representativos del ejercicio 3.
        assertEquals(esperado, SimpleRoutines.findLast(parseArray(valores), objetivo));
    }

    @ParameterizedTest(name = "lastZero({0}) -> {1}")
    @MethodSource("lastZeroCases")
    void lastZero_casosDelEjercicio3(int[] entrada, int esperado) {
        // Verifica posicion del ultimo cero, o -1 si no existe.
        assertEquals(esperado, SimpleRoutines.lastZero(entrada));
    }

    @ParameterizedTest(name = "countPositive({0}) -> {1}")
    @MethodSource("countPositiveCases")
    void countPositive_casosDelEjercicio3(int[] entrada, int esperado) {
        // Cuenta solo positivos estrictos (> 0).
        assertEquals(esperado, SimpleRoutines.countPositive(entrada));
    }

    @ParameterizedTest(name = "oddOrPos({0}) -> {1}")
    @CsvFileSource(resources = "/assignment2_exercises/odd_or_pos_cases.csv", numLinesToSkip = 1)
    void oddOrPos_casosDelEjercicio3(String valores, int esperado) {
        // Fuente externa CSV para cubrir mas combinaciones de entrada/salida.
        assertEquals(esperado, SimpleRoutines.oddOrPos(parseArray(valores)));
    }

    private static Stream<Arguments> lastZeroCases() {
        // Casos de referencia: un cero intermedio y un cero final.
        return Stream.of(
            Arguments.of(new int[] {1, 0, 2}, 1),
            Arguments.of(new int[] {0, 1, 0}, 2)
        );
    }

    private static Stream<Arguments> countPositiveCases() {
        // Casos de referencia: arreglo vacio, mezcla sin ceros, mezcla con cero.
        return Stream.of(
            Arguments.of(new int[] {}, 0),
            Arguments.of(new int[] {-4, 2, 2}, 2),
            Arguments.of(new int[] {-4, 2, 0, 2}, 2)
        );
    }

    private static int[] parseArray(String csvValues) {
        // String vacio o null se interpreta como arreglo vacio.
        if (csvValues == null || csvValues.trim().isEmpty()) {
            return new int[] {};
        }

        // Parseo de "1, 2, 3" -> [1, 2, 3].
        return Arrays.stream(csvValues.split(","))
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}
