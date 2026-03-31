package assignment8_exercises.ncl;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

  public static boolean debug = false;

  @Test
  public void test001() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test001"); }

    int i0 = assignment8_exercises.ncl.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE;
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i0 == 20);

  }

  @Test
  public void test002() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test002"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i3 = nodeCachingLinkedList0.get((int)(short)100);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test003() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test003"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i3 = nodeCachingLinkedList0.get((int)(byte)100);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test004() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test004"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i7 = nodeCachingLinkedList0.get((int)'4');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);

  }

  @Test
  public void test005() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test005"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test006() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test006"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);

  }

  @Test
  public void test007() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test007"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i2 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test008() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test008"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i4 = nodeCachingLinkedList0.get(100);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);

  }

  @Test
  public void test009() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test009"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i4 = nodeCachingLinkedList0.get((int)(byte)100);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);

  }

  @Test
  public void test010() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test010"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));

  }

  @Test
  public void test011() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test011"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(0);
    int i8 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i8 == 0);

  }

  @Test
  public void test012() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test012"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str4 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[]"+ "'", str4.equals("[]"));

  }

  @Test
  public void test013() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test013"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    int i5 = nodeCachingLinkedList0.getSize();
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    int i7 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[]"+ "'", str6.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);

  }

  @Test
  public void test014() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test014"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get((int)(byte)100);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);

  }

  @Test
  public void test015() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test015"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test016() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test016"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(100);
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));

  }

  @Test
  public void test017() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test017"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    int i6 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[10]"+ "'", str7.equals("[10]"));

  }

  @Test
  public void test018() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test018"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i9 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i9);

  }

  @Test
  public void test019() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test019"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)(-1));
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i9 = nodeCachingLinkedList0.get((int)(byte)10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test020() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test020"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));

  }

  @Test
  public void test021() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test021"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test022() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test022"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i2 = nodeCachingLinkedList0.get((int)(short)-1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test023() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test023"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((-1));
    int i5 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);

  }

  @Test
  public void test024() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test024"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    int i5 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i7 = nodeCachingLinkedList0.get(10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test025() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test025"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)(-1));
    int i8 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i8 == 0);

  }

  @Test
  public void test026() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test026"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.String str4 = nodeCachingLinkedList0.toString();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[]"+ "'", str4.equals("[]"));

  }

  @Test
  public void test027() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test027"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test028() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test028"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[0]"+ "'", str5.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i8 + "' != '" + 0+ "'", i8.equals(0));

  }

  @Test
  public void test029() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test029"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i4 = nodeCachingLinkedList0.get((int)'a');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);

  }

  @Test
  public void test030() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test030"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));

  }

  @Test
  public void test031() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test031"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(20);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test032() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test032"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    int i5 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test033() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test033"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));

  }

  @Test
  public void test034() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test034"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex(100);
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));

  }

  @Test
  public void test035() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test035"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i3 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test036() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test036"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i4 = nodeCachingLinkedList0.get((int)(short)10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);

  }

  @Test
  public void test037() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test037"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test038() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test038"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i5 + "' != '" + 0+ "'", i5.equals(0));

  }

  @Test
  public void test039() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test039"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str4 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[]"+ "'", str4.equals("[]"));

  }

  @Test
  public void test040() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test040"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    int i5 = nodeCachingLinkedList0.getSize();
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[]"+ "'", str6.equals("[]"));

  }

  @Test
  public void test041() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test041"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex((-1));
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));

  }

  @Test
  public void test042() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test042"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)(short)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);

  }

  @Test
  public void test043() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test043"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 1);

  }

  @Test
  public void test044() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test044"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    int i6 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i5 + "' != '" + 0+ "'", i5.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test045() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test045"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i5 + "' != '" + 0+ "'", i5.equals(0));

  }

  @Test
  public void test046() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test046"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    int i5 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test047() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test047"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    int i5 = nodeCachingLinkedList0.getSize();
    int i6 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test048() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test048"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get((-1));
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);

  }

  @Test
  public void test049() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test049"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test050() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test050"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[]"+ "'", str7.equals("[]"));

  }

  @Test
  public void test051() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test051"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i6 + "' != '" + 20+ "'", i6.equals(20));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);

  }

  @Test
  public void test052() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test052"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    int i6 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex((int)(byte)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);

  }

  @Test
  public void test053() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test053"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    int i6 = nodeCachingLinkedList0.getSize();
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[]"+ "'", str7.equals("[]"));

  }

  @Test
  public void test054() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test054"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    int i6 = nodeCachingLinkedList0.getSize();
    int i7 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);

  }

  @Test
  public void test055() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test055"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(100);
    int i4 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test056() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test056"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test057() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test057"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);

  }

  @Test
  public void test058() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test058"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex((int)' ');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test059() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test059"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i7 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test060() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test060"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((-1));
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((int)(byte)1);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i8 = nodeCachingLinkedList0.get((int)'a');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test061() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test061"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test062() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test062"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((int)'4');
    int i7 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);

  }

  @Test
  public void test063() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test063"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i4 = nodeCachingLinkedList0.get((int)' ');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));

  }

  @Test
  public void test064() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test064"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);

  }

  @Test
  public void test065() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test065"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex((int)(byte)100);
    java.lang.Integer i9 = nodeCachingLinkedList0.removeIndex(1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i9);

  }

  @Test
  public void test066() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test066"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));

  }

  @Test
  public void test067() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test067"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get((int)(byte)100);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test068() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test068"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((-1));
    int i5 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);

  }

  @Test
  public void test069() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test069"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    java.lang.Integer i9 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[]"+ "'", str7.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i9);

  }

  @Test
  public void test070() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test070"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i7 = nodeCachingLinkedList0.get((int)(short)10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test071() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test071"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));

  }

  @Test
  public void test072() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test072"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i5 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i7 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i7 + "' != '" + 0+ "'", i7.equals(0));

  }

  @Test
  public void test073() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test073"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex(0);
    int i5 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i4 + "' != '" + 100+ "'", i4.equals(100));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test074() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test074"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    int i8 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[]"+ "'", str7.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i8 == 0);

  }

  @Test
  public void test075() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test075"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));

  }

  @Test
  public void test076() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test076"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i4 + "' != '" + 0+ "'", i4.equals(0));

  }

  @Test
  public void test077() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test077"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test078() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test078"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    int i7 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[0]"+ "'", str5.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[0]"+ "'", str6.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 1);

  }

  @Test
  public void test079() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test079"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i5 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex((int)(short)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);

  }

  @Test
  public void test080() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test080"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test081() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test081"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    int i5 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);

  }

  @Test
  public void test082() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test082"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i11 = nodeCachingLinkedList0.get((int)'#');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i7 + "' != '" + 0+ "'", i7.equals(0));

  }

  @Test
  public void test083() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test083"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    int i5 = nodeCachingLinkedList0.getSize();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test084() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test084"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    java.lang.Integer i4 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i4 + "' != '" + 100+ "'", i4.equals(100));

  }

  @Test
  public void test085() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test085"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(10);
    int i6 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 1);

  }

  @Test
  public void test086() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test086"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test087() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test087"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(100);
    int i4 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get((int)(short)0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test088() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test088"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    int i2 = nodeCachingLinkedList0.getSize();
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    int i4 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test089() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test089"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    java.lang.Integer i7 = nodeCachingLinkedList0.get((int)(byte)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[0]"+ "'", str5.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i7 + "' != '" + 0+ "'", i7.equals(0));

  }

  @Test
  public void test090() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test090"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    int i6 = nodeCachingLinkedList0.getSize();
    int i7 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i9 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i9);

  }

  @Test
  public void test091() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test091"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test092() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test092"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    int i3 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test093() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test093"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get((int)' ');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test094() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test094"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));

  }

  @Test
  public void test095() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test095"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    int i7 = nodeCachingLinkedList0.getSize();
    java.lang.String str8 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "[100,0]"+ "'", str8.equals("[100,0]"));

  }

  @Test
  public void test096() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test096"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    int i3 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test097() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test097"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    int i5 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test098() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test098"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(100);
    int i4 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[20]"+ "'", str7.equals("[20]"));

  }

  @Test
  public void test099() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test099"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get((int)' ');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));

  }

  @Test
  public void test100() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test100"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i4 = nodeCachingLinkedList0.get(20);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }

  }

  @Test
  public void test101() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test101"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    int i2 = nodeCachingLinkedList0.getSize();
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));

  }

  @Test
  public void test102() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test102"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    int i6 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test103() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test103"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[0]"+ "'", str5.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i8 + "' != '" + 0+ "'", i8.equals(0));

  }

  @Test
  public void test104() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test104"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(100);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test105() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test105"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i11 = nodeCachingLinkedList0.get(2);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i7 + "' != '" + 0+ "'", i7.equals(0));

  }

  @Test
  public void test106() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test106"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    int i5 = nodeCachingLinkedList0.getSize();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex(1);
    int i9 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);

  }

  @Test
  public void test107() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test107"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i8 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test108() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test108"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i8 = nodeCachingLinkedList0.get((-1));
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i6 + "' != '" + 20+ "'", i6.equals(20));

  }

  @Test
  public void test109() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test109"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex((int)'#');
    java.lang.Integer i9 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i9 + "' != '" + 10+ "'", i9.equals(10));

  }

  @Test
  public void test110() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test110"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i5 = nodeCachingLinkedList0.get((int)(byte)1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test111() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test111"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((int)(short)-1);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test112() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test112"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.get(0);
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i9 = nodeCachingLinkedList0.get((int)'a');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i6 + "' != '" + 0+ "'", i6.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[0]"+ "'", str7.equals("[0]"));

  }

  @Test
  public void test113() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test113"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test114() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test114"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)(byte)100);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);

  }

  @Test
  public void test115() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test115"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex((int)(byte)-1);
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[]"+ "'", str6.equals("[]"));

  }

  @Test
  public void test116() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test116"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test117() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test117"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i5 + "' != '" + 0+ "'", i5.equals(0));

  }

  @Test
  public void test118() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test118"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)1);

  }

  @Test
  public void test119() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test119"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(100);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test120() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test120"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    java.lang.Integer i8 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[0]"+ "'", str6.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i8 + "' != '" + 0+ "'", i8.equals(0));

  }

  @Test
  public void test121() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test121"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    int i7 = nodeCachingLinkedList0.getSize();
    int i8 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i10 = nodeCachingLinkedList0.removeIndex((int)(short)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i8 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i10);

  }

  @Test
  public void test122() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test122"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[0]"+ "'", str5.equals("[0]"));

  }

  @Test
  public void test123() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test123"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i4 = nodeCachingLinkedList0.get(0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get((int)'#');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i4 + "' != '" + 0+ "'", i4.equals(0));

  }

  @Test
  public void test124() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test124"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));

  }

  @Test
  public void test125() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test125"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex((int)'#');
    int i6 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test126() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test126"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[0]"+ "'", str5.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test127() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test127"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((int)'4');
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i8 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test128() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test128"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex((-1));
    int i4 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[0]"+ "'", str7.equals("[0]"));

  }

  @Test
  public void test129() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test129"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    int i5 = nodeCachingLinkedList0.getSize();
    int i6 = nodeCachingLinkedList0.getSize();
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[0]"+ "'", str7.equals("[0]"));

  }

  @Test
  public void test130() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test130"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i4 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);

  }

  @Test
  public void test131() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test131"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)(-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);

  }

  @Test
  public void test132() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test132"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)(short)0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);

  }

  @Test
  public void test133() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test133"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);

  }

  @Test
  public void test134() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test134"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.String str4 = nodeCachingLinkedList0.toString();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    int i6 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[0]"+ "'", str4.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[0]"+ "'", str5.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i8 + "' != '" + 0+ "'", i8.equals(0));

  }

  @Test
  public void test135() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test135"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(20);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i8 = nodeCachingLinkedList0.get(100);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test136() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test136"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)(byte)-1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);

  }

  @Test
  public void test137() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test137"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    int i6 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex(0);
    int i9 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i11 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i11);

  }

  @Test
  public void test138() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test138"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i3 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);

  }

  @Test
  public void test139() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test139"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test140() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test140"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    int i5 = nodeCachingLinkedList0.getSize();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex(1);
    int i9 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i9 == 0);

  }

  @Test
  public void test141() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test141"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);

  }

  @Test
  public void test142() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test142"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[0]"+ "'", str6.equals("[0]"));

  }

  @Test
  public void test143() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test143"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    int i2 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i4 = nodeCachingLinkedList0.get((int)(byte)10);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);

  }

  @Test
  public void test144() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test144"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.String str8 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i7 + "' != '" + 10+ "'", i7.equals(10));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "[]"+ "'", str8.equals("[]"));

  }

  @Test
  public void test145() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test145"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    int i5 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i7 = nodeCachingLinkedList0.get(1);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);

  }

  @Test
  public void test146() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test146"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(100);
    int i4 = nodeCachingLinkedList0.getSize();
    int i5 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test147() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test147"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test148() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test148"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i9 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[0]"+ "'", str5.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i9 + "' != '" + 0+ "'", i9.equals(0));

  }

  @Test
  public void test149() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test149"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i5 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[0]"+ "'", str6.equals("[0]"));

  }

  @Test
  public void test150() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test150"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    int i6 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test151() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test151"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    int i7 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i9 = nodeCachingLinkedList0.removeIndex(10);
    int i10 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)(-1));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i10 == 0);

  }

  @Test
  public void test152() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test152"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i5 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex(10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);

  }

  @Test
  public void test153() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test153"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i5 = nodeCachingLinkedList0.getSize();
    int i6 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 1);

  }

  @Test
  public void test154() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test154"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((-1));
    int i5 = nodeCachingLinkedList0.getCacheSize();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[100]"+ "'", str7.equals("[100]"));

  }

  @Test
  public void test155() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test155"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    java.lang.Integer i7 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[20]"+ "'", str5.equals("[20]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i7 + "' != '" + 20+ "'", i7.equals(20));

  }

  @Test
  public void test156() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test156"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex((int)'a');
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i10 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[]"+ "'", str6.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);

  }

  @Test
  public void test157() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test157"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    int i5 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test158() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test158"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i5 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);

  }

  @Test
  public void test159() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test159"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)(short)0);
    int i5 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test160() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test160"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i5 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i7 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i7 + "' != '" + 0+ "'", i7.equals(0));

  }

  @Test
  public void test161() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test161"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i7 = nodeCachingLinkedList0.removeIndex((int)'4');
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i7);

  }

  @Test
  public void test162() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test162"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    java.lang.Integer i6 = nodeCachingLinkedList0.get(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i6 + "' != '" + 10+ "'", i6.equals(10));

  }

  @Test
  public void test163() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test163"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(100);
    java.lang.String str4 = nodeCachingLinkedList0.toString();
    int i5 = nodeCachingLinkedList0.getSize();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[]"+ "'", str4.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test164() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test164"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    int i6 = nodeCachingLinkedList0.getSize();
    int i7 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i9 = nodeCachingLinkedList0.get((int)'4');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);

  }

  @Test
  public void test165() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test165"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    int i2 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)(-1));
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i8 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i6 + "' != '" + (-1)+ "'", i6.equals((-1)));

  }

  @Test
  public void test166() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test166"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));

  }

  @Test
  public void test167() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test167"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.get((int)(short)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i6 + "' != '" + 0+ "'", i6.equals(0));

  }

  @Test
  public void test168() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test168"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getSize();
    int i5 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test169() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test169"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    int i6 = nodeCachingLinkedList0.getSize();
    int i7 = nodeCachingLinkedList0.getSize();
    int i8 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i8 == 0);

  }

  @Test
  public void test170() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test170"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    int i2 = nodeCachingLinkedList0.getCacheSize();
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test171() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test171"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i8 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i10 = nodeCachingLinkedList0.get(0);
    java.lang.String str11 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i8 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i10 + "' != '" + 0+ "'", i10.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str11 + "' != '" + "[0,0]"+ "'", str11.equals("[0,0]"));

  }

  @Test
  public void test172() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test172"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.String str5 = nodeCachingLinkedList0.toString();
    int i6 = nodeCachingLinkedList0.getSize();
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    java.lang.Integer i9 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)(-1));
    int i12 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "[]"+ "'", str5.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[]"+ "'", str7.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i12 == 1);

  }

  @Test
  public void test173() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test173"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    int i6 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test174() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test174"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)20);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 1);

  }

  @Test
  public void test175() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test175"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((int)'4');
    nodeCachingLinkedList0.addFirst((java.lang.Integer)2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test176() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test176"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    int i4 = nodeCachingLinkedList0.getSize();
    int i5 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);

  }

  @Test
  public void test177() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test177"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test178() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test178"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    int i2 = nodeCachingLinkedList0.getSize();
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(10);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i7 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test179() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test179"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getCacheSize();
    int i5 = nodeCachingLinkedList0.getSize();
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[0]"+ "'", str6.equals("[0]"));

  }

  @Test
  public void test180() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test180"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    int i5 = nodeCachingLinkedList0.getCacheSize();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);

  }

  @Test
  public void test181() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test181"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex((-1));
    int i4 = nodeCachingLinkedList0.getSize();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i6 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test182() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test182"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)10);
    int i6 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str9 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str9 + "' != '" + "[10]"+ "'", str9.equals("[10]"));

  }

  @Test
  public void test183() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test183"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));

  }

  @Test
  public void test184() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test184"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    int i2 = nodeCachingLinkedList0.getSize();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i2 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test185() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test185"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i3 = nodeCachingLinkedList0.get(0);
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));

  }

  @Test
  public void test186() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test186"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i7 = nodeCachingLinkedList0.get((int)' ');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test187() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test187"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(20);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);

  }

  @Test
  public void test188() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test188"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getCacheSize();
    java.lang.String str2 = nodeCachingLinkedList0.toString();
    int i3 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "[]"+ "'", str2.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

  @Test
  public void test189() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test189"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.String str1 = nodeCachingLinkedList0.toString();
    java.lang.Integer i3 = nodeCachingLinkedList0.removeIndex((-1));
    int i4 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "[]"+ "'", str1.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test190() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test190"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(byte)10);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)100);
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[]"+ "'", str3.equals("[]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[100]"+ "'", str6.equals("[100]"));

  }

  @Test
  public void test191() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test191"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)1);
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    int i7 = nodeCachingLinkedList0.getCacheSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[1,0]"+ "'", str6.equals("[1,0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 0);

  }

  @Test
  public void test192() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test192"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getCacheSize();
    int i4 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex(0);
    // The following exception was thrown during execution in test generation
    try {
    java.lang.Integer i10 = nodeCachingLinkedList0.get((int)'a');
      org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException");
    } catch (java.lang.IllegalArgumentException e) {
      // Expected exception.
    }
    
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);

  }

  @Test
  public void test193() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test193"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.Integer i4 = nodeCachingLinkedList0.removeIndex((int)' ');
    int i5 = nodeCachingLinkedList0.getSize();
    int i6 = nodeCachingLinkedList0.getCacheSize();
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex(1);
    java.lang.Integer i10 = nodeCachingLinkedList0.removeIndex(0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i6 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i10);

  }

  @Test
  public void test194() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test194"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.String str4 = nodeCachingLinkedList0.toString();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((int)(short)-1);
    int i7 = nodeCachingLinkedList0.getSize();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[0]"+ "'", str4.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i7 == 1);

  }

  @Test
  public void test195() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test195"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i5 = nodeCachingLinkedList0.getSize();
    java.lang.String str6 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i5 == 1);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "[0]"+ "'", str6.equals("[0]"));

  }

  @Test
  public void test196() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test196"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.String str4 = nodeCachingLinkedList0.toString();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(100);
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[0]"+ "'", str4.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[0]"+ "'", str7.equals("[0]"));

  }

  @Test
  public void test197() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test197"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    int i1 = nodeCachingLinkedList0.getSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    int i4 = nodeCachingLinkedList0.getCacheSize();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i1 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i4 == 0);

  }

  @Test
  public void test198() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test198"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex((int)(short)100);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex((int)(short)-1);
    java.lang.Integer i8 = nodeCachingLinkedList0.removeIndex((int)(short)-1);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i8);

  }

  @Test
  public void test199() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test199"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    java.lang.String str3 = nodeCachingLinkedList0.toString();
    java.lang.String str4 = nodeCachingLinkedList0.toString();
    java.lang.Integer i6 = nodeCachingLinkedList0.removeIndex(0);
    java.lang.String str7 = nodeCachingLinkedList0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "[0]"+ "'", str3.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "[0]"+ "'", str4.equals("[0]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + i6 + "' != '" + 0+ "'", i6.equals(0));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "[]"+ "'", str7.equals("[]"));

  }

  @Test
  public void test200() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest0.test200"); }

    assignment8_exercises.ncl.NodeCachingLinkedList nodeCachingLinkedList0 = new assignment8_exercises.ncl.NodeCachingLinkedList();
    java.lang.Integer i2 = nodeCachingLinkedList0.removeIndex(0);
    int i3 = nodeCachingLinkedList0.getSize();
    java.lang.Integer i5 = nodeCachingLinkedList0.removeIndex((int)(byte)-1);
    nodeCachingLinkedList0.addFirst((java.lang.Integer)0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i2);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(i3 == 0);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertNull(i5);

  }

}
