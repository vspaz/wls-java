package org.vspaz;

import org.vspaz.wls.*;

public class Main {
    public static void main(String [] args) {
        double[] xPoints = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
        double[] yPoints = {1.0, 3.0, 4.0, 5.0, 2.0, 3.0, 4.0};
        double[] weights = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};

        Wls wls = new Wls(xPoints, yPoints, weights);
        Point point = wls.fitLinearRegression();

        System.out.println(point.getIntercept());
        System.out.println(point.getSlope());
    }
}
