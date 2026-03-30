package assignment5_exercises.checkit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CheckItT1CaccTest {

    // T1 derivada para CACC sobre p = a && (b || c)
    // t1 = (T,T,F)
    // t2 = (F,T,F)
    // t3 = (T,F,F)
    // t4 = (T,F,T)

    @Test
    public void t1ContainsAValidCaccPairForMajorA() {
        boolean pWhenATrue = CheckIt.checkIt(true, true, false);
        boolean pWhenAFalse = CheckIt.checkIt(false, true, false);

        assertTrue(pWhenATrue);
        assertFalse(pWhenAFalse);
    }

    @Test
    public void t1ContainsAValidCaccPairForMajorB() {
        boolean pWhenBTrue = CheckIt.checkIt(true, true, false);
        boolean pWhenBFalse = CheckIt.checkIt(true, false, false);

        assertTrue(pWhenBTrue);
        assertFalse(pWhenBFalse);
    }

    @Test
    public void t1ContainsAValidCaccPairForMajorC() {
        boolean pWhenCTrue = CheckIt.checkIt(true, false, true);
        boolean pWhenCFalse = CheckIt.checkIt(true, false, false);

        assertTrue(pWhenCTrue);
        assertFalse(pWhenCFalse);
    }
}
