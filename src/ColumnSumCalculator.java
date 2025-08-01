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
 * @version 1.0
 * @since 1 Aug 2025
 */

import java.util.Scanner; // Import Scanner for user input

public class ColumnSumCalculator {

    public static final int COLUMN_FORMATTING_WIDTH = 6; // Constant for column formatting width

    /**
     * main: This is the entry point of the program.
     * It handles user input and prints the matrix and column sums.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 1 Aug 2025
     */
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in); // Scanner to read user input

        int[] matrixSizeArray = getMatrixSizeFromUser(userInputScanner); // Get dimensions

        double[][] matrixData = getMatrixDataFromUser(
                userInputScanner,
                matrixSizeArray[0],
                matrixSizeArray[1]
        );

        System.out.println("\nOUTPUT:");
        System.out.println("The sums of each of the columns are:\n");

        printMatrix(matrixData); // Display matrix
        sumOfColumns(matrixData); // Display sum of columns

        userInputScanner.close(); // Close scanner
    }

    /**
     * getMatrixSizeFromUser: Prompts user to input number of rows and columns.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param inputScanner Scanner
     * @return int[]
     * @since 1 Aug 2025
     */
    public static int[] getMatrixSizeFromUser(Scanner inputScanner) {
        System.out.print("Enter the number of rows and columns of the array: ");
        int numberOfRows = inputScanner.nextInt();
        int numberOfColumns = inputScanner.nextInt();
        return new int[] { numberOfRows, numberOfColumns };
    }

    /**
     * getMatrixDataFromUser: Prompts user to enter matrix values.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param inputScanner Scanner
     * @param numberOfRows int
     * @param numberOfColumns int
     * @return double[][]
     * @since 1 Aug 2025
     */
    public static double[][] getMatrixDataFromUser(Scanner inputScanner, int numberOfRows, int numberOfColumns) {
        double[][] inputMatrix = new double[numberOfRows][numberOfColumns];
        System.out.println("\nEnter the array:");
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                inputMatrix[row][column] = inputScanner.nextDouble();
            }
        }
        return inputMatrix;
    }

    /**
     * printMatrix: Displays the matrix in a formatted structure.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param matrix double[][]
     * @return void
     * @since 1 Aug 2025
     */
    public static void printMatrix(double[][] matrix) {
        for (double[] rowArray : matrix) {
            System.out.print("      | ");
            for (double value : rowArray) {
                System.out.printf("%" + COLUMN_FORMATTING_WIDTH + ".1f | ", value);
            }
            System.out.println();
        }
    }

    /**
     * sumOfColumns: Calculates and prints the sum of each column.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param matrix double[][]
     * @return void
     * @since 1 Aug 2025
     */
    public static void sumOfColumns(double[][] matrix) {
        final int totalRows = matrix.length;
        final int totalColumns = matrix[0].length;

        System.out.print("Sum   | ");
        for (int columnIndex = 0; columnIndex < totalColumns; columnIndex++) {
            double sumForColumn = 0.0;
            for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
                sumForColumn += matrix[rowIndex][columnIndex];
            }
            System.out.printf("%" + COLUMN_FORMATTING_WIDTH + ".1f | ", sumForColumn);
        }
        System.out.println("\n\n<End Output>");
    }

}
