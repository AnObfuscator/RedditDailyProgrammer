package c222.easy;


import org.junit.Assert;
import org.junit.Test;


public class BalanceWordTest 
{
    @Test
    public void test_findBalance_Example1()
    {
        String word = "STEAD";
        String expected = "S T EAD - 19";
        
        BalanceWord balanceWord = new BalanceWord(word);
        BalanceWordFast balanceWordFast = new BalanceWordFast(word);
        
        String result = balanceWord.findBalance();
        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, result);
        Assert.assertEquals(expected, fastResult);
    }

    @Test
    public void test_findBalance_Example2()
    {
        String word = "CONSUBSTANTIATION";
        String expected = "CONSUBST A NTIATION - 456";

        BalanceWord balanceWord = new BalanceWord(word);
        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String result = balanceWord.findBalance();
        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, result);
        Assert.assertEquals(expected, fastResult);

    }

    @Test
    public void test_findBalance_Example3()
    {
        String word = "WRONGHEADED";
        String expected = "WRO N GHEADED - 120";

        BalanceWord balanceWord = new BalanceWord(word);
        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String result = balanceWord.findBalance();
        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, result);
        Assert.assertEquals(expected, fastResult);

    }

    @Test
    public void test_findBalance_Example4()
    {
        String word = "UNINTELLIGIBILITY";
        String expected = "UNINTELL I GIBILITY - 521";

        BalanceWord balanceWord = new BalanceWord(word);
        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String result = balanceWord.findBalance();
        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, result);
        Assert.assertEquals(expected, fastResult);

    }

    @Test
    public void test_findBalance_Example5()
    {
        String word = "SUPERGLUE";
        String expected = "SUPERGLUE DOES NOT BALANCE";

        BalanceWord balanceWord = new BalanceWord(word);
        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String result = balanceWord.findBalance();
        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, result);
        Assert.assertEquals(expected, fastResult);

    }
}
