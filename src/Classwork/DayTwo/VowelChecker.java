package Classwork.DayTwo;

import java.util.Locale;
import java.util.Scanner;

public class VowelChecker {
    final static char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a string with a length greater than 3");
        String text = in.next();

        //Simple test, is a character a vowel
        char simpleTestChar = 'b';
        char simpleTestChar2 = 'a';
        System.out.println(IsCharVowel(simpleTestChar)); // Should return false
        System.out.println(IsCharVowel(simpleTestChar2)); // Should return true

        System.out.println(IsFirstCharacterOfStringVowel(text)); // With input text banana this should return false
        System.out.println(IsCharacterAtIndexOfStringVowel(text, 3)); //With input text banana this should return true

    }

    /**
     * Takes a character and returns true if the character is a vowel, or false otherwise
     * @param character The character to check
     * @return True or false dependent on the input character
     */
    private static boolean IsCharVowel(char character) {
        for (char vowel : VOWELS) {
            if (vowel == Character.toLowerCase(character)) return true;
        }

        return false;
    }

    /**
     * Takes a string and checks if the first character is a vowel
     * @param textToCheck The string to check
     * @return True or false dependent on the input string
     */
    private static boolean IsFirstCharacterOfStringVowel(String textToCheck) {
        char firstChar = textToCheck.toLowerCase(Locale.ROOT).charAt(0);
        return IsCharVowel(firstChar);
    }

    /**
     * Takes an input string and a position and checks whether the character at this position is a vowel.
     * If there is no character at that position (index out of range) returns false.
     * @param textToCheck The string to check
     * @param index The position to check
     * @return True (if the character at position index is a vowel), false otherwise
     */
    private static boolean IsCharacterAtIndexOfStringVowel(String textToCheck, int index) {
        if (index < 0 || index >= textToCheck.length()) {
            System.out.println("There is no character at this index. Returning false.");
            return false;
        }
        char characterToCheck = textToCheck.toLowerCase(Locale.ROOT).charAt(index);
        return IsCharVowel(characterToCheck);
    }
}
