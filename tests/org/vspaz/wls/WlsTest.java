package org.vspaz.wls;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WlsTest {

  final double delta = 1.0e-6;

  @Test
  void testWLSModelStableWeight() {
    final double[] x = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
    final double[] y = {1.0, 3.0, 4.0, 5.0, 2.0, 3.0, 4.0};

    Wls wls = new Wls(x, y);
    Point point = wls.fitLinearRegression();

    assertEquals(2.14285714, point.getIntercept(), delta);
    assertEquals(0.25, point.getSlope(), delta);
  }

  @Test
  void testWLSModelWeight() {
    final double[] x = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
    final double[] y = {1.0, 3.0, 4.0, 5.0, 2.0, 3.0, 4.0};

    Wls wls = new Wls(x, y, 0.9);
    Point point = wls.fitLinearRegression();

    assertEquals(2.14285714, point.getIntercept(), delta);
    assertEquals(0.25, point.getSlope(), delta);
  }

  @Test
  void testHorizontalLineOk() {
    final double[] x = {0.0, 1.0};
    final double[] y = {10.0, 10.0};

    Wls wls = new Wls(x, y);
    Point point = wls.fitLinearRegression();
    assertEquals(10.0, point.getIntercept());
    assertEquals(0.0, point.getSlope());
  }

  @Test()
  void testSinglePointDisallowed() {
    final double[] x = {10.0};
    final double[] y = {1.0};
    assertThrows(
        AssertionError.class,
        () -> new Wls(x, y));
  }
}
