package Day2;

import java.util.Scanner;

import static Other.ExtraMaths.LowestCommonMultiple;
import static Other.Helper.EnterToContinue;
import static Other.Helper.ReadInt;

public class WhileLoopsBasics {
    public static void main(String[] args) {
        Menu();
    }

    public static void AllNumbersInclusive(int start, int end)
    {
        while (start <= end) {
            System.out.println(start);
            start++;
        }
    }

    public static void OddNumbersInRangeDescending(int start, int end)
    {
        if (start % 2 == 0)
            start--;

        while (start >= end)
        {
            System.out.println(start);
            start -= 2;
        }
    }

    public static void GetMultiples(int start, int end, int divisor)
    {
        while (start < end)
        {
            if (start % divisor == 0)
            {
                System.out.println(start + " is a multiple of " + divisor);
            }
            start++;
        }
    }

    public static void GetMultiples(int start, int end, int[] divisors)
    {
        while (start <= end)
        {
            int index = 0;
            //so ugly can i pls use for loop
            while (index < divisors.length)
            {
                if (start % divisors[index] == 0)
                {
                    System.out.println(start + " is a multiple of " + divisors[index]);
                }

                index++;
            }

            start++;
        }
    }

    public static void GetMultiplesOfAllDivisors(int start, int end, int[] divisors)
    {
        GetMultiples(start, end, LowestCommonMultiple(divisors));
    }

    public static void AllNumbersInclusiveFromInput()
    {
        int start = ReadInt("Please enter an integer:");
        int end;
        do {
            end = ReadInt("Please enter an integer higher than the last: ",
                    "Please enter a number that's HIGHER than the last. The first number you entered was: " + start);
        } while (end <= start);
        AllNumbersInclusive(start, end);
    }

    public static void AllCharactersInString(String input)
    {
        int index = 0;
        while (index < input.length())
        {
            System.out.println(input.charAt(index));
            index++;
        }
    }

    public static void Menu() {
        Scanner in = new Scanner(System.in);
        int input;
        do {
            System.out.println("1: Print all numbers between 10 and 25 inclusively");
            System.out.println("2: Print all odd nubmers between 25 and -11 in descending order");
            System.out.println("3: Print all numbers divisible by 6 between 10 and 45");
            System.out.println("4: Print all numbers divisible by 6 and 4 between 10 and 45");
            System.out.println("5: Ask the user to input a lower number and higher number. Loop from lower to higher.");
            System.out.println("6: Print all letters in name");
            System.out.println("7: Exit");

            input = ReadInt("Please select an option from the list above:");

            switch (input) {
                case 1 -> {
                    System.out.println("1: Print all numbers between 10 and 25 inclusively");
                    AllNumbersInclusive(10, 25);
                    EnterToContinue();
                }
                case 2 -> {
                    System.out.println("2: Print all odd nubmers between 25 and -11 in descending order");
                    OddNumbersInRangeDescending(25, -11);
                    EnterToContinue();
                }
                case 3 -> {
                    System.out.println("3: Print all numbers divisible by 6 between 10 and 45");
                    GetMultiples(10, 45, 6);
                    EnterToContinue();
                }
                case 4 -> {
                    System.out.println("4: Print all numbers divisible by 6 AND 4 between 10 and 45");
                    System.out.println("Lowest common multiple is 12.");
                    GetMultiplesOfAllDivisors(10, 45, new int[]{6, 4});
                    EnterToContinue();
                }
                case 5 -> {
                    System.out.println("5: Ask the user to input a lower number and higher number. Loop from lower to higher.");
                    AllNumbersInclusiveFromInput();
                    EnterToContinue();
                }
                case 6 -> {
                    System.out.println("6: Print all letters in name");
                    System.out.println("Please enter your name: ");
                    String name = in.next();
                    AllCharactersInString(name);
                    EnterToContinue();
                }
                default -> {
                }
            }
        } while (input != 7);

        System.out.println("Thank you for using this program. Goodbye");
    }

}

