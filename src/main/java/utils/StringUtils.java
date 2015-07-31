package utils;

import java.util.ArrayList;
import java.util.List;

public final class StringUtils
{
    private StringUtils() {}
    
    public static List<Character> explode(String string)
    {
        List<Character> explodedString = new ArrayList<Character>();
        for (char ch : string.toCharArray())
        {
            explodedString.add(ch);
        }
        return explodedString;
    }

    public static String collapse(List<Character> characters)
    {
        StringBuilder theString = new StringBuilder();
        for (Character ch : characters)
        {
            theString.append(ch);
        }
        return theString.toString();
    }
}
