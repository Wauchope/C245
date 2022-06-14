package Day1;

import static Other.Helper.ReadInt;

public class ChangeCalculator {
    //Currency values in pence for GBP
    final static int[] currencyValues = {5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        int[] changeCount = new int[currencyValues.length];

        //Get the user to input an amount
        int money = ReadInt("Please enter an amount of money in pence.");

        //Create new variable to change as we calculate change
        int remainder = money;

        //Loop through all currency values.
        for (int i = 0; i < currencyValues.length; i++) {
            //Floor division as both numbers are integers
            //Get the count of each note or coin fit whole into the remaining amount of money
            changeCount[i] = remainder / currencyValues[i];
            //Adjust the remaining amount of money accordingly
            remainder %= currencyValues[i];
        }

        //Output to user
        System.out.println(money + " converts to the following change:");
        for (int i = 0; i < currencyValues.length; i++) {
            //If theres none of a particular currency (e.g. no £20 note) there's no need to do anything, go to the next iteration
            if (changeCount[i] == 0) continue;

            //If we're talking about currency greater than or equal to £1
            if (currencyValues[i] >= 100) {
                //Format the output accordingly
                System.out.println("£" + (currencyValues[i] / 100) + ": " + changeCount[i]);
            } else {
                //Format the output accordingly
                System.out.println(currencyValues[i] + "p: " + changeCount[i]);
            }
        }
    }
}
