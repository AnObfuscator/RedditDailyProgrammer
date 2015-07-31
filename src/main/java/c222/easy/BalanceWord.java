package c222.easy;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3c9a9h/20150706_challenge_222_easy_balancing_words/
 */
public class BalanceWord 
{
    private final String word;

    public BalanceWord(String word)
    {
        this.word = word.toUpperCase();
    }
    
    public String findBalance()
    {
        int leftWeight = 0;
        int rightWeight = 0;

        int index = 0;
        while (index < word.length())
        {
            leftWeight = calculateLeftWeight(index);
            rightWeight = calculateRightWeight(index);

            if (leftWeight == rightWeight)
            {
                break;
            }

            index++;
        }

        return formattedResult(index, leftWeight, rightWeight);
    }
    
    private int calculateLeftWeight(int balancePoint)
    {
        int sum = 0;
        for (int i=0; i<balancePoint; i++)
        {
            Character ch = word.charAt(i);
            int charValue = ch - 64;
            int distanceFromBalance = balancePoint - i;
            sum += charValue * distanceFromBalance;
        }
        return sum;
    }
    
    private int calculateRightWeight(int balancePoint)
    {
        int sum = 0;
        for (int i=balancePoint+1; i<word.length(); i++)
        {
            Character ch =  word.charAt(i);
            int charValue = ch - 64;
            int distanceFromBalance = i - balancePoint;
            sum += charValue * distanceFromBalance;
        }
        return sum;
    }

    private String formattedResult(int balancePoint, int leftWeight, int rightWeight)
    {
        if (leftWeight != rightWeight)
        {
            return String.format("%s DOES NOT BALANCE", word);
        }

        String left = word.substring(0, balancePoint);
        char balanceChar = word.charAt(balancePoint);
        String right = word.substring(balancePoint+1);

        return String.format("%s %s %s - %s", left, balanceChar, right, leftWeight);
    }
}
