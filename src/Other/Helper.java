package Other;

import java.util.Scanner;

public class Helper
{
    static Scanner in;

    public static int ReadInt(String prompt, String errorMessage) {
        CreateScannerIfNull();

        boolean valid = false;
        int output = 0;
        String userInput;
        do {
            try {
                System.out.println(prompt);
                userInput = in.next();
                output = Integer.parseInt(userInput);
                valid = true;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        } while (!valid);
        return output;
    }

    public static int ReadInt(String prompt)
    {
        return ReadInt(prompt, "Error: The value you've entered is incorrect. Please enter a valid integer.");
    }

    public static int ReadInt()
    {
        return ReadInt("Please enter an integer:");
    }

    private static void CreateScannerIfNull()
    {
        if (in == null)
            in = new Scanner(System.in);
    }
}
