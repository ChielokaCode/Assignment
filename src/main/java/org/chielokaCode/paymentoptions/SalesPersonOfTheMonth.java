package org.chielokaCode.paymentoptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SalesPersonOfTheMonth {
    public static void main(String[] args) {
        final int NUM_SALES_PERSONS = 4;
        final int NUM_PRODUCTS = 6;

        double[][] sales = new double[NUM_SALES_PERSONS][NUM_PRODUCTS];

        for (int i = 0; i < NUM_SALES_PERSONS; i++) {
            for (int j = 0; j < NUM_PRODUCTS; j++) {
                sales[i][j] = 0.0;
            }
        }

        try (Scanner scanner = new Scanner(new File(getFilePath()))) {
            while (scanner.hasNext()) {
                try {
                    int salesPersonID = scanner.nextInt();
                    int productNumber = scanner.nextInt();
                    double productSales = scanner.nextDouble();

                    sales[salesPersonID - 1][productNumber - 1] += productSales;
                } catch (java.util.InputMismatchException e) {
                    handleInvalidInputError();
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            handleFileNotFoundError();
        }

        printTableHeader(NUM_PRODUCTS);

        for (int i = 0; i < NUM_SALES_PERSONS; i++) {
            printSalesRow(sales, i, NUM_PRODUCTS);
        }

        printTotalSalesByProduct(sales, NUM_SALES_PERSONS, NUM_PRODUCTS);
        printGrandTotal(sales, NUM_SALES_PERSONS, NUM_PRODUCTS);
    }

    private static String getFilePath() {
        return "src/main/resources/salesScript.txt";
    }

    private static void handleFileNotFoundError() {
        System.err.println("File not found: salesScript.txt");
    }

    private static void handleInvalidInputError() {
        System.err.println("Invalid input format. Skipping the current line.");
    }

    private static void printTableHeader(int numProducts) {
        System.out.printf("%-15s", "Salesperson");
        for (int i = 1; i <= numProducts; i++) {
            System.out.printf("%-15s", "Product " + i);
        }
        System.out.printf("%-15s%n", "Total");
    }

    private static void printSalesRow(double[][] sales, int salesPersonIndex, int numProducts) {
        System.out.printf("%-15s", "Person " + (salesPersonIndex + 1));

        double totalSalesPerson = 0.0;
        for (int j = 0; j < numProducts; j++) {
            System.out.printf("$%-14.2f", sales[salesPersonIndex][j]);
            totalSalesPerson += sales[salesPersonIndex][j];
        }

        System.out.printf("$%-14.2f%n", totalSalesPerson);
    }

    private static void printTotalSalesByProduct(double[][] sales, int numSalesPersons, int numProducts) {
        System.out.printf("%-15s", "Total");
        for (int j = 0; j < numProducts; j++) {
            double totalSalesProduct = 0.0;
            for (int i = 0; i < numSalesPersons; i++) {
                totalSalesProduct += sales[i][j];
            }
            System.out.printf("$%-14.2f", totalSalesProduct);
        }
    }

    private static void printGrandTotal(double[][] sales, int numSalesPersons, int numProducts) {
        double grandTotal = 0.0;
        for (int i = 0; i < numSalesPersons; i++) {
            for (int j = 0; j < numProducts; j++) {
                grandTotal += sales[i][j];
            }
        }
        System.out.printf("$%-14.2f%n", grandTotal);
    }
}
