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
        // Se usa timeout para evitar bucles infinitos en casos de borde (bug historico de Zune).
        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            // Act: calculo del anio con la implementacion bajo prueba.
            int actual = ZuneBug.currentYear(days);
            // Assert: debe coincidir con el valor esperado del caso.
            assertEquals(esperado, actual);
        });
    }

    @ParameterizedTest(name = "days={0} coincide con oracle")
    @ValueSource(ints = {1, 2, 30, 31, 59, 60, 100, 365, 366, 367, 730, 731, 1095, 1461, 10000})
    void currentYear_debeCoincidirConOracle(int days) {
        // Comparacion diferencial: currentYear contra una implementacion oracle confiable.
        assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            int esperado = ZuneBug.oracle(days);
            int actual = ZuneBug.currentYear(days);
            assertEquals(esperado, actual);
        });
    }

    private static Stream<Arguments> casosDeBorde() {
        // Dias alrededor de limites relevantes: fin de anio y anios bisiestos.
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
