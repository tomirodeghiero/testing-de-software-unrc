package assignment2_exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ZuneBugParameterizedTest {

    @ParameterizedTest(name = "days={0} -> year={1}")
    @MethodSource("casosDeBorde")
    void currentYear_conCasosDeBorde_debeRetornarAnioCorrecto(int days, int esperado) {
        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            int actual = ZuneBug.currentYear(days);
            assertEquals(esperado, actual);
        });
    }

    @ParameterizedTest(name = "days={0} coincide con oracle")
    @ValueSource(ints = {1, 2, 30, 31, 59, 60, 100, 365, 366, 367, 730, 731, 1095, 1461, 10000})
    void currentYear_debeCoincidirConOracle(int days) {
        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            int esperado = ZuneBug.oracle(days);
            int actual = ZuneBug.currentYear(days);
            assertEquals(esperado, actual);
        });
    }

    private static Stream<Arguments> casosDeBorde() {
        return Stream.of(
            Arguments.of(1, 1980),
            Arguments.of(365, 1980),
            Arguments.of(366, 1981),
            Arguments.of(367, 1981),
            Arguments.of(731, 1982),
            Arguments.of(1461, 1984)
        );
    }
}
