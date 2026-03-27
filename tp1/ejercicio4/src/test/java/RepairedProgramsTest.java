import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RepairedProgramsTest {
    @Test
    void findLast_debeEncontrarElValorEnLaPrimeraPosicionSiCorresponde() {
        // Este caso verifica que, si el valor buscado esta en la posicion 0,
        // el algoritmo no lo "saltea" y devuelve correctamente ese indice.
        assertEquals(0, RepairedPrograms.findLast(new int[] {2, 3, 5}, 2));
    }

    @Test
    void lastZero_debeRetornarElUltimoCero() {
        // Hay dos ceros en el arreglo: posiciones 0 y 2.
        // La funcion debe devolver el indice del ultimo cero encontrado.
        assertEquals(2, RepairedPrograms.lastZero(new int[] {0, 1, 0}));
    }

    @Test
    void countPositive_noDebeContarElCeroComoPositivo() {
        // Solo los valores estrictamente mayores a cero cuentan como positivos.
        // El cero no suma al contador.
        assertEquals(2, RepairedPrograms.countPositive(new int[] {-4, 2, 0, 2}));
    }

    @Test
    void oddOrPos_debeContarLosImparesNegativos() {
        // La rutina cuenta elementos que sean impares O positivos.
        // En este ejemplo se cuentan -3 (impar), 1 (impar y positivo) y 4 (positivo).
        assertEquals(3, RepairedPrograms.oddOrPos(new int[] {-3, -2, 0, 1, 4}));
    }
}
