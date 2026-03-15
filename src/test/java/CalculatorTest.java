import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigInteger;



public class CalculatorTest {
    private Main calculator;

    @Before
    public void setUp() {
        calculator = new Main();
    }
    @Test
    public void testSquareRoot(){
        double a = 4;
        double expectedResult = 2.0;
        Assert.assertEquals(expectedResult, calculator.squareRoot(a),0.0001);
    }

    @Test
    public void testSquareRootOfOne(){
        double a = 1;
        double expectedResult = 1.0;
        Assert.assertEquals(expectedResult, calculator.squareRoot(a),0.0001);
    }
    @Test
    public void testFactorial(){
        int a = 5;
        BigInteger expectedResult = BigInteger.valueOf(120);
        Assert.assertEquals(expectedResult, calculator.factorial(a));
    }

    @Test
    public void testFactorialOfZero(){
        int a = 0;
        BigInteger expectedResult = BigInteger.ONE;
        Assert.assertEquals(expectedResult, calculator.factorial(a));
    }
    @Test
    public void testNaturalLog(){
        double a = Math.E;
        double expectedResult = 1.0;
        Assert.assertEquals(expectedResult, calculator.naturalLog(a),0.0001);
    }
    @Test
    public void testNaturalLogOfOne(){
        double a = 1;
        double expectedResult = 0.0;
        Assert.assertEquals(expectedResult, calculator.naturalLog(a),0.0001);
    }
    @Test
    public void testPower(){
        double base = 2;
        double exponent = 3;
        double expectedResult = 8.0;
        Assert.assertEquals(expectedResult, calculator.power(base, exponent),0.0001);
    }
    @Test
    public void testPowerWithZeroExponent(){
        double base = 5;
        double exponent = 0;
        double expectedResult = 1.0;
        Assert.assertEquals(expectedResult, calculator.power(base, exponent),0.0001);
    }

}
