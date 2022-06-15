package Other;

public class ExtraMaths {
    /**
     * Takes an array of integers and returns the lowest common multiple of all numbers
     * @param numbers The input array of integers
     * @return The lowest common multiple of all numbers in the array numbers
     */
    public static int LowestCommonMultiple(int[] numbers)
    {
        int lcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            //should probably find a way to explain whats happening here
            //essentially
            //lcm of (a,b,c) = lcm of( lcm of (a,b), c)

            lcm = LowestCommonMultiple(lcm, numbers[i]);
        }
        return lcm;
    }

    /**
     * Returns the lowest common multiple between two numbers
     * @param a an integer
     * @param b an integer
     * @return lowest common multiple of a and b
     */
    public static int LowestCommonMultiple(int a, int b)
    {
        //lcm = product of (a, b) / gcd of (a, b)
        return a * b / GreatestCommonDivisor(a, b);
    }

    /**
     * Returns the greatest common divisor between two numbers
     * @param a an integer
     * @param b an integer
     * @return the greatest common divisor of a and b
     */
    public static int GreatestCommonDivisor(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return GreatestCommonDivisor(b, a % b);
    }
}
