/**
 * ICAOTranslator: This program translates a user-entered word
 * into the International Civil Aviation Organization Alphabet.
 * It repeatedly displays a menu allowing the user to translate words
 * or display the full ICAO alphabet chart until they choose to exit.
 *
 * Author: Young Min Kim
 * Version: 1.0
 * Date: 2025-07-26
 */

import java.util.Scanner;  // Import Scanner to read user input from console

public class ICAOTranslator {

    private static final char EXIT = '0';  // Constant to represent exit menu choice
    private static Scanner scanner = new Scanner(System.in);  // Single Scanner instance shared by all methods

    /**
     * main: The program entry point that controls the overall flow.
     * It shows the menu repeatedly until the user selects the exit option.
     * Reads user menu input and invokes corresponding functions.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param args Command-line arguments (not used)
     * @return void
     * @since 2025-07-26
     */
    public static void main(String[] args) {
        boolean running = true;  // Variable to control program loop

        while (running) {  // Loop to continually show menu until user exits
            clearConsole();  // Clear console to keep UI clean and uncluttered
            displayMenu();  // Show the interactive menu to the user

            String input = scanner.nextLine().trim();  // Read user input, remove leading/trailing whitespace

            if (input.length() == 0) continue;  // If input is blank, skip this iteration and show menu again

            char choice = Character.toUpperCase(input.charAt(0));  // Take the first character, convert to uppercase for case-insensitive comparison

            if (choice == EXIT) {  // If user entered '0', exit the program
                System.out.println("\nExiting the program. Goodbye!");  // Inform user program is closing
                running = false;  // Stop the loop to exit main
            } else {  // If not exit, decide what to do based on choice
                switch (choice) {
                    case '1' -> translateWord();  // Option 1: Translate a word to ICAO alphabet
                    case '2' -> displayChart();   // Option 2: Display full ICAO alphabet chart
                    // No default case as no invalid input message required
                }
                if (running) pressEnterToContinue();  // Pause to let user read output before redisplaying menu
            }
        }
    }

    /**
     * displayMenu: Prints the formatted text menu with choices.
     * The menu includes options to translate a word, display chart, or exit.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void displayMenu() {
        System.out.println(" ____________________________________________");  // Top border line of the menu box
        System.out.println("|              ICAO TRANSLATOR               |");  // Menu title, centered inside box
        System.out.println("|--------------------------------------------|");  // Separator line
        System.out.println("| 1. Translate a word                        |");  // Option 1 with left alignment
        System.out.println("| 2. Display ICAO Alphabet Chart             |");  // Option 2 with left alignment
        System.out.println("| 0. Exit                                    |");  // Option 0 to exit program
        System.out.println("|____________________________________________|");  // Bottom border line of menu box
        System.out.print("Enter your choice: ");  // Prompt user to enter a choice without new line
    }

    /**
     * translateWord: Prompts the user to enter a word.
     * Reads the word and translates each letter into the ICAO phonetic alphabet.
     * Ignores non-alphabetic characters with a skip message.
     * Prints each letter with its corresponding ICAO word on its own line.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void translateWord() {
        System.out.print("\nEnter a word: ");  // Ask user to input a word
        String word = scanner.nextLine().trim();  // Read user input and remove leading/trailing spaces

        if (word.isEmpty()) {  // Check if user entered nothing
            System.out.println("No word entered.");  // Inform user about empty input
            return;  // Exit this method early
        }

        // Show heading with the entered word (preserving original casing)
        System.out.println("\nThe word \"" + word + "\" in the ICAO Alphabet is:\n");

        // Loop through every character of the input word
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toUpperCase(word.charAt(i));  // Convert current character to uppercase

            if (ch >= 'A' && ch <= 'Z') {  // Only process letters A-Z
                System.out.print(ch + ": ");  // Print the uppercase letter followed by colon and space
                printICAOWord(ch);  // Print the matching ICAO word for this letter
            } else {  // For any character outside A-Z
                System.out.println(ch + ": (Invalid character, skipped)");  // Inform user about skipping
            }
        }
    }

    /**
     * printICAOWord: Matches a given uppercase letter to its
     * corresponding ICAO phonetic alphabet word and prints it.
     * Uses a switch statement to map letters to words.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param letter A single uppercase character from A to Z to translate
     * @return void
     * @since 2025-07-26
     */
    public static void printICAOWord(char letter) {
        switch (letter) {  // Select the appropriate ICAO word for each letter
            case 'A' -> System.out.println("Alpha");    // Print Alpha for A
            case 'B' -> System.out.println("Bravo");    // Print Bravo for B
            case 'C' -> System.out.println("Charlie");  // Print Charlie for C
            case 'D' -> System.out.println("Delta");    // Print Delta for D
            case 'E' -> System.out.println("Echo");     // Print Echo for E
            case 'F' -> System.out.println("Foxtrot");  // Print Foxtrot for F
            case 'G' -> System.out.println("Golf");     // Print Golf for G
            case 'H' -> System.out.println("Hotel");    // Print Hotel for H
            case 'I' -> System.out.println("India");    // Print India for I
            case 'J' -> System.out.println("Juliet");   // Print Juliet for J
            case 'K' -> System.out.println("Kilo");     // Print Kilo for K
            case 'L' -> System.out.println("Lima");     // Print Lima for L
            case 'M' -> System.out.println("Mike");     // Print Mike for M
            case 'N' -> System.out.println("November"); // Print November for N
            case 'O' -> System.out.println("Oscar");    // Print Oscar for O
            case 'P' -> System.out.println("Papa");     // Print Papa for P
            case 'Q' -> System.out.println("Quebec");   // Print Quebec for Q
            case 'R' -> System.out.println("Romeo");    // Print Romeo for R
            case 'S' -> System.out.println("Sierra");   // Print Sierra for S
            case 'T' -> System.out.println("Tango");    // Print Tango for T
            case 'U' -> System.out.println("Uniform");  // Print Uniform for U
            case 'V' -> System.out.println("Victor");   // Print Victor for V
            case 'W' -> System.out.println("Whiskey");  // Print Whiskey for W
            case 'X' -> System.out.println("X-ray");    // Print X-ray for X
            case 'Y' -> System.out.println("Yankee");   // Print Yankee for Y
            case 'Z' -> System.out.println("Zulu");     // Print Zulu for Z
            default -> System.out.println("(Unknown)"); // Catch any invalid input gracefully
        }
    }

