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
        // Todas las pruebas parten de una pila acotada de capacidad 3.
        stack = new StackAr(3);
    }

    @Test
    void constructorConCapacidadNegativa_debeLanzarExcepcion() {
        // arrange: capacidad invalida (negativa).
        int capacidad = -1;

        // act + assert: el constructor debe defender su precondicion.
        assertThrows(IllegalArgumentException.class, () -> new StackAr(capacidad));
    }

    @Test
    void sizeEnPilaNueva_debeSerCero() {
        // arrange: no hace falta preparar estado adicional.

        // act: consultamos size inmediatamente despues de crear la pila.
        int size = stack.size();

        // assert: no hay elementos cargados.
        assertEquals(0, size);
    }

    @Test
    void isEmptyEnPilaNueva_debeSerTrue() {
        // arrange: pila recien creada.

        // act: validamos bandera de vacio.
        boolean empty = stack.isEmpty();

        // assert: una pila nueva debe estar vacia.
        assertTrue(empty);
    }

    @Test
    void isFullEnPilaNueva_debeSerFalse() {
        // arrange: pila recien creada.

        // act: consultamos si esta llena.
        boolean full = stack.isFull();

        // assert: todavia hay espacio disponible.
        assertFalse(full);
    }

    @Test
    void pushDebeAgregarElementoYActualizarTope() {
        // arrange: valor a insertar en la cima.
        String valor = "A";

        // act: apilamos el elemento.
        stack.push(valor);

        // assert: crece el tamano, top refleja el ultimo insertado y ya no esta vacia.
        assertEquals(1, stack.size());
        assertEquals(valor, stack.top());
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushConPilaLlena_debeLanzarExcepcion() {
        // arrange: llenamos completamente la pila (capacidad 3).
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // act + assert: insertar un cuarto elemento debe fallar.
        assertThrows(IllegalStateException.class, () -> stack.push("D"));
    }

    @Test
    void pushConNull_debeLanzarExcepcion() {
        // arrange: no se requiere estado previo.

        // act + assert: push no debe aceptar null.
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }

    @Test
    void popDebeRetornarUltimoElementoYReducirSize() {
        // arrange: cargamos dos elementos para verificar comportamiento LIFO.
        stack.push("A");
        stack.push("B");

        // act: desapilamos una vez.
        Object valor = stack.pop();

        // assert:
        // 1) sale "B" (ultimo en entrar),
        // 2) size baja a 1,
        // 3) la nueva cima es "A".
        assertEquals("B", valor);
        assertEquals(1, stack.size());
        assertEquals("A", stack.top());
    }

    @Test
    void popEnPilaVacia_debeLanzarExcepcion() {
        // arrange: pila vacia.

        // act + assert: no se puede desapilar sin elementos.
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    void topEnPilaVacia_debeLanzarExcepcion() {
        // arrange: pila vacia.

        // act + assert: consultar top en vacio debe fallar.
        assertThrows(IllegalStateException.class, () -> stack.top());
    }

    @Test
    void makeEmptyDebeVaciarLaPila() {
        // arrange: arrancamos con estado no vacio.
        stack.push("A");
        stack.push("B");

        // act: limpiamos completamente la estructura.
        stack.makeEmpty();

        // assert: estado equivalente al inicial.
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertThrows(IllegalStateException.class, () -> stack.top());
    }

    @Test
    void equalsYHashCodeParaPilasIguales_debenCoincidir() {
        // arrange: dos pilas con la misma capacidad y misma secuencia de carga.
        StackAr otra = new StackAr(3);
        stack.push("A");
        stack.push("B");
        otra.push("A");
        otra.push("B");

        // act: evaluamos igualdad entre objetos.
        boolean iguales = stack.equals(otra);

        // assert: contrato equals/hashCode consistente para objetos equivalentes.
        assertTrue(iguales);
        assertEquals(stack.hashCode(), otra.hashCode());
    }

    @Test
    void equalsConOtraClase_debeSerFalse() {
        // arrange: objeto de otro tipo.
        Object otroTipo = "no es una pila";

        // act: comparamos stack contra String.
        boolean iguales = stack.equals(otroTipo);

        // assert: equals debe rechazar clases incompatibles.
        assertFalse(iguales);
    }

    @Test
    void toStringDebeMostrarElementosEnOrdenDeCarga() {
        // arrange: secuencia conocida para validar representacion textual.
        stack.push("A");
        stack.push("B");

        // act: obtenemos el string de la pila.
        String salida = stack.toString();

        // assert: se espera formato sin espacios y en orden de carga.
        assertEquals("[A,B]", salida);
    }

    @Test
    void repOkEnEstadoValido_debeRetornarTrue() {
        // arrange: operaciones validas que dejan estructura consistente.
        stack.push("A");
        stack.push("B");
        stack.pop();

        // act: chequeo de invariantes internas.
        boolean ok = stack.repOk();

        // assert: el estado debe ser valido.
        assertTrue(ok);
    }

    @Test
    void repOkConSpMenorQueMenosUno_debeRetornarFalse() throws Exception {
        // arrange: forzamos por reflexion un valor imposible para sp.
        setPrivateIntField(stack, "sp", -2);

        // act: evaluamos invariante.
        boolean ok = stack.repOk();

        // assert: debe detectar corrupcion del estado interno.
        assertFalse(ok);
    }

    @Test
    void repOkConSpFueraDeRangoSuperior_debeRetornarFalse() throws Exception {
        // arrange: sp igual al largo de elems ya queda fuera de rango valido.
        Object[] elems = getElems(stack);
        setPrivateIntField(stack, "sp", elems.length);

        // act: chequeo de repOk.
        boolean ok = stack.repOk();

        // assert: invariante violada => false.
        assertFalse(ok);
    }

    @Test
    void repOkConHuecoEnZonaActiva_debeRetornarFalse() throws Exception {
        // arrange: dejamos un null dentro de la zona "activa" (0..sp).
        stack.push("A");
        stack.push("B");
        Object[] elems = getElems(stack);
        elems[1] = null;

        // act: validacion de invariantes.
        boolean ok = stack.repOk();

        // assert: un hueco en zona activa debe invalidar la representacion.
        assertFalse(ok);
    }

    @Test
    void repOkConBasuraFueraDeZonaActiva_debeRetornarFalse() throws Exception {
        // arrange: insertamos dato residual fuera de la zona activa.
        stack.push("A");
        Object[] elems = getElems(stack);
        elems[2] = "basura";

        // act: chequeamos repOk tras la corrupcion.
        boolean ok = stack.repOk();

        // assert: la zona inactiva debe permanecer limpia (null), por eso esperamos false.
        assertFalse(ok);
    }

    private static void setPrivateIntField(Object target, String fieldName, int value) throws Exception {
        // Helper de pruebas: permite simular estados internos no alcanzables desde la API publica.
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(target, value);
    }

    private static Object[] getElems(StackAr target) throws Exception {
        // Helper de pruebas: expone el arreglo interno para inyectar corrupciones controladas.
        Field field = target.getClass().getDeclaredField("elems");
        field.setAccessible(true);
        return (Object[]) field.get(target);
    }
}
