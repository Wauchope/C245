package Other;

import java.util.Random;
import java.util.Scanner;

public class Helper {
    static Scanner in;
    //Could probably introduce some kind of noise function but for the purpose of this course I don't think I need to
    public static Random random;

    /**
     * Reads a value from default System.in and returns it so long as the value entered is an integer
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
     * Reads a value from default System.in and returns it so long as the value entered is an integer AND it is positive
     * @param prompt       The prompt to display to the user
     * @param errorMessage The error message to display in the case of invalid input
     * @return The integer input by the user
     */
    public static int ReadPosInt(String prompt, String errorMessage) {
        int value;
        do {
            value = ReadInt(prompt, errorMessage);
        } while (value < 0);
        return value;
    }

    /**
     * Reads a value from default System.in and returns it so long as the value entered is an integer AND it is positive
     * The error message to display in the case of invalid input is
     * "Error: The value you've entered is incorrect. Please enter a valid positive integer."
     * @param prompt       The prompt to display to the user
     * @return The integer input by the user
     */
    public static int ReadPosInt(String prompt) {
        return ReadPosInt(prompt, "Error: The value you've entered is incorrect. Please enter a valid positive integer.");
    }

    /**
     * Reads a value from default System.in and returns it so long as the value entered is an integer AND it is positive
     * The prompt to display to the user is
     * "Please enter a positive integer:"
     * The error message to display in the case of invalid input is
     * "Error: The value you've entered is incorrect. Please enter a valid positive integer."
     * @return The integer input by the user
     */
    public static int ReadPosInt() {
        return ReadPosInt("Please enter a positive integer:");
    }
    /**
     * Initializes the scanner object "in" with a new Scanner if it does not already exist
     */
    private static void CreateScannerIfNull() {
        if (in != null) return;

        in = new Scanner(System.in);
    }

    /**
     * Allows you to force the user to press enter to continue
     */
    public static void EnterToContinue()
    {
        System.out.println("Press enter to continue...");
        in.nextLine();
        in.nextLine();
    }


    /**
     * Initializes the scanner object "in" with a new Scanner if it does not already exist
     */
    private static void CreateRandomIfNull() {
        if (random != null) return;

        random = new Random();
    }

    /**
     * Allows you to pick a random value from an enumerator
     * @param myClass The enum you wish to pick randomly from
     * @return A random value from an enumerator
     */
    public static <T extends Enum<?>> T GetRandomFromEnum(Class<T> myClass)
    {
        CreateRandomIfNull();

        int x = random.nextInt(myClass.getEnumConstants().length);
        return myClass.getEnumConstants()[x];
    }

}
