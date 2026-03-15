package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        logger.info("Scientific Calculator Started");
        while(true) {

            System.out.println("\n===================== Scientific Calculator ======================");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm ln(x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    System.out.println("Result = " + squareRoot(num));
                    break;

                case 2:
                    System.out.print("Enter integer: ");
                    int n = scanner.nextInt();
                    if (n < 0) {
                        System.out.println("Factorial is not defined for negative numbers.");
                    } else {
                        System.out.println("Result = " + factorial(n));
                    }
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    double logNum = scanner.nextDouble();
                    System.out.println("Result = " + naturalLog(logNum));
                    break;

                case 4:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exponent = scanner.nextDouble();
                    System.out.println("Result = " + power(base, exponent));
                    break;

                case 5:
                    logger.info("Calculator Closed");
                    System.out.println("Exiting Calculator...");
                    scanner.close();
                    return;

                default:
                    logger.warn("Invalid menu option selected");
                    System.out.println("Invalid choice!");
            }

        }
    }
    public static double squareRoot(double x) {
        logger.info("Calculating square root of " + x);
        return Math.sqrt(x);
    }
    public static BigInteger factorial(int n) {
        logger.info("Calculating factorial of " + n);

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
    public static double naturalLog(double x) {
        logger.info("Calculating natural log of " + x);
        return Math.log(x);
    }
    public static double power(double base, double exponent) {
        logger.info("Calculating power: " + base + "^" + exponent);
        return Math.pow(base, exponent);
    }
}