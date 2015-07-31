package c222.easy;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3c9a9h/20150706_challenge_222_easy_balancing_words/
 * 
 * * Implementation of:
 * https://www.reddit.com/r/dailyprogrammer/comments/3c9a9h/20150706_challenge_222_easy_balancing_words/cstqu43 
 */
public class BalanceWordFast 
{
    private final String word;

    public BalanceWordFast(String word)
    {
        this.word = word.toUpperCase();
    }

    public String findBalance()
    {
        Torque leftTorque = new Torque();
        Torque rightTorque = new Torque();
        
        int leftIndex = 0;
        int rightIndex = word.length() - 1;

        while (leftIndex < rightIndex)
        {
            if (leftTorque.value() <= rightTorque.value())
            {
                leftTorque.add(word.charAt(leftIndex));
                leftIndex++;
            }
            else
            {
                rightTorque.add(word.charAt(rightIndex));
                rightIndex--;
            }
        }

        return formattedResult(leftIndex, leftTorque.value(), rightTorque.value());
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
    
    private class Torque
    {
        private int weight = 0;
        private int torque = 0;
        
        public void add(char ch)
        {
            weight += ch - 64;
            torque += weight;
        }
        
        public int value()
        {
            return torque;
        }
    }
}
