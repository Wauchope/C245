package Day1;

import static Other.Helper.ReadInt;

public class ChangeCalculator {
    //Currency values in pence for GBP
    final static int[] currencyValues = {5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        int[] changeCount = new int[currencyValues.length];

        int money = ReadInt("Please enter an amount of money in pence.");

        int remainder = money;

        for (int i = 0; i < currencyValues.length; i++)
        {
            changeCount[i] = remainder / currencyValues[i];
            remainder %= currencyValues[i];
        }

        System.out.println(money + " converts to the following change:");
        for (int i = 0; i < currencyValues.length; i++) {
            if (changeCount[i] == 0) continue;

            if (currencyValues[i] >= 100)
            {
                System.out.println("£" + (currencyValues[i] / 100) + ": " + changeCount[i]);
            }
            else
            {
                System.out.println(currencyValues[i] + "p: " + changeCount[i]);
            }
        }
    }
}
