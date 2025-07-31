/**
 * Program Description:
 * ---------------------
 * This Java program prompts the user to enter 10 real numbers,
 * then calculates and displays:
 *   - Arithmetic Mean (Average)
 *   - Sample Standard Deviation
 *
 * To compute the standard deviation with this formula, you must store
 * the individual numbers using an array, so they can be used after
 * the mean is obtained.
 *
 * ---------------------
 * MATHEMATICAL FORMULAS:
 * 1. Mean (x̄): x̄ = Σxi / N
 * 2. Sample Standard Deviation (s): s = sqrt( Σ(xi - x̄)² / (N - 1) )
 *
 * SAMPLE RUN:
 * Enter 10 numbers: 1.9 2.5 3.7 2 1 6 3 4 5 2
 * The mean is = 3.11
 * The standard deviation is = 1.55738
 *
 * @author Young Min Kim
 * @version 1.0
 * @since 30 July 2025
 */
import java.util.Scanner; // Import Scanner class for user input

public class StandardDeviationCalculator {

    /**
     * main: The entry point of the program. It continuously accepts input,
     * performs calculations, displays results, and allows the user to rerun or quit.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 30 July 2025
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read input

        while (true) { // Loop to allow repeated execution
            clearConsole(); // Clear the screen before next run

            double[] numbers = getUserInput(scanner); // Get 10 numbers from user
            double meanValue = mean(numbers); // Compute mean of numbers
            double stdDevValue = standardDeviation(numbers); // Compute standard deviation

            printResults(meanValue, stdDevValue); // Display results

            System.out.print("Press Enter to run again or type 'q' to quit: "); // Prompt to repeat or quit
            String choice = scanner.nextLine(); // Read user's decision
            if (choice.equalsIgnoreCase("q")) { // If user types 'q', exit loop
                System.out.println("Program ended."); // Farewell message
                break; // Exit loop
            }
        }

        scanner.close(); // Close scanner resource
    }

    /**
     * getUserInput: Prompts the user to input exactly 10 numeric values.
     * These values are stored in an array and returned for statistical analysis.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 30 July 2025
     */
    public static double[] getUserInput(Scanner input) {
        double[] values = new double[10]; // Create array to store 10 numbers
        System.out.print("Enter 10 numbers: "); // Prompt user for input
        for (int i = 0; i < values.length; i++) {
            values[i] = input.nextDouble(); // Store input into array
        }
        input.nextLine(); // Consume newline character
        return values; // Return array of user input
    }

    /**
     * printResults: Displays the calculated mean and standard deviation
     * in a properly formatted output.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 30 July 2025
     */
    public static void printResults(double mean, double stdDev) {
        System.out.printf("The mean is = %.2f\n", mean); // Print mean value formatted to 2 decimal places
        System.out.printf("The standard deviation is = %.5f\n", stdDev); // Print standard deviation formatted to 5 decimal places
    }

    /**
     * mean: Computes and returns the arithmetic mean (average)
     * of an array of double values.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 30 July 2025
     */
    public static double mean(double[] x) {
        double sum = 0; // Variable to store sum of array elements
        for (double value : x) {
            sum += value; // Add each element to sum
        }
        return sum / x.length; // Return average
    }

    /**
     * standardDeviation: Computes and returns the sample standard deviation
     * of a data set represented by an array of double values.
     * This uses the formula: sqrt( Σ(xi - mean)² / (n - 1) )
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 30 July 2025
     */
    public static double standardDeviation(double[] x) {
        double meanValue = mean(x); // Calculate mean first
        double sumSquaredDiffs = 0; // Accumulate squared differences
        for (double value : x) {
            sumSquaredDiffs += Math.pow(value - meanValue, 2); // Add squared difference to total
        }
        return Math.sqrt(sumSquaredDiffs / (x.length - 1)); // Return sample standard deviation
    }

    /**
     * clearConsole: Clears the screen using ANSI escape codes.
     * Useful for refreshing the console during repeated runs.
     * Note: May not work in all IDEs or systems.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 30 July 2025
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J"); // ANSI escape sequence to clear screen
        System.out.flush(); // Flush output buffer to ensure execution
    }
}
