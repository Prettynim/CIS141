/**
 * AreaAndPerimeterOfCircle.java
 */
// This program calculates the area and perimeter of a circle
// based on user input for the radius.
/**
 * Program Description: This program calculates the area and perimeter of a circle
 * based on user input for the radius.
 *
 * Formulas:
 * perimeter = 2 * radius * pi
 * area = radius * radius * pi
 *
 * Test Data:
 * Input: 10   - Number without decimal (whole number)
 * Input: 1.1  - Number with decimal higher than 1
 * Input: 0.5  - Number with decimal lower than 1
 *
 * @author Young Min Kim
 * @version 1.0
 * @since 10 July 2025
 */
import java.util.Scanner;  // Import Scanner class for user input

public class AreaAndPerimeterOfCircle {  // Begin class definition

    public static void main(String[] args) {  // Main method start
        calculateCircle();  // Call the method to calculate area and perimeter
    } // End of method main

    /**
     * calculateCircle: Methods must contain this documentation
     * header describing the purpose and logic of the method.
     * The name of the method must be meaningful, meaning
     * the name must give a hint about the purpose of the
     * method.
     * In addition, it must contain the below javadocs fields
     * Look at the exercise's code for sample of documentation.
     *
     * Formulas:
     * area = radius * radius * pi
     * perimeter = 2 * radius * pi
     *
     * @author Young Min Kim
     * @version 1.0
     * @param void
     * @return void
     * @since 10 July 2025
     */
    public static void calculateCircle() {  // Begin method calculateCircle

        Scanner input = new Scanner(System.in);  // Create a Scanner object for input

        System.out.print("Enter the radius of the circle: ");  // Prompt user to enter radius
        double radius = input.nextDouble();  // Read user input for radius as a double

        final double PI = 3.14159;  // Define constant PI value

        double area = PI * radius * radius;  // Calculate area using formula
        double perimeter = 2 * PI * radius;  // Calculate perimeter using formula

        System.out.println("\n--- Circle Measurements ---");  // Print header for output
        System.out.println("Input radius: " + radius);  // Display input radius
        System.out.println("Calculated area: " + area);  // Display calculated area
        System.out.println("Calculated perimeter: " + perimeter);  // Display calculated perimeter

        input.close();  // Close Scanner object to avoid resource leak
    } // End of method calculateCircle

} // End of class AreaAndPerimeterOfCircle

/*
Test Results:

--- Circle Measurements ---
Input radius: 10.0
Calculated area: 314.159
Calculated perimeter: 62.8318

--- Circle Measurements ---
Input radius: 1.1
Calculated area: 3.8013239000000003
Calculated perimeter: 6.911498

--- Circle Measurements ---
Input radius: 0.5
Calculated area: 0.7853975
Calculated perimeter: 3.14159
*/
