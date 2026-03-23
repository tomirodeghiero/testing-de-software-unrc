package assignment2_exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class MinCsvParameterizedTest {

    @ParameterizedTest(name = "min({0}) -> {1}")
    @CsvFileSource(resources = "/assignment2_exercises/min_valid_cases.csv", numLinesToSkip = 1)
    void min_conCasosValidosCsv_debeRetornarMinimo(String valores, int esperado) {
        // arrange
        List<Integer> lista = parseIntegerList(valores);

        // act
        Integer actual = Min.min(lista);

        // assert
        assertEquals(esperado, actual);
    }

    @ParameterizedTest(name = "min({0}) lanza {1}")
    @CsvFileSource(resources = "/assignment2_exercises/min_invalid_cases.csv", numLinesToSkip = 1)
    void min_conCasosInvalidosCsv_debeLanzarExcepcion(String valores, String excepcionEsperada) {
        // arrange
        List<Integer> lista = parseIntegerList(valores);

        // act + assert
        assertThrows(exceptionType(excepcionEsperada), () -> Min.min(lista));
    }

    @Test
    void min_conListaNull_debeLanzarNullPointerException() {
        // arrange
        List<Integer> lista = null;

        // act + assert
        assertThrows(NullPointerException.class, () -> Min.min(lista));
    }

    @Test
    @SuppressWarnings({"rawtypes", "unchecked"})
    void min_conElementosNoComparables_debeLanzarClassCastException() {
        // arrange
        List lista = Arrays.asList(1, "dos");

        // act + assert
        assertThrows(ClassCastException.class, () -> Min.min(lista));
    }

    private static Class<? extends Throwable> exceptionType(String name) {
        switch (name) {
            case "IllegalArgumentException":
                return IllegalArgumentException.class;
            case "NullPointerException":
                return NullPointerException.class;
            case "ClassCastException":
                return ClassCastException.class;
            default:
                throw new IllegalArgumentException("Excepcion no soportada: " + name);
        }
    }

    private static List<Integer> parseIntegerList(String rawValues) {
        if (rawValues == null || rawValues.trim().isEmpty() || "EMPTY".equals(rawValues)) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        String[] tokens = rawValues.split(";");
        for (String token : tokens) {
            String value = token.trim();
            if ("null".equalsIgnoreCase(value)) {
                result.add(null);
            } else {
                result.add(Integer.parseInt(value));
            }
        }
        return result;
    }
}
