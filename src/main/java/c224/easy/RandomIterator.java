package c224.easy;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class RandomIterator<T> implements Iterator<T>
{

    private final T[] array;
    private final Random random;
    private int current = 0;

    public RandomIterator(T[] toIterate)
    {
        array = Arrays.copyOf(toIterate, toIterate.length);
        random = new Random();
    }

    public RandomIterator(T[] toIterate, int seed)
    {
        array = Arrays.copyOf(toIterate, toIterate.length);
        random = new Random(seed);
    }


    @Override
    public boolean hasNext() 
    {
        return current < array.length;
    }

    @Override
    public T next() 
    {
        if (!hasNext())
        {
            throw new IndexOutOfBoundsException();
        }
        
        int nextIndex = randomIndex();
        T nextValue = array[nextIndex];
        T atCurrentIndex = array[current];
        array[nextIndex] = atCurrentIndex;
        array[current] = nextValue;
        current++;
        
        return nextValue;
    }

    @Override
    public void remove() 
    {
        throw new NotImplementedException();
    }
    
    private int randomIndex()
    {
        int upperBound = (array.length - current);
        return random.nextInt(upperBound) + current;
    }
}
