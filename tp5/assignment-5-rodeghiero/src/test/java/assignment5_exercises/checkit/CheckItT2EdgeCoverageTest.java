package assignment5_exercises.checkit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class CheckItT2EdgeCoverageTest {

    // T2 para checkItExpand (Edge Coverage):
    // e1 = (F,F,F)
    // e2 = (T,T,F)
    // e3 = (T,F,T)
    // e4 = (T,F,F)
    //
    // Esta suite cubre todas las aristas de checkItExpand,
    // pero NO satisface CACC para checkIt (falta el caso a=F con b||c = T).

    @Test
    public void t2SatisfiesEdgeCoverageOnCheckItExpand() {
        Set<String> covered = new LinkedHashSet<String>();
        covered.addAll(CheckIt.checkItExpand(false, false, false).getEdges());
        covered.addAll(CheckIt.checkItExpand(true, true, false).getEdges());
        covered.addAll(CheckIt.checkItExpand(true, false, true).getEdges());
        covered.addAll(CheckIt.checkItExpand(true, false, false).getEdges());

        Set<String> expected = new LinkedHashSet<String>(Arrays.asList(
            "START->A",
            "A->B",
            "A->FALSE",
            "B->TRUE",
            "B->C",
            "C->TRUE",
            "C->FALSE",
            "TRUE->END",
            "FALSE->END"
        ));

        assertEquals(expected, covered);
    }

    @Test
    public void t2IsNotCaccForOriginalCheckItBecauseMajorAIsMissing() {
        boolean hasATrueWithBorCTrue = false;
        boolean hasAFalseWithBorCTrue = false;

        boolean[][] t2 = new boolean[][]{
            {false, false, false},
            {true, true, false},
            {true, false, true},
            {true, false, false}
        };

        for (boolean[] t : t2) {
            boolean a = t[0];
            boolean b = t[1];
            boolean c = t[2];
            if (a && (b || c)) {
                hasATrueWithBorCTrue = true;
            }
            if (!a && (b || c)) {
                hasAFalseWithBorCTrue = true;
            }
        }

        assertTrue(hasATrueWithBorCTrue);
        assertFalse(hasAFalseWithBorCTrue);
    }
}
