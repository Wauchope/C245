package Other;

import java.util.Scanner;

public class Helper {
    static Scanner in;

    /**
     * Reads a value from default System.in and returns it so long as the value entered is an integer
     *
     * @param prompt       The prompt to display to the user
     * @param errorMessage The error message to display in the case of invalid input
     * @return The integer input by the user
     */
    public static int ReadInt(String prompt, String errorMessage) {
        //If the scanner hasn't been initialized (first time running a read method in this class), create it
        CreateScannerIfNull();

        boolean valid = false;
        int output = 0;
        String userInput;

        //Do while loop so that the code runs once before checking if valid is true
        //Removes repetitive code
        do {
            try {
                //Display the prompt to the user
                System.out.println(prompt);
                //Wait for them to input something to the CLI
                userInput = in.next();

                //Attempt to parse input as an integer
                output = Integer.parseInt(userInput);
                //Set valid to true (exit caluse)
                valid = true;
            } catch (Exception e) { //Perhaps separate into different exceptions, but eh it works
                //If this doesn't work for any reason, display the error message
                System.out.println(errorMessage);
            }
        } while (!valid);
        return output;
    }

    /**
     * Reads a value from default System.in and returns it so long as the value entered is an integer
     * The error message to display in the case of invalid input is
     * "Error: The value you've entered is incorrect. Please enter a valid integer."
     *
     * @param prompt The prompt to display to the user
     * @return The integer input by the user
     */
    public static int ReadInt(String prompt) {
        return ReadInt(prompt, "Error: The value you've entered is incorrect. Please enter a valid integer.");
    }

    /**
     * Reads a value from default System.in and returns it so long as the value entered is an integer
     * The prompt to display to the user is
     * "Please enter an integer:"
     * The error message to display in the case of invalid input is
     * "Error: The value you've entered is incorrect. Please enter a valid integer."
     *
     * @return The integer input by the user
     */
    public static int ReadInt() {
        return ReadInt("Please enter an integer:");
    }

    /**
     * Initializes the scanner object "in" with a new Scanner if it does not already exist
     */
    private static void CreateScannerIfNull() {
        if (in == null)
            in = new Scanner(System.in);
    }
}
