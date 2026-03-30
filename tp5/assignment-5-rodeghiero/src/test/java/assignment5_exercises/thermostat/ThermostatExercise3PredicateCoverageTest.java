package assignment5_exercises.thermostat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ThermostatExercise3PredicateCoverageTest {

    @Test
    public void suiteSatisfiesPCButNotCC() {
        // u1 = (a=T,b=T,c=T,d=T) => p=T
        ThermostatCoverageSupport.ExecutionResult u1 =
            ThermostatCoverageSupport.runCase(true, true, true, true);
        // u2 = (a=T,b=T,c=T,d=F) => p=F
        ThermostatCoverageSupport.ExecutionResult u2 =
            ThermostatCoverageSupport.runCase(true, true, true, false);

        assertTrue(u1.returned);
        assertFalse(u2.returned);

        assertTrue(u1.heaterOn);
        assertFalse(u2.heaterOn);

        Set<Boolean> as = new HashSet<Boolean>();
        Set<Boolean> bs = new HashSet<Boolean>();
        Set<Boolean> cs = new HashSet<Boolean>();
        Set<Boolean> ds = new HashSet<Boolean>();
        Set<Boolean> ps = new HashSet<Boolean>();

        for (ThermostatCoverageSupport.ExecutionResult t : new ThermostatCoverageSupport.ExecutionResult[]{u1, u2}) {
            assertEquals(t.predicate, t.returned);
            as.add(t.a);
            bs.add(t.b);
            cs.add(t.c);
            ds.add(t.d);
            ps.add(t.predicate);
        }

        // PC lograda.
        assertEquals(2, ps.size());
        assertTrue(ps.contains(true));
        assertTrue(ps.contains(false));

        // CC no lograda (a,b,c nunca toman F en esta suite).
        assertEquals(1, as.size());
        assertEquals(1, bs.size());
        assertEquals(1, cs.size());
        assertEquals(2, ds.size());
    }
}
