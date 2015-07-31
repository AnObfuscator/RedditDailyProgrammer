package c223.intermediate;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3ddpms/20150715_challenge_223_intermediate_eel_of_fortune/
 */
public class PuzzleWordTest 
{
    @Test
    public void test_isProblem_TrueForSameWord()
    {
        String secret = "snond";
        String offensive = "snond";
        
        boolean result = PuzzleWord.isProblem(secret, offensive);
       
        Assert.assertTrue(result);
    }
    
    @Test
    public void test_isProblem_DoubleCharacters()
    {
        String secret = "ssnnoonndd";
        String offensive = "snond";
        
        boolean result = PuzzleWord.isProblem(secret, offensive);
        
        Assert.assertFalse(result);
    }
    
    
    @Test
    public void test_isProblem_Example1()
    {
        String secret = "synchronized";
        String offensive = "snond";

        boolean result = PuzzleWord.isProblem(secret, offensive);

        Assert.assertTrue(result);
    }

    @Test
    public void test_isProblem_Example2()
    {
        String secret = "misfunctioned";
        String offensive = "snond";

        boolean result = PuzzleWord.isProblem(secret, offensive);

        Assert.assertTrue(result);
    }

    @Test
    public void test_isProblem_Example3()
    {
        String secret = "mispronounced";
        String offensive = "snond";

        boolean result = PuzzleWord.isProblem(secret, offensive);

        Assert.assertFalse(result);
    }

    @Test
    public void test_isProblem_Example4()
    {
        String secret = "shotgunned";
        String offensive = "snond";

        boolean result = PuzzleWord.isProblem(secret, offensive);

        Assert.assertFalse(result);
    }
    
}
