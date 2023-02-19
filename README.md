# wls-java

weighted linear regression in pure Java w/o any 3d party dependency or framework.

the idea is similar to [statsmodels.regression.linear_model.WLS.fit](https://tinyurl.com/y3vkn5d2)

## General Info

WLS is based on the OLS method and help solve problems of model inadequacy or violations of the basic regression
assumptions.

Estimating a linear regression with WLS is useful, but can be appear to be daunting w/o special stats packages, e.g.
python statsmodels.

Still, fitting the model is extremely easy once you can wrap your head around linear algebra and such. Jump to the code
to see that there's nothing difficult about that, but if you feel that you were deprived of joy of Mathematics, feel
free to get familiarized with the reference materials. Believe me you're gonna have enough :-)

## How-to

```java
package org.vspaz.wls;


double[] xPoints = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};
double[] yPoints = {1.0, 3.0, 4.0, 5.0, 2.0, 3.0, 4.0};
double[] weights = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0};

Wls wls = new Wls(x, y, weights);
Point point = wls.fitLinearRegression();

double intercept = point.getIntercept();
double slope = point.getSlope();
```

## References

- [Wikipedia: Weighted least squares](https://en.wikipedia.org/wiki/Weighted_least_squares)
- [Introduction to Linear Regression Analysis, 5th edition](https://tinyurl.com/y3clfnrs)
- [Least Squares Regression Analysis in Terms of Linear Algebra](https://tinyurl.com/y485qhlg) 
