package Other;

import java.util.Random;
import java.util.Scanner;

/**
 * A collection of unorganised methods which tend to be used repeatedly throughout my code,
 * such as pressing enter to continue or reading an integer.
 *
 * Please note that any code in this file is planned to be moved into a more aptly named file in the future.
 * Be careful when updating this package.
 * @author Jordan Luke Wauchope
 */
public class Helper {
    static Scanner in;
    //Could probably introduce some kind of noise function but for the purpose of this course I don't think I need to
    public static Random random;

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
