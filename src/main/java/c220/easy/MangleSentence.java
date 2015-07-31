package c220.easy;

import utils.StringUtils;

import java.util.*;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/3aqvjn/20150622_challenge_220_easy_mangling_sentences/
 */
public class MangleSentence
{
    private final List<Word> sentence;
    
    public MangleSentence(String sentence)
    {
        this.sentence = new ArrayList<Word>();
        for (String part : sentence.split(" "))
        {
            Word word = new Word(part);
            this.sentence.add(word);
        }
    }
    
    public String mangle() 
    {
        StringBuilder sentenceBuilder = new StringBuilder();
        for (Word word : sentence)
        {
            String mangledWord = word.mangle();
            sentenceBuilder.append(mangledWord);
            sentenceBuilder.append(" ");
        }
        
        return sentenceBuilder.toString().trim();
    }
}

class Word 
{
    private final String word;
    
    public Word(String word) 
    {
        this.word = word;
    }
    
    public String mangle()
    {
        List<Character> characters = StringUtils.explode(word);

        List<SpecialStatus> specialStatuses = extractSpecialStatuses(characters);
        Collections.sort(characters);
        reinsertSpecialStatuses(characters, specialStatuses);
        
        
        return StringUtils.collapse(characters);
    }

    private List<SpecialStatus> extractSpecialStatuses(List<Character> characters)
    {
        List<SpecialStatus> specialStatuses = new ArrayList<SpecialStatus>();

        ListIterator<Character> characterIterator = characters.listIterator();
        int removedCharacterCount = 0;
        while (characterIterator.hasNext())
        {
            int index = characterIterator.nextIndex();
            int offsetIndex = index + removedCharacterCount;
            Character ch = characterIterator.next();
            
            if (!Character.isLetter(ch))
            {
                specialStatuses.add(SpecialStatus.special(offsetIndex, ch));
                characterIterator.remove();
                removedCharacterCount++;
            }
            else if (Character.isUpperCase(ch))
            {
                specialStatuses.add(SpecialStatus.upperCase(offsetIndex));
                characterIterator.remove();
                Character asLower = Character.toLowerCase(ch);
                characterIterator.add(asLower);
            }
        }

        return specialStatuses;
    }

    private void reinsertSpecialStatuses(List<Character> characters, List<SpecialStatus> specialStatuses)
    {
        Collections.sort(specialStatuses, SpecialStatus.COMPARATOR);
        for (SpecialStatus status : specialStatuses)
        {
            status.insert(characters);
        }
    }
}

abstract class SpecialStatus
{
    public static final Comparator<SpecialStatus> COMPARATOR = new Comparator<SpecialStatus>() 
    {
        @Override
        public int compare(SpecialStatus o1, SpecialStatus o2) 
        {
            return Integer.compare(o1.index, o2.index);
        }
    };
    
    public static SpecialStatus upperCase(int index)
    {
        return new SpecialStatus.UpperCase(index);
    }

    public static SpecialStatus special(int index, char character)
    {
        return new SpecialStatus.SpecialCharacter(index, character);
    }
    
    final int index;
    
    public SpecialStatus(int index)
    {
        this.index = index;
    }
    
    public abstract void insert(List<Character> characters);

    private static class UpperCase extends SpecialStatus
    {
        public UpperCase(int index)
        {
            super(index);
        }

        @Override
        public void insert(List<Character> characters) 
        {
            Character theCharacter = characters.get(index);
            Character asUppercase = Character.toUpperCase(theCharacter);
            characters.set(index, asUppercase);
        }
    }
    
    private static class SpecialCharacter extends SpecialStatus
    {
        private final char storedCharacter;

        public SpecialCharacter(int index, char character)
        {
            super(index);
            storedCharacter = character;
        }

        @Override
        public void insert(List<Character> characters) 
        {
            int wordLength = characters.size();
            if (index == wordLength) 
            {
                characters.add(storedCharacter);
            }
            else
            {
                characters.add(index, storedCharacter);
            }
        }
    }
}
    