import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowCalculatorTest extends BaseTest{

    @Test(dataProvider = "valuesForPowCalculatorTest", groups = "failed")
    public void powOfTwoNumbers(double a, double b,double expectedResult) {
        double actualValue = calculator.pow(a, b);
        Assert.assertEquals(actualValue, expectedResult);
    }

    @DataProvider(name = "valuesForPowCalculatorTest")
    public Object[][] valuesForPow() {
        return new Object[][]{
                {9, 0.5, 3},
                {64, 0.5, 8},
                {16, 0.25, 2}
        };
    }
}
