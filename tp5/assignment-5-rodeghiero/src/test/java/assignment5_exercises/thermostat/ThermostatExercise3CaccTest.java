package assignment5_exercises.thermostat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ThermostatExercise3CaccTest {

    // p = ((a || (b && c)) && d)
    // Pares CACC usados:
    // a: (T,F,F,T) vs (F,F,F,T)
    // b: (F,T,T,T) vs (F,F,T,T)
    // c: (F,T,T,T) vs (F,T,F,T)
    // d: (T,F,F,T) vs (T,F,F,F)

    @Test
    public void caccMajorA() {
        ThermostatCoverageSupport.ExecutionResult tTrue =
            ThermostatCoverageSupport.runCase(true, false, false, true);
        ThermostatCoverageSupport.ExecutionResult tFalse =
            ThermostatCoverageSupport.runCase(false, false, false, true);

        assertEquals(tTrue.predicate, tTrue.returned);
        assertEquals(tFalse.predicate, tFalse.returned);
        assertTrue(tTrue.returned);
        assertFalse(tFalse.returned);
    }

    @Test
    public void caccMajorB() {
        ThermostatCoverageSupport.ExecutionResult tTrue =
            ThermostatCoverageSupport.runCase(false, true, true, true);
        ThermostatCoverageSupport.ExecutionResult tFalse =
            ThermostatCoverageSupport.runCase(false, false, true, true);

        assertEquals(tTrue.predicate, tTrue.returned);
        assertEquals(tFalse.predicate, tFalse.returned);
        assertTrue(tTrue.returned);
        assertFalse(tFalse.returned);
    }

    @Test
    public void caccMajorC() {
        ThermostatCoverageSupport.ExecutionResult tTrue =
            ThermostatCoverageSupport.runCase(false, true, true, true);
        ThermostatCoverageSupport.ExecutionResult tFalse =
            ThermostatCoverageSupport.runCase(false, true, false, true);

        assertEquals(tTrue.predicate, tTrue.returned);
        assertEquals(tFalse.predicate, tFalse.returned);
        assertTrue(tTrue.returned);
        assertFalse(tFalse.returned);
    }

    @Test
    public void caccMajorD() {
        ThermostatCoverageSupport.ExecutionResult tTrue =
            ThermostatCoverageSupport.runCase(true, false, false, true);
        ThermostatCoverageSupport.ExecutionResult tFalse =
            ThermostatCoverageSupport.runCase(true, false, false, false);

        assertEquals(tTrue.predicate, tTrue.returned);
        assertEquals(tFalse.predicate, tFalse.returned);
        assertTrue(tTrue.returned);
        assertFalse(tFalse.returned);
    }
}
