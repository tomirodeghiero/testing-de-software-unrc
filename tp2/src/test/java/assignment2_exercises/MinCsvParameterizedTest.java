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
        // arrange: convertimos la fila del CSV en una lista de Integer.
        // Ejemplo esperado en CSV: "5;2;9" -> [5, 2, 9].
        List<Integer> lista = parseIntegerList(valores);

        // act: ejecutamos la rutina bajo prueba.
        Integer actual = Min.min(lista);

        // assert: el resultado debe coincidir con el minimo esperado del caso.
        assertEquals(esperado, actual);
    }

    @ParameterizedTest(name = "min({0}) lanza {1}")
    @CsvFileSource(resources = "/assignment2_exercises/min_invalid_cases.csv", numLinesToSkip = 1)
    void min_conCasosInvalidosCsv_debeLanzarExcepcion(String valores, String excepcionEsperada) {
        // arrange: armamos la lista para un escenario invalido.
        List<Integer> lista = parseIntegerList(valores);

        // act + assert: confirmamos que se lance exactamente el tipo de excepcion indicado por CSV.
        assertThrows(exceptionType(excepcionEsperada), () -> Min.min(lista));
    }

    @Test
    void min_conListaNull_debeLanzarNullPointerException() {
        // arrange: entrada explicitamente nula.
        List<Integer> lista = null;

        // act + assert: min no debe aceptar referencias nulas.
        assertThrows(NullPointerException.class, () -> Min.min(lista));
    }

    @Test
    @SuppressWarnings({"rawtypes", "unchecked"})
    void min_conElementosNoComparables_debeLanzarClassCastException() {
        // arrange: lista heterogenea (Integer + String), no comparable entre si.
        // Se usa raw type para forzar el escenario en tiempo de ejecucion.
        List lista = Arrays.asList(1, "dos");

        // act + assert: al comparar elementos incompatibles debe fallar con ClassCastException.
        assertThrows(ClassCastException.class, () -> Min.min(lista));
    }

    private static Class<? extends Throwable> exceptionType(String name) {
        // Mapeo simple texto -> clase de excepcion para desacoplar los CSV del codigo Java.
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
        // "EMPTY", null o string vacio representa lista sin elementos.
        if (rawValues == null || rawValues.trim().isEmpty() || "EMPTY".equals(rawValues)) {
            return new ArrayList<>();
        }

        // Parseo por ";" para permitir listas en una sola celda CSV.
        List<Integer> result = new ArrayList<>();
        String[] tokens = rawValues.split(";");
        for (String token : tokens) {
            String value = token.trim();
            // Soporte explicito para literales null dentro del CSV.
            if ("null".equalsIgnoreCase(value)) {
                result.add(null);
            } else {
                result.add(Integer.parseInt(value));
            }
        }
        return result;
    }
}
