/**
 * Program Name: ColumnSumCalculator.java
 * Program Description: This program calculates and displays the sum of each column
 * of a 2D array input by the user. It prints the original matrix in a table format,
 * followed by the computed column sums.
 *
 * Sample Run:
 *
 * Enter the number of rows and columns of the array: 3 4
 * Enter the array:
 * 1.0 2.0 3.0 5.0
 * 6.0 7.0 8.0 3.0
 * 9.0 5.0 6.0 2.0
 *
 * OUTPUT:
 * The sums of each of the columns are:
 *       |   1.0 |   2.0 |   3.0 |   5.0 |
 *       |   6.0 |   7.0 |   8.0 |   3.0 |
 *       |   9.0 |   5.0 |   6.0 |   2.0 |
 * Sum   |  16.0 |  14.0 |  17.0 |  10.0 |
 *
 * <End Output>
 *
 * @author Young Min Kim
 * @version 1.4
 * @since 1 Aug 2025
 */

import java.util.Scanner;

public class ColumnSumCalculator {

    // Constant for table column width
    public static final int COLUMN_WIDTH = 6;

    /**
     * main: This is the entry point of the program. It handles user input for
     * the matrix dimensions and values, then displays the formatted matrix
     * and the sum of each column.
     *
     * @author Young Min Kim
     * @version 1.4
     * @param args String[] - command-line arguments (not used)
     * @return void
     * @since 1 Aug 2025
     */
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        int[] matrixDimensions = readMatrixDimensions(userInputScanner);
        double[][] inputMatrix = readMatrixValues(userInputScanner, matrixDimensions[0], matrixDimensions[1]);

        System.out.println("\nOUTPUT:");
        System.out.println("The sums of each of the columns are:\n");

        displayFormattedMatrix(inputMatrix);
        calculateAndDisplayColumnSums(inputMatrix);

        userInputScanner.close();
    } // End of method main

    /**
     * readMatrixDimensions: Prompts the user to enter number of rows and columns
     * and stores them in an array.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param inputScanner Scanner - a Scanner object to read user input
     * @return int[] - an array containing the number of rows and columns
     * @since 1 Aug 2025
     */
    public static int[] readMatrixDimensions(Scanner inputScanner) {
        System.out.println("INPUT:");
        System.out.print("Enter the number of rows and columns of the array: ");
        int numberOfRows = inputScanner.nextInt();
        int numberOfColumns = inputScanner.nextInt();
        return new int[] { numberOfRows, numberOfColumns };
    } // End of method readMatrixDimensions

    /**
     * readMatrixValues: Reads the matrix values row by row from user input.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param inputScanner Scanner - Scanner object for user input
     * @param numberOfRows int - number of rows in the matrix
     * @param numberOfColumns int - number of columns in the matrix
     * @return double[][] - the filled matrix
     * @since 1 Aug 2025
     */
    public static double[][] readMatrixValues(Scanner inputScanner, int numberOfRows, int numberOfColumns) {
        double[][] userMatrix = new double[numberOfRows][numberOfColumns];
        System.out.println("\nEnter the array:");
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                userMatrix[rowIndex][columnIndex] = inputScanner.nextDouble();
            }
        }
        return userMatrix;
    } // End of method readMatrixValues

    /**
     * displayFormattedMatrix: Prints the 2D matrix in table format with aligned columns.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param matrix double[][] - the 2D array to be printed
     * @return void
     * @since 1 Aug 2025
     */
    public static void displayFormattedMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.print("      | ");
            for (double value : row) {
                System.out.printf("%" + COLUMN_WIDTH + ".1f | ", value);
            }
            System.out.println();
        }
    } // End of method displayFormattedMatrix

    /**
     * calculateAndDisplayColumnSums: Calculates the sum of each column and prints them
     * aligned with the matrix rows in a formatted table.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param columnMatrix double[][] - the matrix whose column sums are to be calculated
     * @return void
     * @since 1 Aug 2025
     */
    public static void calculateAndDisplayColumnSums(double[][] columnMatrix) {
        final int numberOfRows = columnMatrix.length;
        final int numberOfColumns = columnMatrix[0].length;

        System.out.print("Sum   | ");
        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            double columnSum = 0;
            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                columnSum += columnMatrix[rowIndex][columnIndex];
            }
            System.out.printf("%" + COLUMN_WIDTH + ".1f | ", columnSum);
        }
        System.out.println("\n\n<End Output>");
    } // End of method calculateAndDisplayColumnSums

} // End of class ColumnSumCalculator
