/**
 * LinearEquationSolverWithTwoSamples.java
 */
// This program solves a system of 2x2 linear equations using Cramer's rule.
// It prompts the user for coefficients and constants, calculates the solution, and displays the result.

/**
 * Program Description: This program solves a system of 2x2 linear equations of the form
 *
 * Formulas:
 * ax + by = e
 * cx + dy = f
 *
 * The solution is computed using Cramer's Rule:
 * x = (ed - bf) / (ad - bc)
 * y = (af - ec) / (ad - bc)
 *
 * If (ad - bc) equals 0, the system has no solution.
 *
 * Test Data and Examples:
 *
 * Example 1: "The solution for this system or equations is:":
 * Given the equations:
 * 3.4x + 50.2y = 44.5
 * 2.1x + 3.55y = 5.9
 *
 * Calculation Steps:
 * (3.4 * 3.55) - (50.2 * 2.1) = 12.07-105.42 = -93.35
 *
 * x = (44.5 * 3.55-50.2 * 5.9) / -93.35
 * x = (157.975-295.18) / -93.35
 * x = -137.205 / -93.35 = 1.4810
 *
 * y = (3.4 * 5.9-44.5 * 2.1) / -93.35
 * y = (20.06-93.45) / -93.35
 * y = -73.39 / -93.35 = 0.7862
 *
 * Output:
 * X = 1.481
 * Y = 0.7862
 *
 * -----------------------------------------------------------
 *
 * Example 2: “The equation has no solution.”
 * Given the equations:
 * 2x + 4y = 6
 * 1x + 2y = 3
 *
 * Calculation:
 * (2 * 2) - (4 * 1) = 4-4 = 0
 *
 * Since the result is 0, the system has no solution.
 *
 * Output:
 * The equation has no solution.
 *
 * @author Young Min Kim
 * @version 1.0
 * @since 17 July 2025
 */

import java.util.Scanner;  // Import Scanner class for user input

public class LinearEquationSolverWithTwoSamples {  // Begin class definition

    public static void main(String[] args) {  // Main method start
        solveEquation();  // Call the method to solve the system
    } // End of method main

    /**
     * solveEquation: This method prompts the user to enter the coefficients
     * a, b, c, d, e, and f of a system of 2x2 linear equations, then
     * calculates and displays the solution using Cramer's Rule directly.
     * If the system cannot be solved (ad - bc equals zero), the program
     * reports that there is no solution.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 17 July 2025
     */
    public static void solveEquation() {
        Scanner scanner = new Scanner(System.in);  // Create a scanner object

        // Display program instructions
        System.out.println("System of equation solver:\n");
        System.out.println("ax + by = e");
        System.out.println("cx + dy = f\n");

        // Prompt the user to enter each coefficient and constant
        System.out.print("Enter the value for a: ");
        double a = scanner.nextDouble();  // Read 'a'

        System.out.print("Enter the value for b: ");
        double b = scanner.nextDouble();  // Read 'b'

        System.out.print("Enter the value for c: ");
        double c = scanner.nextDouble();  // Read 'c'

        System.out.print("Enter the value for d: ");
        double d = scanner.nextDouble();  // Read 'd'

        System.out.print("Enter the value for e: ");
        double e = scanner.nextDouble();  // Read 'e'

        System.out.print("Enter the value for f: ");
        double f = scanner.nextDouble();  // Read 'f'

        // Check if the system has no solution by testing if (ad - bc) equals zero
        if ((a * d - b * c) == 0) {
            // Display message when the system cannot be solved
            System.out.println("\nThe equation has no solution.");
        } else {
            // Compute x directly using Cramer's Rule formula
            double x = (e * d - b * f) / (a * d - b * c);

            // Compute y directly using Cramer's Rule formula
            double y = (a * f - e * c) / (a * d - b * c);

            // Display the solution formatted: X with 3 decimals, Y with 4 decimals
            System.out.print("\nThe solution for this system or equations is:\n");
            System.out.printf("X = %.3f\n", x);  // 3 decimals for X
            System.out.printf("Y = %.4f\n", y);  // 4 decimals for Y
        }

        scanner.close();  // Close the scanner to release resources
    } // End of method solveEquation
}

/*
Sample Output 1 (Solvable system):

System of equation solver:

ax + by = e
cx + dy = f

Enter the value for a: 3.4
Enter the value for b: 50.2
Enter the value for c: 2.1
Enter the value for d: 3.55
Enter the value for e: 44.5
Enter the value for f: 5.9

The solution for this system or equations is:
X = 1.481
Y = 0.7862

------------------------------------------------------------

Sample Output 2 (No solution):

System of equation solver:

ax + by = e
cx + dy = f

Enter the value for a: 2
Enter the value for b: 4
Enter the value for c: 1
Enter the value for d: 2
Enter the value for e: 6
Enter the value for f: 3

The equation has no solution.
*/