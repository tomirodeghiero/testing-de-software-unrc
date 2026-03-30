package assignment5_exercises.triangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TriTypExercise4CaccTest {

    @Test
    public void expectedOutputsForTheCaccSuite() {
        assertEquals(4, TriTyp.triang(-1, 1, 1));
        assertEquals(4, TriTyp.triang(1, -1, 1));
        assertEquals(4, TriTyp.triang(1, 1, -1));
        assertEquals(3, TriTyp.triang(1, 1, 1));

        assertEquals(4, TriTyp.triang(1, 2, 3));
        assertEquals(1, TriTyp.triang(2, 3, 4));
        assertEquals(4, TriTyp.triang(3, 1, 2));
        assertEquals(4, TriTyp.triang(1, 3, 2));

        assertEquals(4, TriTyp.triang(1, 2, 1));
        assertEquals(2, TriTyp.triang(2, 2, 1));
        assertEquals(4, TriTyp.triang(1, 1, 2));
        assertEquals(2, TriTyp.triang(2, 1, 2));
        assertEquals(2, TriTyp.triang(1, 2, 2));
        assertEquals(4, TriTyp.triang(2, 1, 1));
    }

    @Test
    public void caccForP1() {
        TriTypTraceSupport.Trace c1True = TriTypTraceSupport.run(-1, 1, 1);
        TriTypTraceSupport.Trace c2True = TriTypTraceSupport.run(1, -1, 1);
        TriTypTraceSupport.Trace c3True = TriTypTraceSupport.run(1, 1, -1);
        TriTypTraceSupport.Trace allFalse = TriTypTraceSupport.run(1, 1, 1);

        assertCaccPair("P1", "c1", c1True, allFalse);
        assertCaccPair("P1", "c2", c2True, allFalse);
        assertCaccPair("P1", "c3", c3True, allFalse);
    }

    @Test
    public void caccForP6() {
        TriTypTraceSupport.Trace d1True = TriTypTraceSupport.run(1, 2, 3);
        TriTypTraceSupport.Trace allFalse = TriTypTraceSupport.run(2, 3, 4);
        TriTypTraceSupport.Trace d2True = TriTypTraceSupport.run(3, 1, 2);
        TriTypTraceSupport.Trace d3True = TriTypTraceSupport.run(1, 3, 2);

        assertCaccPair("P6", "d1", d1True, allFalse);
        assertCaccPair("P6", "d2", d2True, allFalse);
        assertCaccPair("P6", "d3", d3True, allFalse);
    }

    @Test
    public void caccForP8() {
        TriTypTraceSupport.Trace e1FalseE2True = TriTypTraceSupport.run(1, 2, 1);
        TriTypTraceSupport.Trace e1TrueE2True = TriTypTraceSupport.run(2, 2, 1);
        TriTypTraceSupport.Trace e1TrueE2False = TriTypTraceSupport.run(1, 1, 2);

        assertCaccPair("P8", "e1", e1FalseE2True, e1TrueE2True);
        assertCaccPair("P8", "e2", e1TrueE2True, e1TrueE2False);
    }

    @Test
    public void caccForP9() {
        TriTypTraceSupport.Trace f1FalseF2True = TriTypTraceSupport.run(1, 1, 2);
        TriTypTraceSupport.Trace f1TrueF2True = TriTypTraceSupport.run(2, 1, 2);
        TriTypTraceSupport.Trace f1TrueF2False = TriTypTraceSupport.run(1, 2, 1);

        assertCaccPair("P9", "f1", f1FalseF2True, f1TrueF2True);
        assertCaccPair("P9", "f2", f1TrueF2False, f1TrueF2True);
    }

    @Test
    public void caccForP10() {
        TriTypTraceSupport.Trace g1FalseG2True = TriTypTraceSupport.run(1, 1, 2);
        TriTypTraceSupport.Trace g1TrueG2True = TriTypTraceSupport.run(1, 2, 2);
        TriTypTraceSupport.Trace g1TrueG2False = TriTypTraceSupport.run(2, 1, 1);

        assertCaccPair("P10", "g1", g1FalseG2True, g1TrueG2True);
        assertCaccPair("P10", "g2", g1TrueG2False, g1TrueG2True);
    }

    @Test
    public void singleClausePredicatesTakeTrueAndFalse() {
        List<TriTypTraceSupport.Trace> suite = Arrays.asList(
            TriTypTraceSupport.run(2, 2, 1),
            TriTypTraceSupport.run(1, 2, 1),
            TriTypTraceSupport.run(1, 1, 1),
            TriTypTraceSupport.run(2, 3, 4)
        );

        assertPredicateHasBothTruthValues("P2", suite);
        assertPredicateHasBothTruthValues("P3", suite);
        assertPredicateHasBothTruthValues("P4", suite);
        assertPredicateHasBothTruthValues("P5", suite);
        assertPredicateHasBothTruthValues("P7", suite);
    }

    private static void assertCaccPair(
        String predicateId,
        String majorClause,
        TriTypTraceSupport.Trace tA,
        TriTypTraceSupport.Trace tB
    ) {
        TriTypTraceSupport.PredicateEval eA = tA.predicates.get(predicateId);
        TriTypTraceSupport.PredicateEval eB = tB.predicates.get(predicateId);
        assertNotNull("Predicate not reached in first test: " + predicateId, eA);
        assertNotNull("Predicate not reached in second test: " + predicateId, eB);

        Boolean majorA = eA.clauses.get(majorClause);
        Boolean majorB = eB.clauses.get(majorClause);
        assertNotNull("Major clause not found: " + majorClause, majorA);
        assertNotNull("Major clause not found: " + majorClause, majorB);
        assertNotEquals("Major clause must change", majorA, majorB);

        for (Map.Entry<String, Boolean> entry : eA.clauses.entrySet()) {
            String clauseName = entry.getKey();
            if (!clauseName.equals(majorClause)) {
                assertEquals(
                    "Minor clause must remain fixed: " + clauseName,
                    entry.getValue(),
                    eB.clauses.get(clauseName)
                );
            }
        }

        assertNotEquals(
            "Predicate must change for CACC",
            eA.predicate,
            eB.predicate
        );
    }

    private static void assertPredicateHasBothTruthValues(String predicateId, List<TriTypTraceSupport.Trace> suite) {
        boolean seenTrue = false;
        boolean seenFalse = false;
        for (TriTypTraceSupport.Trace trace : suite) {
            TriTypTraceSupport.PredicateEval eval = trace.predicates.get(predicateId);
            if (eval != null) {
                if (eval.predicate) {
                    seenTrue = true;
                } else {
                    seenFalse = true;
                }
            }
        }
        assertFalse("Predicate never reached with true and false: " + predicateId, !(seenTrue && seenFalse));
    }
}
