package Classwork.DayTwo;

import static Other.ReadNumbers.ReadInt;

public class AgeBand {
    public static void main(String[] args) {
        /*
        bands
        0..3 infant
        4..12 child
        13..18 teen
        19..64 adult
        65..130 oap
         */
        int age = ReadInt("How old is the person?");

        String band;

        //Rudimentary error checking
        //Can force the user to enter an input again
        // i.e. (while input < 0 or input > 130 readInt())

        if (age < 0) {
            System.out.println("The person is at an impossible age");
            return;
        } else if (age < 4) // Age is therefore at least 0, so age is in range 0 <= age <= 3 at this point
        {
            band = "Infant";
        } else if (age < 13) // Age is therefore at least 4, so age is in range 4 <= age <= 12 at this point
        {
            band = "Child";
        } else if (age < 19) // etc...
        {
            band = "Teenager";
        } else if (age < 65) // etc...
        {
            band = "Adult";
        } else if (age < 130) //etc...
        {
            band = "OAP";
        } else { //Second half of rudimentary error checking. No one has lived greater than about 122, lets give some leeway
            System.out.println("The person is at an impossible age");
            return;
        }

        System.out.println("The person is a(n) " + band);
    }
}
