package Other;

import java.util.Arrays;
import java.util.List;

import static Other.Helper.ReadInt;

/**
 * A class for implementing a simple command line interface.
 * Allows you to use an array of Runnables, along with an array of descriptions of equal length to use within the menu
 * @author Jordan Luke Wauchope
 */
public class CLMenu {
    private List<String> options;
    private List<Runnable> methods;

    /**
     * Create the CLMenu object.
     * The length of options and methods must be equal.
     * @param options A string array describing what each option will do
     * @param methods An array of Runnables which contain the functionality to START each option above.
     */
    public CLMenu(String[] options, Runnable[] methods)
    {
        if (options.length != methods.length)
        {
            throw new IllegalArgumentException("Options and methods must be the same length.");
        }

        this.options = Arrays.stream(options).toList();
        this.methods = Arrays.stream(methods).toList();
    }

    public CLMenu(List<String> options, List<Runnable> methods)
    {
        if (options.size() != methods.size())
        {
            throw new IllegalArgumentException("Options and methods must be the same length.");
        }

        this.options = options;
        this.methods = methods;
    }

    /**
     * Starts the loop which runs the CLMenu. Takes control of the program.
     */
    public void StartMenu()
    {
        int choice;
        do {
            //Display options
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ": " + options.get(i));
            }
            System.out.println((options.size() + 1) + ": Exit program");

            //Get user input and ensure its in the correct range
            do {
                choice = ReadInt("Please select an option: ", "Please enter a number between 1 and " + (options.size() + 1) + ":");
            } while (choice < 1 || choice > options.size() + 1);

            //As long as we're not trying to exit
            if (choice != options.size() + 1) {

                //Run the relevant method
                methods.get(choice-1).run();
            }
        }
        while(choice != options.size()+1);

        System.out.println("Thank you for running my program! Goodbye.");
    }

    /**
     * Returns an array of strings containing all current options
     * @return an array of strings containing all current options
     */
    public String[] getOptions() {
        return (String[]) options.toArray();
    }

    /**
     * Returns an array of Runnables containing all current options
     * @return an array of Runnables containing all current options
     */
    public Runnable[] getMethods() {
        return (Runnable[]) methods.toArray();
    }

    /**
     * Allows you to change the functionality of an option during runtime
     * @param method The new functionality
     * @param index The index of the option you wish to alter.
     */
    public void setMethod(Runnable method, int index) {
        try {
            methods.set(index, method);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Operation failed: setMethod at index " + index);
            e.printStackTrace();
        }
    }

    /**
     * Allows you to relabel an option during runtime
     * @param option The new label of the option
     * @param index The index of the option you wish to alter.
     */
    public void setOption(String option, int index) {
        try {
            options.set(index, option);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Operation failed: setOption at index " + index);
            e.printStackTrace();
        }
    }

    /**
     * Allows you to add an option into the menu for placeholder reasons
     * @param option A description of what the option does when ran
     */
    public void AddNewOption(String option)
    {
        AddNewOption(option, ()->{throw new UnsupportedOperationException();});
    }

    /**
     * Allows you to add an option into the menu and designate its functionality
     * @param option A description of what the option does when ran
     * @param method The method to be run when this option is chosen. Called using method.run()
     */
    public void AddNewOption(String option, Runnable method)
    {
        options.add(option);
        methods.add(method);

        System.out.println("New option added in position: ");

        assert options.size() == methods.size();
    }

    @Override
    public String toString() {
        return "CLMenu{" +
                "options=" + options +
                ", methods=" + methods +
                '}';
    }
}
