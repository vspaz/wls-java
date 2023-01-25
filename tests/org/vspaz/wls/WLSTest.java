package org.vspaz.wls;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WLSTest {

  @Test
  void testWLSModelStableWeight() {
    double[] x = {1, 2, 3, 4, 5, 6, 7};
    double[] y = {1, 3, 4, 5, 2, 3, 4};

    WLS wls = new WLS(x, y);
    Point point = wls.fitLinearRegression();

    assertEquals(2.14285714, point.getIntercept(), 6);
    assertEquals(0.25, point.getSlope(), 6);
  }

  @Test
  void testWLSModelWeight() {
    double[] x = {1, 2, 3, 4, 5, 6, 7};
    double[] y = {1, 3, 4, 5, 2, 3, 4};

    WLS wls = new WLS(x, y, 0.9);
    Point point = wls.fitLinearRegression();

    assertEquals(2.14285714, point.getIntercept(), 6);
    assertEquals(0.25, point.getSlope(), 6);
  }

  @Test()
  void testSinglePointDissallowed() {
    double[] x = {10};
    double[] y = {1};
    assertThrows(
        AssertionError.class,
        () -> {
          WLS wls = new WLS(x, y);
        });
  }
}
