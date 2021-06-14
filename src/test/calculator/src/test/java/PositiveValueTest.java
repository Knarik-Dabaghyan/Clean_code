import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveValueTest extends BaseTest {

    @Test(dataProvider = "valuesForPositiveNumberTest", groups = "passed")
    public void isNumberPositive(long a, boolean expectedValue) {
        boolean actualValue = calculator.isPositive(a);
        Assert.assertEquals(actualValue, expectedValue);
    }

    @DataProvider(name = "valuesForPositiveNumberTest")
    public Object[][] valuesForSum() {
        return new Object[][]{
                {10, true},
                {10, true},
                {0, false},
                {-1, false}
        };

    }
}
