import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinCalculatorTest extends BaseTest{
    @Test(dataProvider = "valuesForSinCalculatorTest", groups = "failed")
    public void subOfTwoNumbers(long a, double expectedResult) {
        double actualValue = calculator.sin(a);
        Assert.assertEquals(actualValue, expectedResult);
    }

    @DataProvider(name = "valuesForSinCalculatorTest")
    public Object[][] valuesForSum() {
        return new Object[][]{
                {30, 0.5},
                {90, 1},
        };
    }
}
