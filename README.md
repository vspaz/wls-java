# wls-java

weighted linear regression in pure Java w/o any 3d party dependency or framework.

the idea is similar to [statsmodels.regression.linear_model.WLS.fit](https://tinyurl.com/y3vkn5d2)

## General Info

WLS is based on the OLS method and help solve problems of model inadequacy or violations of the basic regression
assumptions.

Estimating a linear regression with WLS is useful, but can be appear to be daunting w/o special stats packages, e.g.
python statsmodels, spark & the like.

## How-to

```java
import org.vspaz.wls.*;

public class Main {
    public static void main(String [] args) {
        double[] xPoints = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
        double[] yPoints = {1.0, 3.0, 4.0, 5.0, 2.0, 3.0, 4.0};
        double[] weights = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};

        Wls wlsModel = new Wls(xPoints, yPoints, weights);
        Point point = wlsModel.fitLinearRegression();

        System.out.println(point.getIntercept());
        System.out.println(point.getSlope());
    }
}
```

### Run the example
```shell
 mvn clean compile assembly:single
 java -jar wls.jar
```

## References

- [Wikipedia: Weighted least squares](https://en.wikipedia.org/wiki/Weighted_least_squares)
- [Introduction to Linear Regression Analysis, 5th edition](https://tinyurl.com/y3clfnrs)
- [Least Squares Regression Analysis in Terms of Linear Algebra](https://tinyurl.com/y485qhlg) 
