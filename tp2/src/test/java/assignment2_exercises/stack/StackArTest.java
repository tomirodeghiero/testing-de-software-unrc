package assignment2_exercises.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackArTest {

    private StackAr stack;

    @BeforeEach
    void setUp() {
        stack = new StackAr(3);
    }

    @Test
    void constructorConCapacidadNegativa_debeLanzarExcepcion() {
        // arrange
        int capacidad = -1;

        // act + assert
        assertThrows(IllegalArgumentException.class, () -> new StackAr(capacidad));
    }

    @Test
    void sizeEnPilaNueva_debeSerCero() {
        // arrange

        // act
        int size = stack.size();

        // assert
        assertEquals(0, size);
    }

    @Test
    void isEmptyEnPilaNueva_debeSerTrue() {
        // arrange

        // act
        boolean empty = stack.isEmpty();

        // assert
        assertTrue(empty);
    }

    @Test
    void isFullEnPilaNueva_debeSerFalse() {
        // arrange

        // act
        boolean full = stack.isFull();

        // assert
        assertFalse(full);
    }

    @Test
    void pushDebeAgregarElementoYActualizarTope() {
        // arrange
        String valor = "A";

        // act
        stack.push(valor);

        // assert
        assertEquals(1, stack.size());
        assertEquals(valor, stack.top());
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushConPilaLlena_debeLanzarExcepcion() {
        // arrange
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // act + assert
        assertThrows(IllegalStateException.class, () -> stack.push("D"));
    }

    @Test
    void pushConNull_debeLanzarExcepcion() {
        // arrange

        // act + assert
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }

    @Test
    void popDebeRetornarUltimoElementoYReducirSize() {
        // arrange
        stack.push("A");
        stack.push("B");

        // act
        Object valor = stack.pop();

        // assert
        assertEquals("B", valor);
        assertEquals(1, stack.size());
        assertEquals("A", stack.top());
    }

    @Test
    void popEnPilaVacia_debeLanzarExcepcion() {
        // arrange

        // act + assert
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    void topEnPilaVacia_debeLanzarExcepcion() {
        // arrange

        // act + assert
        assertThrows(IllegalStateException.class, () -> stack.top());
    }

    @Test
    void makeEmptyDebeVaciarLaPila() {
        // arrange
        stack.push("A");
        stack.push("B");

        // act
        stack.makeEmpty();

        // assert
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertThrows(IllegalStateException.class, () -> stack.top());
    }

    @Test
    void equalsYHashCodeParaPilasIguales_debenCoincidir() {
        // arrange
        StackAr otra = new StackAr(3);
        stack.push("A");
        stack.push("B");
        otra.push("A");
        otra.push("B");

        // act
        boolean iguales = stack.equals(otra);

        // assert
        assertTrue(iguales);
        assertEquals(stack.hashCode(), otra.hashCode());
    }

    @Test
    void equalsConOtraClase_debeSerFalse() {
        // arrange
        Object otroTipo = "no es una pila";

        // act
        boolean iguales = stack.equals(otroTipo);

        // assert
        assertFalse(iguales);
    }

    @Test
    void toStringDebeMostrarElementosEnOrdenDeCarga() {
        // arrange
        stack.push("A");
        stack.push("B");

        // act
        String salida = stack.toString();

        // assert
        assertEquals("[A,B]", salida);
    }

    @Test
    void repOkEnEstadoValido_debeRetornarTrue() {
        // arrange
        stack.push("A");
        stack.push("B");
        stack.pop();

        // act
        boolean ok = stack.repOk();

        // assert
        assertTrue(ok);
    }

    @Test
    void repOkConSpMenorQueMenosUno_debeRetornarFalse() throws Exception {
        // arrange
        setPrivateIntField(stack, "sp", -2);

        // act
        boolean ok = stack.repOk();

        // assert
        assertFalse(ok);
    }

    @Test
    void repOkConSpFueraDeRangoSuperior_debeRetornarFalse() throws Exception {
        // arrange
        Object[] elems = getElems(stack);
        setPrivateIntField(stack, "sp", elems.length);

        // act
        boolean ok = stack.repOk();

        // assert
        assertFalse(ok);
    }

    @Test
    void repOkConHuecoEnZonaActiva_debeRetornarFalse() throws Exception {
        // arrange
        stack.push("A");
        stack.push("B");
        Object[] elems = getElems(stack);
        elems[1] = null;

        // act
        boolean ok = stack.repOk();

        // assert
        assertFalse(ok);
    }

    @Test
    void repOkConBasuraFueraDeZonaActiva_debeRetornarFalse() throws Exception {
        // arrange
        stack.push("A");
        Object[] elems = getElems(stack);
        elems[2] = "basura";

        // act
        boolean ok = stack.repOk();

        // assert
        assertFalse(ok);
    }

    private static void setPrivateIntField(Object target, String fieldName, int value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(target, value);
    }

    private static Object[] getElems(StackAr target) throws Exception {
        Field field = target.getClass().getDeclaredField("elems");
        field.setAccessible(true);
        return (Object[]) field.get(target);
    }
}
