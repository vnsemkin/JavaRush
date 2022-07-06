//Methods for ArrayList
import java.util.ArrayList;

public class ArrayListTest {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static long createArrayList(int size)
    {
        long initialTime = System.nanoTime();
        for (int i = 0; i < size; i++)
        {
            arrayList.add((int)(Math.random() * 100000));
        }
        return System.nanoTime() - initialTime;
    }
    long addElementToStartArrayList()
    {
        long initialTime = System.nanoTime();
        arrayList.add(0,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }
    long addElementToEndArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.add(size,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }
    long addElementToMiddleOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.add(size/2 ,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }
    long getElementFromMiddleOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.get(size/2);
        return System.nanoTime() - initialTime;
    }

    long getElementFromStartOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.get(0);
        return System.nanoTime() - initialTime;
    }

    long getElementFromEndOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.get(size);
        return System.nanoTime() - initialTime;
    }
    long setElementToMiddleOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.set(size/2,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }

    long setElementToStartOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.set(0,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }

    long setElementToEndOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.set(size,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }

    long removeElementToMiddleOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.remove(size / 2);
        return System.nanoTime() - initialTime;
    }

    long removeElementToStartOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.remove(0);
        return System.nanoTime() - initialTime;
    }

    long removeElementToEndOfArrayList(int size)
    {
        long initialTime = System.nanoTime();
        arrayList.remove(size);
        return System.nanoTime() - initialTime;
    }

    long containsElementInArrayList()
    {
        int el = 155200;
        arrayList.add(el);
        long listInitialTime = System.nanoTime();
        if (arrayList.contains(el))
            return System.nanoTime() - listInitialTime;
        else
            return System.nanoTime() - listInitialTime;
    }
}
