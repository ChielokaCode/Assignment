package org.chielokaCode.paymentoptions;

/*
* below are digits() and decimals() methods, but they are cathegorised as "Overloaded methods
* because the names of the methods are repeating but the parameters are different - (Method Overload)
 */
public class DigitCounter {

    // Returns the number of digits LEFT of the decimal - that is before the decimal point
    public static int digits(float num) {
        return digits(Float.toString(num));
    }
    public static int digits(double num) {
        return digits(Double.toString(num));
    }
    public static int digits(int num) {
        return digits(Integer.toString(num));
    }
    public static int digits(String numStr) {
        // this if statement checks if there is a leading minus sign and removes it before continuing
        if (numStr.startsWith("-")) {
            numStr = numStr.substring(1);
        }
        int decimalIndex = numStr.indexOf('.');
        return decimalIndex != -1 ? decimalIndex : numStr.length();
    }


    // Returns the number of digits RIGHT of the decimal - that is after the decimal point
    public static int decimals(float num) {
        return decimals(Float.toString(num));
    }

    public static int decimals(double num) {
        return decimals(Double.toString(num));
    }

    public static int decimals(int num) {
        return decimals(Integer.toString(num));
    }
    public static int decimals(String numStr) {
        int decimalIndex = numStr.indexOf('.');
        return decimalIndex != -1 ? numStr.length() - decimalIndex - 1 : 0;
    }
}

