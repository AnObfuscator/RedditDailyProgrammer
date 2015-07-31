package c224.easy;


public class ShuffleExamples 
{
    public static void main(String[] args)
    {
        printShuffled("1 2 3 4 5 6 7 8");
        printShuffled("apple blackberry cherry dragonfruit grapefruit kumquat mango nectarine persimmon raspberry raspberry");
        printShuffled("a e i o u");
    }

    public static void printShuffled(String list)
    {
        System.out.println("Random List: "+list);
        String shuffled = Shuffle.thisList(list);
        System.out.println("Shuffled: "+shuffled);
    }
}
