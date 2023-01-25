package org.vspaz.wls;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WLSTest {

  final double delta = 1.0e-6;

  @Test
  void testWLSModelStableWeight() {
    final double[] x = {1, 2, 3, 4, 5, 6, 7};
    final double[] y = {1, 3, 4, 5, 2, 3, 4};

    WLS wls = new WLS(x, y);
    Point point = wls.fitLinearRegression();

    assertEquals(2.14285714, point.getIntercept(), delta);
    assertEquals(0.25, point.getSlope(), delta);
  }

  @Test
  void testWLSModelWeight() {
    final double[] x = {1, 2, 3, 4, 5, 6, 7};
    final double[] y = {1, 3, 4, 5, 2, 3, 4};

    WLS wls = new WLS(x, y, 0.9);
    Point point = wls.fitLinearRegression();

    assertEquals(2.14285714, point.getIntercept(), delta);
    assertEquals(0.25, point.getSlope(), delta);
  }

  @Test()
  void testSinglePointDisallowed() {
    final double[] x = {10};
    final double[] y = {1};
    assertThrows(
        AssertionError.class,
        () -> new WLS(x, y));
  }
}
