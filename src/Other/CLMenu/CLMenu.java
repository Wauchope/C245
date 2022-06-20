package Other.CLMenu;

import java.util.List;

import static Other.Helper.ReadInt;

/**
 * A class for implementing a simple command line interface.
 * Allows you to use an array of Runnables, along with an array of descriptions of equal length to use within the menu
 * @author Jordan Luke Wauchope
 */
public class CLMenu {
    private List<CLMenuItem> menuItems;

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

        AddNewOptions(options, methods);
    }

    public CLMenu(List<String> options, List<Runnable> methods)
    {
        if (options.size() != methods.size())
        {
            throw new IllegalArgumentException("Options and methods must be the same length.");
        }

        AddNewOptions((String[]) options.toArray(),
                (Runnable[]) methods.toArray());
    }

    /**
     * Starts the loop which runs the CLMenu. Takes control of the program.
     */
    public void StartMenu()
    {
        int choice;
        do {
            //Display options
            for (int i = 0; i < menuItems.size(); i++) {
                CLMenuItem menuItem = menuItems.get(i);
                System.out.println((i + 1) + ": " + menuItem.getDescription());
            }
            System.out.println((menuItems.size() + 1) + ": Exit program");

            //Get user input and ensure its in the correct range
            do {
                choice = ReadInt("Please select an option: ", "Please enter a number between 1 and " + (menuItems.size() + 1) + ":");
            } while (choice < 1 || choice > menuItems.size() + 1);

            //As long as we're not trying to exit
            if (choice != menuItems.size() + 1) {
                CLMenuItem menuItem = menuItems.get(choice-1);
                //Run the relevant method
                menuItem.getMethod()
                        .run();
            }
        }
        while(choice != menuItems.size()+1);

        System.out.println("Thank you for running my program! Goodbye.");
    }


    public List<CLMenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * Allows you to change the functionality of an option during runtime
     * @param method The new functionality
     * @param index The index of the option you wish to alter.
     */
    public void setMethod(Runnable method, int index) {
        try {
            CLMenuItem option = menuItems.get(index);
            option.setMethod(method);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Operation failed: setMethod at index " + index);
            e.printStackTrace();
        }
    }

    /**
     * Allows you to relabel an option during runtime
     * @param description The new label of the option
     * @param index The index of the option you wish to alter.
     */
    public void setOption(String description, int index) {
        try {
            CLMenuItem CLMenuItem = menuItems.get(index);
            CLMenuItem.setDescription(description);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Operation failed: setOption at index " + index);
            e.printStackTrace();
        }
    }

    /**
     * Allows you to add an option into the menu for placeholder reasons
     * @param description A description of what the option does when ran
     */
    public void AddNewOption(String description)
    {
        AddNewOption(description, ()->{throw new UnsupportedOperationException();});
    }

    /**
     * Allows you to add an option into the menu and designate its functionality
     * @param description A description of what the option does when ran
     * @param method The method to be run when this option is chosen. Called using method.run()
     */
    public void AddNewOption(String description, Runnable method)
    {
        CLMenuItem cLMenuItem = new CLMenuItem(description, method);
        System.out.println("Adding new MenuItem in position: " + menuItems.size());
        AddNewOption(cLMenuItem);
    }

    public void AddNewOption(CLMenuItem cLMenuItem) {
        menuItems.add(cLMenuItem);
    }

    public void AddNewOptions(String[] descriptions, Runnable[] methods) {
        assert descriptions.length == methods.length;

        for (int i = 0; i < descriptions.length; i++) {
            CLMenuItem cLMenuItem = new CLMenuItem(descriptions[i], methods[i]);
            AddNewOption(cLMenuItem);
        }
    }

    @Override
    public String toString() {
        return "CLMenu: A menu with " + menuItems.size() + " elements";
    }
}
