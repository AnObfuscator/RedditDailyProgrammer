package c223.intermediate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3ddpms/20150715_challenge_223_intermediate_eel_of_fortune/
 */
public class PuzzleWord 
{
    public static boolean isProblem(String secret, String offensive)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<secret.length(); i++)
        {
            char ch = secret.charAt(i);
            if (offensive.indexOf(ch) >= 0)
            {
                sb.append(ch);
            }
        }
        String trimmedSecret = sb.toString();
        
        return offensive.equals(trimmedSecret);
    }
    
    public static int problemCount(String filePath, String offensive)
    {
        int problemCount = 0;

        try (BufferedReader inputFile = new BufferedReader(new FileReader(filePath)))
        {
            String word = inputFile.readLine();
            while (word != null)
            {
                if (PuzzleWord.isProblem(word, offensive))
                {
                    problemCount++;
                }
                word = inputFile.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println(String.format("File not found: %s", filePath));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return problemCount;
    }

    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            //System.out.println("Please provide a file path and offensive word.");
            //return;
            args = new String[2];
            args[0] = "/Users/jona8276/Projects/RedditDailyProgrammer/src/main/resources/c223/enable1.txt";
            args[1] = "snond";
        }

        String filePath = args[0];
        String offensive = args[1];
        
        int problemCount = problemCount(filePath, offensive);
        System.out.println(String.format("Problem count was %s for word %s", problemCount, offensive));

    }
    
    private static class ProblemCount
    {
        int count = 0;
        String word = "";

        public boolean largerThan(ProblemCount other)
        {
            return other != null && count > other.count;
        }

    }
    
}
