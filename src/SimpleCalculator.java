/**
 * SimpleCalculator: This program demonstrates implementation
 * of a simple calculator.
 *
 * @author FHB
 * @version 1.0
 * @since 20 Feb 2019
 */
import java.util.Scanner; // The Scanner class must be use to get user input
public class SimpleCalculator {
    private static char userChoice = '0';
    private static final char EXIT = '0';
    private static float firstNumber = 0f;
    private static float secondNumber = 0f;
    private static float operationResult = 0f;
    public static void main(String[] args) {
        runApplication();
    }//End of method main
    /**
     * runApplication: This method displays
     * the menu, get the user choice and execute
     * a valid operation. If user exits, it clears
     * the console
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void runApplication() {
        do {
            clearConsole();
            displayMenu();
            getUserChoice();
            executeOperation();
        }while(userChoice != EXIT);
        clearConsole();
    } // End of method runApplication
    /**
     * displayMenu: This method display a simple menu,
     * it gets the imput from the user, and passess
     * the user imput to the method that executes the
     * selected choice.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void displayMenu() {
        System.out.println(" ___________________________________");
        System.out.println(" | SIMPLE CALCULATOR |");
        System.out.println(" |SELECT ONE OF THE FOLLOWING CHOICES|");
        System.out.println(" |___________________________________|");
        System.out.println(" | 1. + ADD |");
        System.out.println(" | 2. - SUBTRACT |");
        System.out.println(" | 3. * MULTIPLY |");
        System.out.println(" | 4. / DIVIDE |");
        System.out.println(" | 0. Exit Program |");
        System.out.println(" |___________________________________|");
        System.out.print(" Enter your choice: ");
    } // End of method displayMenu
    /**
     * getUserChoice: This method gets the
     * choice from the user as an integer
     * and stores it in the userChoice
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void getUserChoice() {
// Setting a Scanner object to get the user choice.
        Scanner userInput = new Scanner(System.in);
        userChoice = userInput.next().charAt(0);
        userInput.nextLine();
    } // End of method getUserChoice
    /**
     * executeCommand: This method executes the
     * command that matches the case.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void executeOperation() {
        clearConsole();
        switch(userChoice) {
            case '0' -> {
                System.out.println("Exiting Program");
                pressEnterToContinue();
            }
            case '1' -> {
                addNumbers();
                System.out.println(operationResult);
                pressEnterToContinue();
            }
            case '2' -> {
                subtractNumbers();
                System.out.println(operationResult);
                pressEnterToContinue();
            }
            case '3' -> {
                multiplyNumbers();
                System.out.println(operationResult);
                pressEnterToContinue();
            }
            case '4' -> {
                divideNumbers();
                System.out.println(operationResult);
                pressEnterToContinue();
            }
            default -> {
                System.out.println("Invalid Choice, Try Again");
                pressEnterToContinue();
            }
        } // End of switch
        System.out.println("");
    } // End of method executeCommand
    /**
     * pressEnterToContinue: This method waits for the
     * user to press the "ENTER" key to continue the program
     * execution. It uses the Scanner class to capture
     * the ENTER key from the user.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void pressEnterToContinue() {
//Use Scanner to get user input
        Scanner userInput = new Scanner(System.in);
        System.out.println();
        System.out.println("Press \"ENTER\" to continue...");
        userInput.nextLine(); //Capture input without using it.
    } // End of method pressEnterToContinue
    /**
     * addNumbers: This method ask the user for two numbers.
     * The numbers are stored in firstNumber and secondNumber
     * properties respectively, then it add the numbers
     * storing the result in operationResult property.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void addNumbers() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("This is the addition operation");
        System.out.println("Enter the first number: ");
        firstNumber = userInput.nextFloat();
        System.out.println("Enter the second number: ");
        secondNumber = userInput.nextFloat();
        operationResult = firstNumber + secondNumber;
    } // End of method addNumbers
    /**
     * subtractNumbers: This method ask the user for two numbers.
     * The numbers are stored in firstNumber and secondNumber
     * properties respectively, then it subtract firstNumber
     * from secondNumber the it stores the result in the
     * operationResult property.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void subtractNumbers() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("This is the subtraction operation");
        System.out.println("Enter the first number: ");
        firstNumber = userInput.nextFloat();
        System.out.println("Enter the second number: ");
        secondNumber = userInput.nextFloat();
        operationResult = firstNumber - secondNumber;
    } // End of method subtractNumbers
    /**
     * multiplyNumbers: This method ask the user for two numbers.
     * The numbers are stored in firstNumber and secondNumber
     * properties respectively, then it multiply the numbers
     * storing the result in the operationResult property.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void multiplyNumbers() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("This is the multiplication operation");
        System.out.println("Enter the first number: ");
        firstNumber = userInput.nextFloat();
        System.out.println("Enter the second number: ");
        secondNumber = userInput.nextFloat();
        operationResult = firstNumber * secondNumber;
    } // End of method multiplyNumbers
    /**
     * divideNumbers: This method ask the user for two numbers.
     * The numbers are stored in firstNumber and secondNumber
     * properties respectively, then it divides fistNumber
     * and secondNumber, the result is store in the
     * operationResult property.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void divideNumbers() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("This is the division operation");
        System.out.println("Enter the first number: ");
        firstNumber = userInput.nextFloat();
        System.out.println("Enter the second number: ");
        secondNumber = userInput.nextFloat();
        operationResult = firstNumber / secondNumber;
    } // End of method divideNumbers
    /**
     * clearConsole: This method clears the console using ANSI Escape Codes
     * \033[H - This command moves the cursor to the top-left
     * corner of the screen.
     * \033[2J - This command clears the entire console screen.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } // End of method clearConsole
}//End of class SimpleCalculator