    /**
     * displayChart: Prints the complete ICAO alphabet chart
     * in a nicely formatted, bordered table layout.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void displayChart() {
        System.out.println("\n ____________________________________________");  // Top border of the chart box
        System.out.println("|              ICAO Alphabet Chart           |");  // Title centered inside box
        System.out.println("|--------------------------------------------|");  // Separator line
        System.out.println("| A: Alpha     | B: Bravo     | C: Charlie   |");  // First row with letters A-C
        System.out.println("| D: Delta     | E: Echo      | F: Foxtrot   |");  // Second row D-F
        System.out.println("| G: Golf      | H: Hotel     | I: India     |");  // Third row G-I
        System.out.println("| J: Juliet    | K: Kilo      | L: Lima      |");  // Fourth row J-L
        System.out.println("| M: Mike      | N: November  | O: Oscar     |");  // Fifth row M-O
        System.out.println("| P: Papa      | Q: Quebec    | R: Romeo     |");  // Sixth row P-R
        System.out.println("| S: Sierra    | T: Tango     | U: Uniform   |");  // Seventh row S-U
        System.out.println("| V: Victor    | W: Whiskey   | X: X-ray     |");  // Eighth row V-X
        System.out.println("| Y: Yankee    | Z: Zulu      |              |");  // Ninth row Y-Z with empty cell
        System.out.println("|____________________________________________|\n");  // Bottom border of the chart box
    }

    /**
     * pressEnterToContinue: Waits for the user to press ENTER
     * before returning control to the caller. Used to pause
     * output so the user can read messages before continuing.
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void pressEnterToContinue() {
        System.out.print("\nPress ENTER to return to the menu...");  // Prompt user to press ENTER
        scanner.nextLine();  // Wait for user input (ENTER)
    }

    /**
     * clearConsole: Attempts to clear the console window screen
     * by printing ANSI escape sequences. This works on most
     * terminals but may not work in all IDE consoles.
     *
     * ANSI codes:
     * \033[H  - Move cursor to home position (top-left corner)
     * \033[2J  - Clear entire screen
     *
     * @author Young Min Kim
     * @version 1.0
     * @param none
     * @return void
     * @since 2025-07-26
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  // Print escape codes to clear screen
        System.out.flush();  // Force output to be sent immediately to console
    }
}
