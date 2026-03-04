import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class CalculatorTest {
    private Main calculator;

    @Before
    public void setUp() {
        calculator = new Main();
    }
    @Test
    public void test_squareroot(){
        double a = 4;
        double expectedResult = 2.0;
        Assert.assertEquals(expectedResult, calculator.squareRoot(a),0.0000);
    }


}
