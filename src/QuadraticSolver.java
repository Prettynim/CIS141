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

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuadraticSolver {

    /**
     * The QuadraticEquation class represents a quadratic equation of the form ax^2 + bx + c = 0.
     * It provides methods to calculate the discriminant and the roots of the equation.
     *
     * @author Young Min Kim
     * @version 1.0
     * @since 7 Aug 2025
     */
    static class QuadraticEquation {
        /**
         * The private data field a, representing the coefficient of the x^2 term.
         */
        private double a;

        /**
         * The private data field b, representing the coefficient of the x term.
         */
        private double b;

        /**
         * The private data field c, representing the constant term.
         */
        private double c;

        /**
         * A constructor that creates a QuadraticEquation object with given coefficients.
         *
         * @author Young Min Kim
         * @version 1.0
         * @param a The coefficient of x^2.
         * @param b The coefficient of x.
         * @param c The constant term.
         * @since 7 Aug 2025
         */
        public QuadraticEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        /**
         * Returns the value of the coefficient a.
         *
         * @author Young Min Kim
         * @version 1.0
         * @return The coefficient a.
         * @since 7 Aug 2025
         */
        public double getA() {
            return a;
        }

        /**
         * Returns the value of the coefficient b.
         *
         * @author Young Min Kim
         * @version 1.0
         * @return The coefficient b.
         * @since 7 Aug 2025
         */
        public double getB() {
            return b;
        }

        /**
         * Returns the value of the coefficient c.
         *
         * @author Young Min Kim
         * @version 1.0
         * @return The coefficient c.
         * @since 7 Aug 2025
         */
        public double getC() {
            return c;
        }

        /**
         * Calculates and returns the discriminant of the quadratic equation.
         * The discriminant is calculated as b^2 - 4ac.
         *
         * @author Young Min Kim
         * @version 1.0
         * @return The discriminant.
         * @since 7 Aug 2025
         */
        public double getDiscriminant() {
            return b * b - 4 * a * c;
        }

        /**
         * Calculates and returns the first root of the equation.
         * The root is calculated as (-b + sqrt(discriminant)) / 2a.
         * This method returns 0 if the discriminant is negative.
         *
         * @author Young Min Kim
         * @version 1.0
         * @return The first root of the equation, or 0 if discriminant is negative.
         * @since 7 Aug 2025
         */
        public double getRoot1() {
            double discriminant = getDiscriminant();
            if (discriminant >= 0) {
                return (-b + Math.sqrt(discriminant)) / (2 * a);
            } else {
                return 0; // Discriminant is negative, no real root
            }
        }

        /**
         * Calculates and returns the second root of the equation.
         * The root is calculated as (-b - sqrt(discriminant)) / 2a.
         * This method returns 0 if the discriminant is negative.
         *
         * @author Young Min Kim
         * @version 1.0
         * @return The second root of the equation, or 0 if discriminant is negative.
         * @since 7 Aug 2025
         */
        public double getRoot2() {
            double discriminant = getDiscriminant();
            if (discriminant >= 0) {
                return (-b - Math.sqrt(discriminant)) / (2 * a);
            } else {
                return 0; // Discriminant is negative, no real root
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     *
     * @author Young Min Kim
     * @version 1.0
     * @return void
     * @since 7 Aug 2025
     */
    public static void displayMenu() {
        System.out.println("--- Interactive Menu ---");
        System.out.println("1. Solve a new quadratic equation");
        System.out.println("2. Exit");
        System.out.print("Please enter your choice: ");
    }

    /**
     * The main method of the program. It provides an interactive loop
     * to solve quadratic equations based on user input.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param args Command line arguments (not used).
     * @return void
     * @since 7 Aug 2025
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Quadratic Solver for equations of the form ax^2 + bx + c = 0.");
        System.out.println(); // Blank line for better formatting

        do {
            displayMenu();
            // Check if the input is an integer to prevent crashes
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                input.next(); // Consume the invalid input
                displayMenu();
            }
            choice = input.nextInt();

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
            System.out.println(); // Add a blank line after each operation for readability
        } while (choice != 2);

        input.close();
    }

    /**
     * This modular method handles the logic for solving a single quadratic equation.
     * It prompts the user for coefficients, creates a QuadraticEquation object,
     * and displays the results based on the discriminant.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param input The Scanner object to read user input.
     * @return void
     * @since 7 Aug 2025
     */
    public static void solveEquation(Scanner input) {
        // Use a modular method to get and validate the user's input
        double[] coefficients = getUserCoefficients(input);
        double a = coefficients[0];
        double b = coefficients[1];
        double c = coefficients[2];

        // Create an instance of the QuadraticEquation class
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        double discriminant = equation.getDiscriminant();

        System.out.println(); // Blank line for formatting
        System.out.printf("The Quadratic equation %.0fx^2 + %.0fx + %.0f = 0\n", a, b, c);

        // Check the discriminant to determine the nature of the roots
        if (discriminant > 0) {
            System.out.println("Has the following Roots:");
            System.out.printf("R1 = %.4f\n", equation.getRoot1());
            System.out.printf("R2 = %.4f\n", equation.getRoot2());
        } else if (discriminant == 0) {
            // Special case for a single root
            System.out.println("Has one real root:");
            System.out.printf("R = %.4f\n", equation.getRoot1());
        } else {
            System.out.println("Does not have a real solution.");
        }
    }

    /**
     * Prompts the user for three coefficients and validates the input.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param input The Scanner object to read user input.
     * @return A double array containing the three valid coefficients.
     * @since 7 Aug 2025
     */
    private static double[] getUserCoefficients(Scanner input) {
        double a, b, c;

        // Use a loop to ensure valid double inputs
        while (true) {
            System.out.println("\nPlease, enter the three coefficients: (Example: 2 4 1)");
            try {
                a = input.nextDouble();
                b = input.nextDouble();
                c = input.nextDouble();
                break; // Exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter three numbers separated by spaces.");
                input.nextLine(); // Clear the invalid input
            }
        }
        return new double[]{a, b, c};
    }
}
