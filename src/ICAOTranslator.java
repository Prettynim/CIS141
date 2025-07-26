/**
 * ICAOTranslator: This program translates a user-entered word
 * into the International Civil Aviation Organization Alphabet.
 *
 * Author: Young Min Kim
 * Version: 1.0
 * Date: 2025-07-26
 */

import java.util.Scanner;  // Import Scanner to read input from user

public class ICAOTranslator {

    private static final char EXIT = '0';  // Constant for exiting the program
    private static Scanner scanner = new Scanner(System.in);  // Scanner object to get user input

    /**
     * main: Entry point. Runs the interactive menu loop until user exits.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void main(String[] args) {
        boolean running = true;  // Loop control variable

        while (running) {  // Continue running until user exits
            clearConsole();  // Clear console screen to keep display clean
            displayMenu();  // Show menu options to the user

            String input = scanner.nextLine().trim();  // Read user input, removing leading/trailing spaces

            if (input.length() == 0) continue;  // If input is empty, skip this iteration and show menu again

            char choice = Character.toUpperCase(input.charAt(0));  // Take first character, convert to uppercase

            if (choice == EXIT) {  // If user input is '0' for exit
                System.out.println("\nExiting the program. Goodbye!");  // Print exit message
                running = false;  // End the loop, which exits the program
            } else {  // Otherwise, process user choice
                switch (choice) {
                    case '1' -> translateWord();  // Option 1: Translate a word to ICAO
                    case '2' -> displayChart();   // Option 2: Display full ICAO alphabet chart
                    // No default case required as per requirement
                }
                if (running) pressEnterToContinue();  // Pause so user can see results before menu redisplays
            }
        }
    }

    /**
     * displayMenu: Displays a formatted menu with ICAO translation options.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void displayMenu() {
        System.out.println(" ____________________________________________");  // Top border of menu box
        System.out.println("|              ICAO TRANSLATOR               |");  // Menu title, centered
        System.out.println("|--------------------------------------------|");  // Divider line
        System.out.println("| 1. Translate a word                        |");  // Option 1 text, left-aligned
        System.out.println("| 2. Display ICAO Alphabet Chart             |");  // Option 2 text, left-aligned
        System.out.println("| 0. Exit                                    |");  // Exit option
        System.out.println("|____________________________________________|");  // Bottom border of menu box
        System.out.print("Enter your choice: ");  // Prompt user to enter their choice (no newline)
    }

    /**
     * translateWord: Prompts user for a word and prints its ICAO translation.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void translateWord() {
        System.out.print("\nEnter a word: ");  // Prompt user to input a word
        String word = scanner.nextLine().trim();  // Read the full line and trim spaces

        if (word.isEmpty()) {  // If user entered nothing
            System.out.println("No word entered.");  // Show error message
            return;  // Exit this method without doing anything
        }

        // Show header message with the entered word in quotes
        System.out.println("\nThe word \"" + word + "\" in the ICAO Alphabet is:\n");

        // Loop through each character in the entered word
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toUpperCase(word.charAt(i));  // Convert char to uppercase

            if (ch >= 'A' && ch <= 'Z') {  // Check if character is a letter A-Z
                System.out.print(ch + ": ");  // Print the letter followed by colon and space
                printICAOWord(ch);  // Print the corresponding ICAO word
            } else {  // If character is not a valid letter
                System.out.println(ch + ": (Invalid character, skipped)");  // Inform user it’s skipped
            }
        }
    }

    /**
     * printICAOWord: Prints the ICAO phonetic word for a given letter.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param letter A-Z character to translate
     * @return void
     * @since 2025-07-26
     */
    public static void printICAOWord(char letter) {
        switch (letter) {  // Select ICAO word based on letter
            case 'A' -> System.out.println("Alpha");
            case 'B' -> System.out.println("Bravo");
            case 'C' -> System.out.println("Charlie");
            case 'D' -> System.out.println("Delta");
            case 'E' -> System.out.println("Echo");
            case 'F' -> System.out.println("Foxtrot");
            case 'G' -> System.out.println("Golf");
            case 'H' -> System.out.println("Hotel");
            case 'I' -> System.out.println("India");
            case 'J' -> System.out.println("Juliet");
            case 'K' -> System.out.println("Kilo");
            case 'L' -> System.out.println("Lima");
            case 'M' -> System.out.println("Mike");
            case 'N' -> System.out.println("November");
            case 'O' -> System.out.println("Oscar");
            case 'P' -> System.out.println("Papa");
            case 'Q' -> System.out.println("Quebec");
            case 'R' -> System.out.println("Romeo");
            case 'S' -> System.out.println("Sierra");
            case 'T' -> System.out.println("Tango");
            case 'U' -> System.out.println("Uniform");
            case 'V' -> System.out.println("Victor");
            case 'W' -> System.out.println("Whiskey");
            case 'X' -> System.out.println("X-ray");
            case 'Y' -> System.out.println("Yankee");
            case 'Z' -> System.out.println("Zulu");
            default -> System.out.println("(Unknown)");  // Fallback for invalid characters
        }
    }

    /**
     * displayChart: Displays the entire ICAO alphabet chart.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void displayChart() {
        System.out.println("\n ____________________________________________");  // Top border of chart box
        System.out.println("|              ICAO Alphabet Chart           |");  // Chart title, centered
        System.out.println("|--------------------------------------------|");  // Divider line
        System.out.println("| A: Alpha     | B: Bravo     | C: Charlie   |");  // Row 1
        System.out.println("| D: Delta     | E: Echo      | F: Foxtrot   |");  // Row 2
        System.out.println("| G: Golf      | H: Hotel     | I: India     |");  // Row 3
        System.out.println("| J: Juliet    | K: Kilo      | L: Lima      |");  // Row 4
        System.out.println("| M: Mike      | N: November  | O: Oscar     |");  // Row 5
        System.out.println("| P: Papa      | Q: Quebec    | R: Romeo     |");  // Row 6
        System.out.println("| S: Sierra    | T: Tango     | U: Uniform   |");  // Row 7
        System.out.println("| V: Victor    | W: Whiskey   | X: X-ray     |");  // Row 8
        System.out.println("| Y: Yankee    | Z: Zulu      |              |");  // Row 9
        System.out.println("|____________________________________________|\n");  // Bottom border of chart box
    }

    /**
     * pressEnterToContinue: Pauses program until user presses ENTER.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void pressEnterToContinue() {
        System.out.print("\nPress ENTER to return to the menu...");  // Prompt for user to continue
        scanner.nextLine();  // Wait for user to press ENTER
    }

    /**
     * clearConsole: Attempts to clear the console using ANSI escape codes.
     * \033[H - Moves cursor to top-left corner
     * \033[2J - Clears the screen
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  // Print escape codes to clear screen
        System.out.flush();  // Flush the output buffer to make sure screen clears immediately
    }
}