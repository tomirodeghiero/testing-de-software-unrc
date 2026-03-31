package assignment8_exercises.fileContents;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

  public static boolean debug = false;

  @Test
  public void test1() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test1"); }

    InputStream originalStdin = System.in;
    try {
      System.setIn(new ByteArrayInputStream(new byte[0]));
      assignment8_exercises.fileContents.fileExample fileExample_instance0 = new assignment8_exercises.fileContents.fileExample();
      // The following exception was thrown during execution in test generation
      try {
      boolean b1 = fileExample_instance0.checkContent();
        org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException");
      } catch (java.util.NoSuchElementException e) {
        // Expected exception.
      }
    } finally {
      System.setIn(originalStdin);
    }

  }

}
