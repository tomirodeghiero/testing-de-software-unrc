import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RepairedProgramsTest {
    @Test
    void findLast_debeEncontrarElValorEnLaPrimeraPosicionSiCorresponde() {
        assertEquals(0, RepairedPrograms.findLast(new int[] {2, 3, 5}, 2));
    }

    @Test
    void lastZero_debeRetornarElUltimoCero() {
        assertEquals(2, RepairedPrograms.lastZero(new int[] {0, 1, 0}));
    }

    @Test
    void countPositive_noDebeContarElCeroComoPositivo() {
        assertEquals(2, RepairedPrograms.countPositive(new int[] {-4, 2, 0, 2}));
    }

    @Test
    void oddOrPos_debeContarLosImparesNegativos() {
        assertEquals(3, RepairedPrograms.oddOrPos(new int[] {-3, -2, 0, 1, 4}));
    }
}
