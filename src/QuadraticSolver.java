/**
 * Program Description: This program demonstrates a solution for quadratic equations.
 * It uses a modular design with a class for the equation logic and a class for user interaction.
 *
 * @author Young Min Kim
 * @version 1.0
 * @since 7 Aug 2025
 */
/**
 * HERE IS A SAMPLE RUN:
 *
 * Welcome to the Quadratic Solver for equations of the form ax2 + bx + c = 0.
 *
 * Please, enter the three coefficients: 2 4 1
 *
 * The Quadratic equation 2x2 + 4x + 1 = 0
 * Has the following Roots:
 *
 * R1 = -0.2929
 * R2 = -1.7071
 *
 * <End Output>
 */

// Import necessary classes for user input and input mismatch exceptions.
import java.util.InputMismatchException;
import java.util.Scanner;

// Main class to run the program.
public class QuadraticSolver {

    // Nested class to handle the mathematical logic of a quadratic equation.
    static class QuadraticEquation {
        // Private data fields to store the coefficients of the equation.
        private double a;
        private double b;
        private double c;

        // Constructor to initialize the coefficients.
        public QuadraticEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        // Getter method for coefficient a.
        public double getA() {
            return a;
        }

        // Getter method for coefficient b.
        public double getB() {
            return b;
        }

        // Getter method for coefficient c.
        public double getC() {
            return c;
        }

        // Method to calculate and return the discriminant.
        public double getDiscriminant() {
            return b * b - 4 * a * c;
        }

        // Method to calculate and return the first root.
        public double getRoot1() {
            // Get the discriminant to check for real roots.
            double discriminant = getDiscriminant();
            // If discriminant is non-negative, calculate the root.
            if (discriminant >= 0) {
                return (-b + Math.sqrt(discriminant)) / (2 * a);
            } else {
                // Otherwise, return 0 as there are no real roots.
                return 0;
            }
        }

        // Method to calculate and return the second root.
        public double getRoot2() {
            // Get the discriminant to check for real roots.
            double discriminant = getDiscriminant();
            // If discriminant is non-negative, calculate the root.
            if (discriminant >= 0) {
                return (-b - Math.sqrt(discriminant)) / (2 * a);
            } else {
                // Otherwise, return 0 as there are no real roots.
                return 0;
            }
        }
    }

    // Method to display the interactive menu options.
    public static void displayMenu() {
        System.out.println("--- Interactive Menu ---");
        System.out.println("1. Solve a new quadratic equation");
        System.out.println("2. Exit");
        System.out.print("Please enter your choice: ");
    }

    // The main method, the program's entry point.
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner input = new Scanner(System.in);
        // Variable to store the user's menu choice.
        int choice;

        // Display a welcome message.
        System.out.println("Welcome to the Quadratic Solver for equations of the form ax^2 + bx + c = 0.");
        System.out.println(); // Blank line for formatting.

        // Main program loop that continues until the user chooses to exit.
        do {
            displayMenu();
            // Loop to handle invalid input for the menu choice.
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                input.next(); // Consume the invalid input to avoid an infinite loop.
                displayMenu();
            }
            // Read the user's choice.
            choice = input.nextInt();

            // Handle the user's choice using a switch statement.
            switch (choice) {
                case 1:
                    solveEquation(input);
                    break;
                case 2:
                    System.out.println("Thank you for using the Quadratic Solver. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid menu option.");
            }
            System.out.println(); // Add a blank line for readability.
        } while (choice != 2);

        // Close the Scanner object to prevent resource leaks.
        input.close();
    }

    // Method to handle the full process of solving one quadratic equation.
    public static void solveEquation(Scanner input) {
        // Call a helper method to get and validate user coefficients.
        double[] coefficients = getUserCoefficients(input);
        // Extract the coefficients from the returned array.
        double a = coefficients[0];
        double b = coefficients[1];
        double c = coefficients[2];

        // Create an instance of the QuadraticEquation class with the user's coefficients.
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        // Calculate the discriminant.
        double discriminant = equation.getDiscriminant();

        System.out.println(); // Blank line for formatting.
        // Print the quadratic equation in a formatted string.
        System.out.printf("The Quadratic equation %.0fx^2 + %.0fx + %.0f = 0\n", a, b, c);

        // Check the discriminant to determine the nature of the roots.
        if (discriminant > 0) {
            // Display two real roots.
            System.out.println("Has the following Roots:");
            System.out.printf("R1 = %.4f\n", equation.getRoot1());
            System.out.printf("R2 = %.4f\n", equation.getRoot2());
        } else if (discriminant == 0) {
            // Display a single real root.
            System.out.println("Has one real root:");
            System.out.printf("R = %.4f\n", equation.getRoot1());
        } else {
            // Display message for no real solution.
            System.out.println("Does not have a real solution.");
        }
    }

    // Private helper method to get and validate three double values from the user.
    private static double[] getUserCoefficients(Scanner input) {
        double a, b, c;

        // Loop to ensure valid double inputs.
        while (true) {
            System.out.println("\nPlease, enter the three coefficients: (Example: 2 4 1)");
            try {
                // Read three double values.
                a = input.nextDouble();
                b = input.nextDouble();
                c = input.nextDouble();
                break; // Exit the loop if input is valid.
            } catch (InputMismatchException e) {
                // Catch the exception if the input is not a double.
                System.out.println("Invalid input. Please enter three numbers separated by spaces.");
                input.nextLine(); // Clear the invalid input from the buffer.
            }
        }
        // Return the valid coefficients in a new array.
        return new double[]{a, b, c};
    }
}
