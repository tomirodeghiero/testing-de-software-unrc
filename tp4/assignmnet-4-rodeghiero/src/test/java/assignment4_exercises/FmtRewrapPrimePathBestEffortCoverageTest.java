package assignment4_exercises;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FmtRewrapPrimePathBestEffortCoverageTest {

    private static void assertRun(String s, int n) {
        String out = FmtRewrap.fmtRewrap(s, n);
        assertTrue(out.endsWith("\n"));
    }

    @Test
    public void ppcCase1() {
        assertRun("aa aa\n\n\na", 5);
    }

    @Test
    public void ppcCase2() {
        assertRun("a\n aa  \na", 6);
    }

    @Test
    public void ppcCase3() {
        assertRun(" a\n\n\n\n a\n", 3);
    }

    @Test
    public void ppcCase4() {
        assertRun(" \n\na ", 4);
    }

    @Test
    public void ppcCase5() {
        assertRun("\n\n", 3);
    }

    @Test
    public void ppcCase6() {
        assertRun(" aaaa", 3);
    }

    @Test
    public void ppcDirectExitPath() {
        assertRun("", 8);
    }
}
