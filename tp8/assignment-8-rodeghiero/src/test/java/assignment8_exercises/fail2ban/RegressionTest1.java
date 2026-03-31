package assignment8_exercises.fail2ban;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest1 {

  public static boolean debug = false;

  @Test
  public void test01() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test01"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.addBan(iP2);
    assignment8_exercises.fail2ban.ITime iTime4 = null;
    server0.setTime(iTime4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.removeBan(iP6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test02() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test02"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeBan(iP3);
    server0.update();
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.addBan(iP6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test03() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test03"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeBan(iP3);
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.removeBan(iP5);
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.removeException(iP7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);

  }

  @Test
  public void test04() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test04"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addException(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addException(iP3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);

  }

  @Test
  public void test05() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test05"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.removeBan(iP2);
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeBan(iP4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);

  }

  @Test
  public void test06() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test06"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addBan(iP3);
    java.lang.String str5 = server0.toString();
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.removeException(iP6);
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.connect(iP8);
    assignment8_exercises.fail2ban.IP iP10 = null;
    boolean b11 = server0.addBan(iP10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str5.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == false);

  }

  @Test
  public void test07() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test07"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    java.lang.String str3 = server0.toString();
    server0.update();
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.removeBan(iP5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);

  }

  @Test
  public void test08() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test08"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addException(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeException(iP3);
    java.lang.String str5 = server0.toString();
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.addException(iP6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str5.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test09() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test09"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addBan(iP3);
    java.lang.String str5 = server0.toString();
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.addException(iP6);
    server0.update();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str5.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test10() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test10"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.ITime iTime4 = null;
    server0.setTime(iTime4);
    java.lang.String str6 = server0.toString();
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.addBan(iP7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str6.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);

  }

  @Test
  public void test11() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test11"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addException(iP1);
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.connect(iP4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.addBan(iP6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test12() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test12"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    server0.update();
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.addBan(iP4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.connect(iP6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test13() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test13"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    server0.update();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.connect(iP2);
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.addBan(iP4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);

  }

  @Test
  public void test14() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test14"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    server0.update();
    server0.update();
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.connect(iP3);
    server0.update();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);

  }

  @Test
  public void test15() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test15"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeBan(iP3);
    assignment8_exercises.fail2ban.ITime iTime5 = null;
    server0.setTime(iTime5);
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.connect(iP7);
    assignment8_exercises.fail2ban.ITime iTime9 = null;
    server0.setTime(iTime9);
    assignment8_exercises.fail2ban.IP iP11 = null;
    boolean b12 = server0.removeBan(iP11);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b12 == false);

  }

  @Test
  public void test16() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test16"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    server0.update();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.connect(iP2);
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeException(iP4);
    java.lang.String str6 = server0.toString();
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.connect(iP7);
    assignment8_exercises.fail2ban.IP iP9 = null;
    boolean b10 = server0.connect(iP9);
    server0.update();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Server [lastUpdate=1774962298464, exceptions=(), bans={}]"+ "'", str6.equals("Server [lastUpdate=1774962298464, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);

  }

  @Test
  public void test17() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test17"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    java.lang.String str2 = server0.toString();
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addBan(iP3);
    server0.update();
    java.lang.String str6 = server0.toString();
    assignment8_exercises.fail2ban.ITime iTime7 = null;
    server0.setTime(iTime7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str2.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Server [lastUpdate=1774962298467, exceptions=(), bans={}]"+ "'", str6.equals("Server [lastUpdate=1774962298467, exceptions=(), bans={}]"));

  }

  @Test
  public void test18() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test18"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addBan(iP3);
    java.lang.String str5 = server0.toString();
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.addException(iP6);
    java.lang.String str8 = server0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str5.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str8.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));

  }

  @Test
  public void test19() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test19"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addException(iP1);
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeException(iP4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.addBan(iP6);
    server0.update();
    assignment8_exercises.fail2ban.IP iP9 = null;
    boolean b10 = server0.connect(iP9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);

  }

  @Test
  public void test20() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test20"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addBan(iP1);
    assignment8_exercises.fail2ban.ITime iTime3 = null;
    server0.setTime(iTime3);
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.connect(iP5);
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.connect(iP7);
    assignment8_exercises.fail2ban.ITime iTime9 = null;
    server0.setTime(iTime9);
    java.lang.String str11 = server0.toString();
    assignment8_exercises.fail2ban.IP iP12 = null;
    boolean b13 = server0.removeException(iP12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str11.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b13 == false);

  }

  @Test
  public void test21() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test21"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    server0.update();
    server0.update();
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeException(iP4);
    assignment8_exercises.fail2ban.ITime iTime6 = null;
    server0.setTime(iTime6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=1774962298474, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=1774962298474, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);

  }

  @Test
  public void test22() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test22"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.ITime iTime4 = null;
    server0.setTime(iTime4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.addException(iP6);
    assignment8_exercises.fail2ban.ITime iTime8 = null;
    server0.setTime(iTime8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test23() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test23"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addBan(iP3);
    java.lang.String str5 = server0.toString();
    server0.update();
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.addException(iP7);
    server0.update();
    assignment8_exercises.fail2ban.IP iP10 = null;
    boolean b11 = server0.removeBan(iP10);
    assignment8_exercises.fail2ban.IP iP12 = null;
    boolean b13 = server0.addBan(iP12);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str5.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b13 == false);

  }

  @Test
  public void test24() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test24"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addException(iP3);
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.connect(iP5);
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.removeBan(iP7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);

  }

  @Test
  public void test25() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test25"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.removeBan(iP2);
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.addBan(iP4);
    assignment8_exercises.fail2ban.ITime iTime6 = null;
    server0.setTime(iTime6);
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.addException(iP8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);

  }

  @Test
  public void test26() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test26"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.addBan(iP2);
    assignment8_exercises.fail2ban.ITime iTime4 = null;
    server0.setTime(iTime4);
    java.lang.String str6 = server0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str6.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));

  }

  @Test
  public void test27() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test27"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeBan(iP3);
    server0.update();
    assignment8_exercises.fail2ban.ITime iTime6 = null;
    server0.setTime(iTime6);
    server0.update();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);

  }

  @Test
  public void test28() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test28"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addException(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.connect(iP3);
    java.lang.String str5 = server0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str5.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));

  }

  @Test
  public void test29() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test29"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addBan(iP1);
    java.lang.String str3 = server0.toString();
    java.lang.String str4 = server0.toString();
    assignment8_exercises.fail2ban.ITime iTime5 = null;
    server0.setTime(iTime5);
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.addException(iP7);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str4 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str4.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);

  }

  @Test
  public void test30() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test30"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addException(iP1);
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeException(iP4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.connect(iP6);
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.connect(iP8);
    assignment8_exercises.fail2ban.IP iP10 = null;
    boolean b11 = server0.addException(iP10);
    assignment8_exercises.fail2ban.IP iP12 = null;
    boolean b13 = server0.addBan(iP12);
    java.lang.String str14 = server0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b13 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str14 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str14.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));

  }

  @Test
  public void test31() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test31"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeBan(iP3);
    server0.update();
    java.lang.String str6 = server0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Server [lastUpdate=1774962298494, exceptions=(), bans={}]"+ "'", str6.equals("Server [lastUpdate=1774962298494, exceptions=(), bans={}]"));

  }

  @Test
  public void test32() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test32"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addException(iP1);
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeException(iP4);
    assignment8_exercises.fail2ban.ITime iTime6 = null;
    server0.setTime(iTime6);
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.removeException(iP8);
    assignment8_exercises.fail2ban.IP iP10 = null;
    boolean b11 = server0.addException(iP10);
    server0.update();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == false);

  }

  @Test
  public void test33() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test33"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.ITime iTime4 = null;
    server0.setTime(iTime4);
    assignment8_exercises.fail2ban.ITime iTime6 = null;
    server0.setTime(iTime6);
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.removeBan(iP8);
    assignment8_exercises.fail2ban.ITime iTime10 = null;
    server0.setTime(iTime10);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);

  }

  @Test
  public void test34() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test34"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    server0.update();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.removeBan(iP2);
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeBan(iP4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.connect(iP6);
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.connect(iP8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);

  }

  @Test
  public void test35() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test35"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    java.lang.String str3 = server0.toString();
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.addException(iP4);
    java.lang.String str6 = server0.toString();
    server0.update();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str3.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str6.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));

  }

  @Test
  public void test36() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test36"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.removeException(iP2);
    assignment8_exercises.fail2ban.ITime iTime4 = null;
    server0.setTime(iTime4);
    assignment8_exercises.fail2ban.ITime iTime6 = null;
    server0.setTime(iTime6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);

  }

  @Test
  public void test37() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test37"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    server0.update();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.connect(iP2);
    server0.update();
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.removeBan(iP5);
    java.lang.String str7 = server0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Server [lastUpdate=1774962298505, exceptions=(), bans={}]"+ "'", str7.equals("Server [lastUpdate=1774962298505, exceptions=(), bans={}]"));

  }

  @Test
  public void test38() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test38"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.removeException(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addException(iP3);
    java.lang.String str5 = server0.toString();
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.removeException(iP6);
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.removeBan(iP8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str5.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);

  }

  @Test
  public void test39() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test39"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addException(iP3);
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.removeException(iP5);
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.connect(iP7);
    assignment8_exercises.fail2ban.IP iP9 = null;
    boolean b10 = server0.removeException(iP9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);

  }

  @Test
  public void test40() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test40"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    server0.update();
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeException(iP3);
    assignment8_exercises.fail2ban.ITime iTime5 = null;
    server0.setTime(iTime5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);

  }

  @Test
  public void test41() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test41"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    server0.update();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.connect(iP2);
    server0.update();
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.removeException(iP5);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);

  }

  @Test
  public void test42() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test42"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.removeException(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeException(iP3);
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.connect(iP5);
    assignment8_exercises.fail2ban.IP iP7 = null;
    boolean b8 = server0.addBan(iP7);
    assignment8_exercises.fail2ban.IP iP9 = null;
    boolean b10 = server0.connect(iP9);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b8 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b10 == false);

  }

  @Test
  public void test43() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test43"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addBan(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addBan(iP3);
    assignment8_exercises.fail2ban.IP iP5 = null;
    boolean b6 = server0.addBan(iP5);
    java.lang.String str7 = server0.toString();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b6 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str7.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));

  }

  @Test
  public void test44() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test44"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.addBan(iP3);
    java.lang.String str5 = server0.toString();
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.removeException(iP6);
    assignment8_exercises.fail2ban.ITime iTime8 = null;
    server0.setTime(iTime8);
    assignment8_exercises.fail2ban.IP iP10 = null;
    boolean b11 = server0.connect(iP10);
    server0.update();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str5.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b11 == false);

  }

  @Test
  public void test45() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test45"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    assignment8_exercises.fail2ban.IP iP2 = null;
    boolean b3 = server0.addBan(iP2);
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeBan(iP4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.addBan(iP6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b3 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test46() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test46"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    java.lang.String str1 = server0.toString();
    java.lang.String str2 = server0.toString();
    assignment8_exercises.fail2ban.ITime iTime3 = null;
    server0.setTime(iTime3);
    assignment8_exercises.fail2ban.ITime iTime5 = null;
    server0.setTime(iTime5);
    server0.update();
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.addBan(iP8);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str1.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Server [lastUpdate=null, exceptions=(), bans={}]"+ "'", str2.equals("Server [lastUpdate=null, exceptions=(), bans={}]"));
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);

  }

  @Test
  public void test47() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test47"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.removeBan(iP1);
    server0.update();
    assignment8_exercises.fail2ban.ITime iTime4 = null;
    server0.setTime(iTime4);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);

  }

  @Test
  public void test48() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test48"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.ITime iTime1 = null;
    server0.setTime(iTime1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeBan(iP3);
    server0.update();
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.removeBan(iP6);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);

  }

  @Test
  public void test49() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test49"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.addBan(iP1);
    server0.update();
    assignment8_exercises.fail2ban.IP iP4 = null;
    boolean b5 = server0.removeBan(iP4);
    assignment8_exercises.fail2ban.IP iP6 = null;
    boolean b7 = server0.removeBan(iP6);
    assignment8_exercises.fail2ban.IP iP8 = null;
    boolean b9 = server0.connect(iP8);
    server0.update();
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b5 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b7 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b9 == false);

  }

  @Test
  public void test50() throws Throwable {

    if (debug) { System.out.format("%n%s%n","RegressionTest1.test50"); }

    assignment8_exercises.fail2ban.Server server0 = new assignment8_exercises.fail2ban.Server();
    assignment8_exercises.fail2ban.IP iP1 = null;
    boolean b2 = server0.connect(iP1);
    assignment8_exercises.fail2ban.IP iP3 = null;
    boolean b4 = server0.removeBan(iP3);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b2 == false);
    
    // Regression assertion (captures the current behavior of the code)
    org.junit.Assert.assertTrue(b4 == false);

  }

}
