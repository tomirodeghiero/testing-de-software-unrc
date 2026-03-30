package assignment5_exercises.thermostat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ThermostatExercise3ClauseCoverageTest {

    @Test
    public void suiteSatisfiesCCButNotPC() {
        // t1 = (a=T,b=F,c=F,d=F) => p=F
        ThermostatCoverageSupport.ExecutionResult t1 =
            ThermostatCoverageSupport.runCase(true, false, false, false);
        // t2 = (a=F,b=T,c=F,d=T) => p=F
        ThermostatCoverageSupport.ExecutionResult t2 =
            ThermostatCoverageSupport.runCase(false, true, false, true);
        // t3 = (a=F,b=F,c=T,d=T) => p=F
        ThermostatCoverageSupport.ExecutionResult t3 =
            ThermostatCoverageSupport.runCase(false, false, true, true);

        assertFalse(t1.returned);
        assertFalse(t2.returned);
        assertFalse(t3.returned);

        assertFalse(t1.heaterOn);
        assertFalse(t2.heaterOn);
        assertFalse(t3.heaterOn);

        Set<Boolean> as = new HashSet<Boolean>();
        Set<Boolean> bs = new HashSet<Boolean>();
        Set<Boolean> cs = new HashSet<Boolean>();
        Set<Boolean> ds = new HashSet<Boolean>();
        Set<Boolean> ps = new HashSet<Boolean>();

        for (ThermostatCoverageSupport.ExecutionResult t : new ThermostatCoverageSupport.ExecutionResult[]{t1, t2, t3}) {
            assertEquals(t.predicate, t.returned);
            as.add(t.a);
            bs.add(t.b);
            cs.add(t.c);
            ds.add(t.d);
            ps.add(t.predicate);
        }

        // CC lograda: cada cláusula toma T/F al menos una vez.
        assertEquals(2, as.size());
        assertEquals(2, bs.size());
        assertEquals(2, cs.size());
        assertEquals(2, ds.size());

        // PC no lograda: p no toma ambos valores.
        assertEquals(1, ps.size());
        assertTrue(ps.contains(false));
    }
}
