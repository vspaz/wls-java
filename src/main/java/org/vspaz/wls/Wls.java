package org.vspaz.wls;

import java.util.Arrays;

public class Wls {
  private final double[] yPoints;
  private final double[] xPoints;
  private final double[] weights;

  public Wls(double[] y, double[] x, double[] w) {
    assert x.length == y.length && x.length == w.length;
    assert x.length > 2;

    this.xPoints = x;
    this.yPoints = y;
    this.weights = w;
  }

  public Wls(double[] x, double[] y) {
    assert x.length == y.length;
    assert x.length >= 2;

    this.xPoints = x;
    this.yPoints = y;
    this.weights = new double[x.length];
    Arrays.fill(this.weights, 1);
  }

  public Wls(double[] x, double[] y, double w) {
    assert x.length == y.length;
    assert x.length > 2;

    this.xPoints = x;
    this.yPoints = y;
    this.weights = new double[x.length];
    Arrays.fill(this.weights, w);
  }

  public Point fitLinearRegression() {
    double sumOfWeights = 0.0;
    double sumOfWeightsByXSquared = 0.0;
    double sumOfXByYByWeights = 0.0;
    double sumOfXByWeights = 0.0;
    double sumOfYByWeights = 0.0;

    double Xi, Yi, Wi, XiByWi;

    for (int i = 0; i < this.xPoints.length; i++) {
      Xi = this.xPoints[i];
      Yi = this.yPoints[i];
      Wi = this.weights[i];

      sumOfWeights += Wi;
      XiByWi = Xi * Wi;

      sumOfXByWeights += XiByWi;
      sumOfXByYByWeights += XiByWi * Yi;
      sumOfYByWeights += Yi * Wi;
      sumOfWeightsByXSquared += XiByWi * Xi;
    }

    double dividend = sumOfWeights * sumOfXByYByWeights - sumOfXByWeights * sumOfYByWeights;
    double divisor = sumOfWeights * sumOfWeightsByXSquared - sumOfXByWeights * sumOfXByWeights;

    if (divisor == 0) {
      return new Point(null, null);
    }

    double slope = dividend / divisor;
    double intercept = (sumOfYByWeights - slope * sumOfXByWeights) / sumOfWeights;

    return new Point(intercept, slope);
  }
}
