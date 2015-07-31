package c224.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RandomIteratorTest 
{
    private Integer[] testArray;
    private int seed;
    
    @Before
    public void setup()
    {
        testArray = new Integer[] {1, 2, 3, 4, 5};
        seed = 123;
    }
    
    
    @Test(expected = NullPointerException.class)
    public void test_Constructor_nullArrayThrowsException()
    {
        new RandomIterator<String>(null, seed);
    }
    
    @Test
    public void test_hasNext_returnsFalseWhenExhausted()
    {
        Iterator<Integer> iter = new RandomIterator<>(testArray, seed);
        
        for (int val : testArray)
        {
            Assert.assertTrue(iter.hasNext());
            iter.next();
        }
        
        Assert.assertFalse(iter.hasNext());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_next_throwsExceptionWhenAccessedAfterExhaustion()
    {
        Iterator<Integer> iter = new RandomIterator<>(testArray, seed);

        for (int val : testArray)
        {
            Assert.assertTrue(iter.hasNext());
            iter.next();
        }

        iter.next();
    }

    @Test
    public void test_next_LeavesInputUnchanged()
    {
        Integer[] testArrayCopy = Arrays.copyOf(testArray, testArray.length);
        Iterator<Integer> iter = new RandomIterator<>(testArray, seed);

        for (int val : testArray)
        {
            Assert.assertTrue(iter.hasNext());
            iter.next();
        }

        Assert.assertArrayEquals(testArrayCopy, testArray);
    }
    
    @Test
    public void test_next_returnsExpectedRandomOrder()
    {
        Integer[] expected = new Integer[] { 3, 2, 5, 4, 1 };
        Iterator<Integer> iter = new RandomIterator<>(testArray, seed);
        
        List<Integer> result = new ArrayList<>();
        while (iter.hasNext())
        {
            result.add(iter.next());
        }

        Assert.assertArrayEquals(expected, result.toArray());

    }
    
}
