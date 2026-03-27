package assignment2_exercises.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BoundedQueueParameterizedTest {

    @ParameterizedTest(name = "cap={0}, ops={1}")
    @MethodSource("validScenarios")
    void repOK_debeMantenerseTrasOperacionesValidas(
        int capacity,
        String operations,
        String expectedQueue,
        String expectedDequeued
    ) {
        // arrange: cola acotada para el escenario actual y registro de elementos desencolados.
        BoundedQueue queue = new BoundedQueue(capacity);
        List<String> dequeued = new ArrayList<>();

        // La representacion debe ser valida desde el estado inicial.
        assertTrue(queue.repOK());

        // act: aplicamos la secuencia textual de operaciones una por una.
        for (String op : splitOperations(operations)) {
            apply(queue, op, dequeued);
            // Cada paso debe preservar invariantes internas.
            assertTrue(queue.repOK(), "repOK no se cumple luego de: " + op);
        }

        // assert final:
        // 1) contenido remanente de la cola
        // 2) historial de elementos extraidos
        assertEquals(expectedQueue, queue.toString());
        assertEquals(expectedDequeued, String.join(",", dequeued));
    }

    @ParameterizedTest(name = "cap={0}, setup={1}, fail={2}, ex={3}")
    @MethodSource("invalidScenarios")
    void repOK_debeMantenerseCuandoUnaOperacionInvalidaLanzaExcepcion(
        int capacity,
        String setupOperations,
        String failingOperation,
        Class<? extends Throwable> expectedException
    ) {
        // arrange: preparamos cola y la llevamos a un estado previo controlado.
        BoundedQueue queue = new BoundedQueue(capacity);

        // Ejecutamos operaciones validas de setup, verificando repOK en cada transicion.
        for (String op : splitOperations(setupOperations)) {
            apply(queue, op, new ArrayList<>());
            assertTrue(queue.repOK());
        }

        // act + assert: la operacion invalida debe fallar con la excepcion esperada...
        assertThrows(expectedException, () -> apply(queue, failingOperation, new ArrayList<>()));
        // ...y aun asi la cola debe permanecer en estado consistente.
        assertTrue(queue.repOK());
    }

    private static Stream<Arguments> validScenarios() {
        // Escenarios de uso correcto: mezcla de enqueues/dequeues con distintos tamanos de capacidad.
        return Stream.of(
            Arguments.of(3, "E:a;E:b;D;E:c", "[b, c]", "a"),
            Arguments.of(3, "E:x;E:y;D;E:z;E:w", "[y, z, w]", "x"),
            Arguments.of(4, "E:1;E:2;E:3;D;D;E:4;E:5", "[3, 4, 5]", "1,2"),
            Arguments.of(2, "E:p;E:q;D;E:r", "[q, r]", "p"),
            Arguments.of(1, "E:solo;D", "[]", "solo")
        );
    }

    private static Stream<Arguments> invalidScenarios() {
        // Escenarios con falla esperada:
        // 1) dequeue en vacio
        // 2) enqueue de null
        // 3) enqueue cuando la cola ya esta llena
        return Stream.of(
            Arguments.of(2, "", "D", IllegalStateException.class),
            Arguments.of(2, "", "E:null", NullPointerException.class),
            Arguments.of(2, "E:a;E:b", "E:c", IllegalStateException.class)
        );
    }

    private static List<String> splitOperations(String operations) {
        // Convierte "E:a;D;E:b" en ["E:a", "D", "E:b"].
        List<String> result = new ArrayList<>();
        if (operations == null || operations.trim().isEmpty()) {
            return result;
        }

        for (String op : operations.split(";")) {
            String trimmed = op.trim();
            if (!trimmed.isEmpty()) {
                result.add(trimmed);
            }
        }
        return result;
    }

    private static void apply(BoundedQueue queue, String operation, List<String> dequeued) {
        // "D" representa deQueue.
        if ("D".equals(operation)) {
            Object value = queue.deQueue();
            dequeued.add(String.valueOf(value));
            return;
        }

        // "E:valor" representa enQueue(valor).
        if (operation.startsWith("E:")) {
            String rawValue = operation.substring(2);
            // Permite simular nulos en escenarios invalidos.
            Object value = "null".equals(rawValue) ? null : rawValue;
            queue.enQueue(value);
            return;
        }

        // Cualquier otra codificacion se considera error del caso de prueba.
        throw new IllegalArgumentException("Operacion no soportada: " + operation);
    }
}
