package org.chielokaCode.paymentoptions;

import java.util.Scanner;

public class QuadraticIntegralCalculator {

    /**
     * Calculates the value of the quadratic function F(x) = ax^2 + bx + c.
     *
     * @param x The input value.
     * @param a Coefficient of x^2.
     * @param b Coefficient of x.
     * @param c Constant term.
     * @return The value of F(x).
     */
    public static double quadratic(double x, double a, double b, double c) {
        return a * x * x + b * x + c;
    }

    /**
     * Calculates the left Riemann sum for the given quadratic function within the specified range.
     *
     * @param a Coefficient of x^2.
     * @param b Coefficient of x.
     * @param c Constant term.
     * @param left Left boundary of the interval.
     * @param right Right boundary of the interval.
     * @param bins Number of bins for Riemann sum calculation.
     * @return The left Riemann sum.
     */
    public static double leftRiemannSum(double a, double b, double c, double left, double right, int bins) {
        double deltaX = (right - left) / bins;
        double sum = 0.0;

        // Calculate left Riemann sum using a do loop
        double x = left;
        do {
            sum += quadratic(x, a, b, c) * deltaX;
            x += deltaX;
        } while (x < right);

        return sum;
    }

    /**
     * Counts the number of digits after the decimal point in a given number.
     *
     * @param num The number to count digits.
     * @return The number of digits after the decimal point.
     */
    public static int digitCounter(double num) {
        String numString = Double.toString(num);
        int indexOfDecimal = numString.indexOf(".");
        return numString.length() - indexOfDecimal - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtain user input
        System.out.print("Enter the coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the constant term c: ");
        double c = scanner.nextDouble();
        System.out.print("Enter the left boundary of the interval: ");
        double left = scanner.nextDouble();
        System.out.print("Enter the right boundary of the interval: ");
        double right = scanner.nextDouble();
        System.out.print("Enter the tolerance: ");
        double tolerance = scanner.nextDouble();

        // Initialize variables
        int bins = 1;
        double currentArea = 0.0;
        double previousArea = Double.MAX_VALUE;

        // Use while loop to calculate Riemann sum with increasing bins until tolerance is met
        while (Math.abs(currentArea - previousArea) > tolerance) {
            previousArea = currentArea;
            currentArea = leftRiemannSum(a, b, c, left, right, bins);
            bins *= 2;
        }

        // Display the result with the same number of decimal places as the user's tolerance
        int decimalPlaces = digitCounter(tolerance);
        System.out.printf("The integral approximation is: %." + decimalPlaces + "f\n", currentArea);
    }
}
