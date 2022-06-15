package DayTwo;

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

    private static boolean IsCharVowel(char character) {
        for (char vowel : VOWELS) {
            if (vowel == Character.toLowerCase(character)) return true;
        }

        return false;
    }

    private static boolean IsFirstCharacterOfStringVowel(String textToCheck) {
        char firstChar = textToCheck.toLowerCase(Locale.ROOT).charAt(0);
        return IsCharVowel(firstChar);
    }

    private static boolean IsCharacterAtIndexOfStringVowel(String textToCheck, int index) {
        if (index < 0 || index >= textToCheck.length()) {
            System.out.println("There is no character at this index. Returning false.");
            return false;
        }
        char characterToCheck = textToCheck.toLowerCase(Locale.ROOT).charAt(index);
        return IsCharVowel(characterToCheck);
    }
}
