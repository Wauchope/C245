package Other;

public class ExtraMaths {
    public static int LowestCommonMultiple(int a, int b)
    {
        return a * b / GreatestCommonDivisor(a, b);
    }

    public static int GreatestCommonDivisor(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return GreatestCommonDivisor(b, a % b);
    }
}
