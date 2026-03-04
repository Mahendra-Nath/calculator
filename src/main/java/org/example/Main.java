package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        logger.info("Scientific Calculator Started");
        while(true) {

            System.out.println("\n===== Scientific Calculator =====");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    System.out.println("Result = " + squareRoot(num));
                    break;
                case 2:
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
}