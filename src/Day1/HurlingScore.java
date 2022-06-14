package Day1;

public class HurlingScore
{
    public static void main(String[] args)
    {
        int homeGoals = 3, homePoints = 10, awayGoals = 3, awayPoints = 9;

        int homeTotal = CalculateTotal(homeGoals, homePoints);
        int awayTotal = CalculateTotal(awayGoals, awayPoints);

        int margin = CalculateMargin(homeTotal, awayTotal);

        String outputStatement = DetermineWinner(homeTotal, awayTotal) + //Get the winner
                ((margin > 0)?String.format(" by a margin of %o", margin):""); //If the margin in scores is greater than 0 then state the margin

        System.out.println(outputStatement);

    }

    /**
     * Calculates the score total for a team given their goals and points scored.
     * @param goals The number of goals scored by a team
     * @param points The number of points scored by a team
     * @return The score total for a team
     */
    private static int CalculateTotal(int goals, int points)
    {
        return 3 * goals + points;
    }

    /**
     * Determines the winner of a game of hurling given two scores
     * @param homeScore The score total of the home team
     * @param awayScore The score total of the away team
     * @return A string containing the winning team of the game. Can either be "Home team wins", "Away team wins" or
     * "No team wins"
     */
    private static String DetermineWinner(int homeScore, int awayScore)
    {
        if (homeScore > awayScore) return "Home team wins";
        else if (awayScore > homeScore) return "Away team wins";
        else return "No team wins";
    }

    /**
     * Calculates the difference between the two teams scores by taking the absolute difference between them
     * @param homeScore The score total of the home team
     * @param awayScore The score total of the away team
     * @return The absolute difference in score between the two teams
     */
    private static int CalculateMargin(int homeScore, int awayScore)
    {
        return Math.abs(homeScore - awayScore);
    }
}
