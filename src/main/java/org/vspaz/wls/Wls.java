package org.vspaz.wls;

import java.util.Arrays;

public class Wls {
  private final double[] yPoints;
  private final double[] xPoints;
  private final double[] weights;

  public Wls(double[] xPoints, double[] yPoints, double[] weights) {
    assert xPoints.length == yPoints.length && xPoints.length == weights.length;
    assert xPoints.length > 2;

    this.xPoints = xPoints;
    this.yPoints = yPoints;
    this.weights = weights;
  }

  public Wls(double[] xPoints, double[] yPoints) {
    assert xPoints.length == yPoints.length;
    assert xPoints.length >= 2;

    this.xPoints = xPoints;
    this.yPoints = yPoints;
    this.weights = new double[xPoints.length];
    Arrays.fill(this.weights, 1);
  }

  public Wls(double[] xPoints, double[] yPoints, double weights) {
    assert xPoints.length == yPoints.length;
    assert xPoints.length > 2;

    this.xPoints = xPoints;
    this.yPoints = yPoints;
    this.weights = new double[xPoints.length];
    Arrays.fill(this.weights, weights);
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
