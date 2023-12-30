package org.vspaz.wls;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WlsTest {

  final double delta = 1.0e-6;

  @Test
  void testWlsModelStableWeight() {
    final double[] xPoints = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
    final double[] yPoints = {1.0, 3.0, 4.0, 5.0, 2.0, 3.0, 4.0};

    Wls wls = new Wls(xPoints, yPoints);
    Point point = wls.fitLinearRegression();

    assertEquals(2.14285714, point.getIntercept(), delta);
    assertEquals(0.25, point.getSlope(), delta);
  }

  @Test
  void testWlsModelWeight() {
    final double[] xPoints = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
    final double[] yPoints = {1.0, 3.0, 4.0, 5.0, 2.0, 3.0, 4.0};

    Wls wls = new Wls(xPoints, yPoints, 0.9);
    Point point = wls.fitLinearRegression();

    assertEquals(2.14285714, point.getIntercept(), delta);
    assertEquals(0.25, point.getSlope(), delta);
  }

  @Test
  void testHorizontalLineOk() {
    final double[] xPoints = {0.0, 1.0};
    final double[] yPoints = {10.0, 10.0};

    Wls wls = new Wls(xPoints, yPoints);
    Point point = wls.fitLinearRegression();
    assertEquals(10.0, point.getIntercept());
    assertEquals(0.0, point.getSlope());
  }

  @Test
  void testVerticalLineOk() {
    final double[] xPoints = {1.0, 1.0};
    final double[] yPoints = {10.0, 1.0};

    Wls wls = new Wls(xPoints, yPoints);
    Point point = wls.fitLinearRegression();
    assertNull(point.getIntercept());
    assertNull(point.getSlope());
  }

  @Test
  void testRunUphillOk() {
    final double[] xPoints = {0.0, 1.0};
    final double[] yPoints = {0.0, 1.0};

    Wls wls = new Wls(xPoints, yPoints);
    Point point = wls.fitLinearRegression();
    assertEquals(0.0, point.getIntercept());
    assertEquals(1.0, point.getSlope());
  }

  @Test
  void testDownHillOk() {
    final double[] xPoints = {1.0, 0.0};
    final double[] yPoints = {0.0, 1.0};

    Wls wls = new Wls(xPoints, yPoints);
    Point point = wls.fitLinearRegression();
    assertEquals(1.0, point.getIntercept());
    assertEquals(-1.0, point.getSlope());
  }

  @Test()
  void testSinglePointDisallowed() {
    final double[] xPoints = {10.0};
    final double[] yPoints = {1.0};
    assertThrows(
        AssertionError.class,
        () -> new Wls(xPoints, yPoints));
  }
}
