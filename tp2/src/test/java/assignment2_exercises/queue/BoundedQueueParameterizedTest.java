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
        BoundedQueue queue = new BoundedQueue(capacity);
        List<String> dequeued = new ArrayList<>();

        assertTrue(queue.repOK());

        for (String op : splitOperations(operations)) {
            apply(queue, op, dequeued);
            assertTrue(queue.repOK(), "repOK no se cumple luego de: " + op);
        }

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
        BoundedQueue queue = new BoundedQueue(capacity);

        for (String op : splitOperations(setupOperations)) {
            apply(queue, op, new ArrayList<>());
            assertTrue(queue.repOK());
        }

        assertThrows(expectedException, () -> apply(queue, failingOperation, new ArrayList<>()));
        assertTrue(queue.repOK());
    }

    private static Stream<Arguments> validScenarios() {
        return Stream.of(
            Arguments.of(3, "E:a;E:b;D;E:c", "[b, c]", "a"),
            Arguments.of(3, "E:x;E:y;D;E:z;E:w", "[y, z, w]", "x"),
            Arguments.of(4, "E:1;E:2;E:3;D;D;E:4;E:5", "[3, 4, 5]", "1,2"),
            Arguments.of(2, "E:p;E:q;D;E:r", "[q, r]", "p"),
            Arguments.of(1, "E:solo;D", "[]", "solo")
        );
    }

    private static Stream<Arguments> invalidScenarios() {
        return Stream.of(
            Arguments.of(2, "", "D", IllegalStateException.class),
            Arguments.of(2, "", "E:null", NullPointerException.class),
            Arguments.of(2, "E:a;E:b", "E:c", IllegalStateException.class)
        );
    }

    private static List<String> splitOperations(String operations) {
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
        if ("D".equals(operation)) {
            Object value = queue.deQueue();
            dequeued.add(String.valueOf(value));
            return;
        }

        if (operation.startsWith("E:")) {
            String rawValue = operation.substring(2);
            Object value = "null".equals(rawValue) ? null : rawValue;
            queue.enQueue(value);
            return;
        }

        throw new IllegalArgumentException("Operacion no soportada: " + operation);
    }
}
