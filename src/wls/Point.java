package wls;

public class Point {
    private Double intercept;
    private Double slope;

    public Double getIntercept() {
        return intercept;
    }

    public Double getSlope() {
        return slope;
    }

    public Point(Double intercept, Double slope) {
        this.intercept = intercept;
        this.slope = slope;
    }
}
