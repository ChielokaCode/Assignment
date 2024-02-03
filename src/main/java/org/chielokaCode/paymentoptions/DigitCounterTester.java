package org.chielokaCode.paymentoptions;

public class DigitCounterTester {
    public static void main(String[] args) {
        // Test cases- random values used to test the different digits() and decimals() methods
        testDigitsDouble(1230.456, 4);
        testDigitsFloat(789.0123f, 3);
        testDigitsInteger(87654321, 8);
        testDigitsDouble(-0.0123, 1); // in case of negative double nums, you can remove these test case if you want
        testDigitsString("456.89", 3);

        testDecimalsDouble(13.456, 3);
        testDecimalsFloat(789.02f, 2);
        testDecimalsInteger(9654321, 0);
        testDecimalsDouble(-30.00123, 5); // in case of negative double nums, you can remove these test case if you want
        testDecimalsString("456787.789", 3);
    }

    //test cases to test digits methods
    private static void testDigitsDouble(double num, int expected) {
        int result = DigitCounter.digits(num);
        System.out.println(getDataType(num) + "  digit test  " + num + "        " + (result == expected ? "PASS" : "FAIL"));

    }
    private static void testDigitsFloat(float num, int expected) {
        int result = DigitCounter.digits(num);
        System.out.println(getDataType(num) + "  digit test  " + num + "        " + (result == expected ? "PASS" : "FAIL"));
    }

    private static void testDigitsInteger(int num, int expected) {
        int result = DigitCounter.digits(num);
        System.out.println(getDataType(num) + "  digit test  " + num + "        " + (result == expected ? "PASS" : "FAIL"));
    }

    private static void testDigitsString(String num, int expected) {
        int result = DigitCounter.digits(num);
        System.out.println(getDataType(num) + "  digit test  " + num + "        " + (result == expected ? "PASS" : "FAIL"));
        System.out.println(" ");
    }

    //test cases to test Decimals methods

    private static void testDecimalsDouble(double num, int expected) {
        int result = DigitCounter.decimals(num);
        System.out.println(getDataType(num) + "  decimal test  " + num + "        " + (result == expected ? "PASS" : "FAIL"));
    }

    private static void testDecimalsFloat(float num, int expected) {
        int result = DigitCounter.decimals(num);
        System.out.println(getDataType(num) + "  decimal test  " + num + "        " + (result == expected ? "PASS" : "FAIL"));
    }

    private static void testDecimalsInteger(int num, int expected) {
        int result = DigitCounter.decimals(num);
        System.out.println(getDataType(num) + "  decimal test  " + num + "        " + (result == expected ? "PASS" : "FAIL"));
    }

    private static void testDecimalsString(String num, int expected) {
        int result = DigitCounter.decimals(num);
        System.out.println(getDataType(num) + "  decimal test  " + num + "        " + (result == expected ? "PASS" : "FAIL"));
    }

    //to get the data type as a string to output together with print statement
    private static String getDataType(Object obj) {
        return switch (obj) {
            case Double numDouble -> "Double";
            case Integer numInt -> "Integer";
            case String numString -> "String";
            case Float numFloat -> "Float";
            default -> "Unknown";
        };
    }
}

