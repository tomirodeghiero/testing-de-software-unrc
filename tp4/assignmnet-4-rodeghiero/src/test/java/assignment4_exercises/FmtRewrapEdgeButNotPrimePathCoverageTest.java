package assignment4_exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FmtRewrapEdgeButNotPrimePathCoverageTest {

    @Test
    public void whileCanExitWithoutEnteringBody() {
        assertEquals("\n", FmtRewrap.fmtRewrap("", 10));
    }

    @Test
    public void coversBetweenWordAndLineBreakCase() {
        String out = FmtRewrap.fmtRewrap(" a", 3);
        assertTrue(out.endsWith("\n"));
    }

    @Test
    public void coversCrFoundHardReturnBranch() {
        String out = FmtRewrap.fmtRewrap("x\n\ny", 100);
        assertTrue(out.endsWith("\n"));
    }

    @Test
    public void coversCrFoundSoftReturnSecondOperandFalse() {
        assertEquals("x y\n", FmtRewrap.fmtRewrap("x\ny", 100));
    }

    @Test
    public void coversCrFoundSoftReturnFirstOperandFalse() {
        assertEquals("x \n", FmtRewrap.fmtRewrap("x\n", 100));
    }
}
