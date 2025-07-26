/**
 * SimpleInteractiveMenu.java
 *
 * Description: This program demonstrate a simple text based interactive
 * menu system using a do-while loop.
 *
 * An interactive menu is one that have the following properties:
 * -. Clears the screen at the start of the application
 * -. Displays the available choices to the user
 * -. One of the choices is to exit the application
 * -. Once the user selects its choice the application performs selected task
 * -. Displays the result of the task to the user
 * -. Ask the user to press any key to continue
 * -. Clears the screen
 * -. Displays the menu again to the user for selection of more choices
 * -. The user have the option to continue or exit the application
 * -. Finaly clear the screen upon exiting
 *
 * @author FHB
 * @version 1.0
 * @since 20 Feb 2019
 */
import java.util.Scanner;
public class SimpleInteractiveMenu {
    private static char userChoice = '0';
    private static final char EXIT = '0';
    public static void main(String[] args) {
        do {
            clearConsole();
            displayMenu();
            getUserChoice();
            executeCommand();
        }while(userChoice != EXIT);
        clearConsole();
    } // End of main
    /**
     * displayMenu: This method display a simple menu, it gets the input
     * from the user, and passes the user input to the method that
     * executes the selected choice.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void displayMenu() {
        System.out.println(" ___________________________________");
        System.out.println("| SIMPLE INTERACTIVE MENU |");
        System.out.println("|SELECT ONE OF THE FOLLOWING CHOICES|");
        System.out.println("|___________________________________|");
        System.out.println("| 1. Copy File |");
        System.out.println("| 2. Save File |");
        System.out.println("| 3. Delete File |");
        System.out.println("| 4. Move File |");
        System.out.println("| 0. Exit Program |");
        System.out.println("|___________________________________|");
        System.out.print(" Enter your choice: ");
    } // End of displayMenu
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
        System.out.println();
    } // End of getUserChoice
    /**
     * executeCommand: This method executes the command that matches the
     * parameter.
     *
     * @author FHB
     * @version 1.0
     * @param none
     * @return void
     * @since 6 May 2019
     */
    public static void executeCommand() {
        clearConsole();
        switch(userChoice) {
            case '0' -> {
                System.out.println("EXITING PROGRAM...");
                pressEnterToContinue();
            }
            case '1' -> {
                System.out.println("Copying File...");
                pressEnterToContinue();
            }
            case '2' -> {
                System.out.println("Saving File...");
                pressEnterToContinue();
            }
            case '3' -> {
                System.out.println("Deleting File...");
                pressEnterToContinue();
            }
            case '4' -> {
                System.out.println("Moving File...");
                pressEnterToContinue();
            }
            default -> {
                System.out.println("Invalid Choice, Try Again");
                pressEnterToContinue();
            }
        } // End of switch
        System.out.println("");
    } // End of executeCommand
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
    } // End of clearConsole
    /**
     * pressEnterToContinue: This method waits for the
     * user to press the ENTER key to continue the program
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
    } // End of pressEnterToContinue
} // End of class SimpleInteractiveMenu
