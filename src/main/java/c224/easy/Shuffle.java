package c224.easy;


import java.util.Iterator;
import java.util.Random;

public class Shuffle 
{
    public static String thisList(String theList)
    {
        String[] asArray = theList.split(" ");

        StringBuilder shuffled = new StringBuilder();
        Iterator<String> theIterator = new RandomIterator<>(asArray);
        while (theIterator.hasNext())
        {
            String next = theIterator.next();
            shuffled.append(next);
            shuffled.append(" ");
        }
        
        return shuffled.toString().trim();
    }
    
}
