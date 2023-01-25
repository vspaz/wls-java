package org.vspaz.wls;

public class Point {
  private final Double intercept;
  private final Double slope;

  public Point(Double intercept, Double slope) {
    this.intercept = intercept;
    this.slope = slope;
  }

  public Double getIntercept() {
    return intercept;
  }

  public Double getSlope() {
    return slope;
  }
}
