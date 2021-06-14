import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeValueTest extends BaseTest{

    @Test(dataProvider = "valuesForNegativeNumberTest", groups = "passed")
    public void isNumberNegative(long number, boolean expectedResult) {
        boolean actualValue = calculator.isNegative(number);
        Assert.assertEquals(actualValue, expectedResult);
    }

    @DataProvider(name = "valuesForNegativeNumberTest")
    public Object[][] valuesForNe() {
        return new Object[][]{
                {10, false},
                {10, false},
                {0, false},
                {-1, true}
        };
    }
}
