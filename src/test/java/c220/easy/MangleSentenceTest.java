package c220.easy;


import org.junit.Assert;
import org.junit.Test;

public class MangleSentenceTest
{
    @Test
    public void test_MangleSimpleSentence_ReversesWords()
    {
        String sentence = "hello there";
        
        MangleSentence mangler = new MangleSentence(sentence);
        
        String result = mangler.mangle();

        Assert.assertEquals("ehllo eehrt", result);
    }
    
    @Test
    public void test_MangleSimpleSentenceWithCapitals_RetainsCapitalizationPosition()
    {
        String sentence = "Hello thErE";

        MangleSentence mangler = new MangleSentence(sentence);

        String result = mangler.mangle();

        Assert.assertEquals("Ehllo eeHrT", result);
    }

    @Test
    public void test_MangleSimpleSentenceWithPunctuation_RetainsPunctuationPosition()
    {
        String sentence = "(hello, the're!)";

        MangleSentence mangler = new MangleSentence(sentence);

        String result = mangler.mangle();

        Assert.assertEquals("(ehllo, eeh'rt!)", result);
    }
    
    @Test
    public void test_MangleSimpleSentenceWithCapitalsAndPunctuation_RetainsCorrectPositions()
    {
        String sentence = "(Hello, thE'rE!)";

        MangleSentence mangler = new MangleSentence(sentence);

        String result = mangler.mangle();

        Assert.assertEquals("(Ehllo, eeH'rT!)", result);
    }
    
    @Test
    public void test_MangleComplexSentence_Sample1()
    {
        String sentence = "This challenge doesn't seem so hard.";

        MangleSentence mangler = new MangleSentence(sentence);

        String result = mangler.mangle();

        Assert.assertEquals("Hist aceeghlln denos't eems os adhr.", result);
    }

    @Test
    public void test_MangleComplexSentence_Sample2()
    {
        String sentence = "There are more things between heaven and earth, Horatio, than are dreamt of in your philosophy.";

        MangleSentence mangler = new MangleSentence(sentence);

        String result = mangler.mangle();

        Assert.assertEquals("Eehrt aer emor ghinst beeentw aeehnv adn aehrt, Ahioort, ahnt aer ademrt fo in oruy hhilooppsy.", result);
    }

    
}
