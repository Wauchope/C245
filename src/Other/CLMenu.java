package Other;

import java.util.function.Function;

import static Other.Helper.ReadInt;

public class CLMenu {
    String[] options;
    Runnable[] methods;
    public CLMenu(String[] options, Runnable[] methods)
    {
        if (options.length != methods.length)
        {
            throw new IllegalArgumentException("Options and methods must be the same length.");
        }

        this.options = options;
        this.methods = methods;
    }

    public void StartMenu()
    {
        int choice;
        do {
            //Display options
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }
            System.out.println((options.length + 1) + ": Exit program");

            //Get user input and ensure its in the correct range
            do {
                choice = ReadInt("Please select an option: ", "Please enter a number between 1 and " + options.length + ":");
            } while (choice < 1 || choice > options.length + 1);

            //As long as we're not trying to exit
            if (choice != options.length + 1) {
                //Run the relevant method
                methods[choice-1].run();
            }
        }
        while(choice != options.length+1);

        System.out.println("Thank you for running my program! Goodbye.");
    }
}
