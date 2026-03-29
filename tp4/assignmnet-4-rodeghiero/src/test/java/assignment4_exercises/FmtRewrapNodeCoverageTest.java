package assignment4_exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FmtRewrapNodeCoverageTest {

    @Test
    public void coversBetweenWordAndLineBreakCase() {
        String out = FmtRewrap.fmtRewrap(" a", 3);
        assertNotNull(out);
        assertTrue(out.endsWith("\n"));
    }

    @Test
    public void coversCrFoundCasesAndInWordWithoutTrailingCr() {
        String out = FmtRewrap.fmtRewrap("x\n\ny\nz", 100);
        assertEquals("x\n\ny z\n", out);
    }
}
