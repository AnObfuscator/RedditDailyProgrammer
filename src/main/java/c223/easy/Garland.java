package c223.easy;

import java.io.*;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3d4fwj/20150713_challenge_223_easy_garland_words/
 */
public class Garland
{
    public static int degreeOf(String word)
    {
        int degree = 0;

        int size = word.length();
        int endPoint = size - 1;
        while (endPoint > 0)
        {
            String prefix = word.substring(0, size-endPoint);
            String suffix = word.substring(endPoint);
            if (prefix.equals(suffix))
            {
                degree = prefix.length();
            }
            endPoint--;
        }

        return degree;
    }

    public static String chainOf(String word, int size)
    {
        int degree = degreeOf(word);
        if (degree == 0)
        {
            return word;
        }

        String toAppend = word.substring(degree);
        StringBuilder chain = new StringBuilder();
        chain.append(word);
        for (int i=0; i<size; i++)
        {
            chain.append(toAppend);
        }

        return chain.toString();
    }

    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("Please provide a file path.");
            return;
        }

        try (BufferedReader inputFile = new BufferedReader(new FileReader(args[0])))
        {
            int largestDegree = 0;
            String largestWord = null;
            String word = inputFile.readLine();
            while (word != null)
            {
                int order = Garland.degreeOf(word);
                if (order > largestDegree)
                {
                    largestDegree = order;
                    largestWord = word;
                }
                word = inputFile.readLine();
            }
            System.out.println(String.format("Largest degree was %s for word %s", largestDegree, largestWord));
        }
        catch (FileNotFoundException e)
        {
            System.err.println(String.format("File not found: %s", args[0]));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
