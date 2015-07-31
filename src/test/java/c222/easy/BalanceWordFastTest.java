package c222.easy;


import org.junit.Assert;
import org.junit.Test;


public class BalanceWordFastTest
{
    @Test
    public void test_findBalance_Example1()
    {
        String word = "STEAD";
        String expected = "S T EAD - 19";

        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, fastResult);
    }

    @Test
    public void test_findBalance_Example2()
    {
        String word = "CONSUBSTANTIATION";
        String expected = "CONSUBST A NTIATION - 456";

        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, fastResult);

    }

    @Test
    public void test_findBalance_Example3()
    {
        String word = "WRONGHEADED";
        String expected = "WRO N GHEADED - 120";

        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, fastResult);
    }

    @Test
    public void test_findBalance_Example4()
    {
        String word = "UNINTELLIGIBILITY";
        String expected = "UNINTELL I GIBILITY - 521";

        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, fastResult);

    }

    @Test
    public void test_findBalance_Example5()
    {
        String word = "SUPERGLUE";
        String expected = "SUPERGLUE DOES NOT BALANCE";

        BalanceWordFast balanceWordFast = new BalanceWordFast(word);

        String fastResult = balanceWordFast.findBalance();

        Assert.assertEquals(expected, fastResult);
    }
}
