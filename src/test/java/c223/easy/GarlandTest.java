package c223.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3d4fwj/20150713_challenge_223_easy_garland_words/
 */
public class GarlandTest
{
    @Test
    public void test_degreeOf_HandlesSingleLetter()
    {
        String word = "a";
        int result = Garland.degreeOf(word);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test_degreeOf_HandlesTwoLetters()
    {
        String word = "an";
        int result = Garland.degreeOf(word);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test_degreeOf_HandlesTwoLettersDegreeOne()
    {
        String word = "aa";
        int result = Garland.degreeOf(word);
        Assert.assertEquals(1, result);
    }
    
    @Test
    public void test_degreeOf_HandlesSymmetricWord()
    {
        String word = "ada";
        int result = Garland.degreeOf(word);
        Assert.assertEquals(1, result);
    }
    
    @Test
    public void test_degreeOf_example1()
    {
        String word = "programmer";
        int result = Garland.degreeOf(word);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test_degreeOf_example2()
    {
        String word = "ceramic";
        int result = Garland.degreeOf(word);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test_degreeOf_example3()
    {
        String word = "onion";
        int result = Garland.degreeOf(word);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test_degreeOf_example4()
    {
        String word = "alfalfa";
        int result = Garland.degreeOf(word);
        Assert.assertEquals(4, result);
    }

    @Test
    public void test_chainOf_HandlesSingleLetter()
    {
        String word = "a";
        String result = Garland.chainOf(word, 5);
        Assert.assertEquals("a", result);
    }

    @Test
    public void test_chainOf_HandlesTwoLettersDegreeZero()
    {
        String word = "an";
        String result = Garland.chainOf(word, 5);
        Assert.assertEquals("an", result);
    }

    @Test
    public void test_chainOf_HandlesTwoLettersDegreeOne()
    {
        String word = "aa";
        String result = Garland.chainOf(word, 5);
        Assert.assertEquals("aaaaaaa", result);
    }

    @Test
    public void test_chainOf_HandlesSymmetricWord()
    {
        String word = "ada";
        String result = Garland.chainOf(word, 5);
        Assert.assertEquals("adadadadadada", result);
    }

    @Test
    public void test_chainOf_example1()
    {
        String word = "programmer";
        String result = Garland.chainOf(word, 5);
        Assert.assertEquals("programmer", result);
    }

    @Test
    public void test_chainOf_example2()
    {
        String word = "ceramic";
        String result = Garland.chainOf(word, 5);
        Assert.assertEquals("ceramiceramiceramiceramiceramiceramic", result);
    }

    @Test
    public void test_chainOf_example3()
    {
        String word = "onion";
        String result = Garland.chainOf(word, 5);
        Assert.assertEquals("onionionionionionion", result);
    }

    @Test
    public void test_chainOf_example4()
    {
        String word = "alfalfa";
        String result = Garland.chainOf(word, 5);
        Assert.assertEquals("alfalfalfalfalfalfalfa", result);
    }
}

