import java.util.HashSet;

public class HashSetTest {

    HashSet<Integer> hashSet = new HashSet<>();
    long createHashSet(int size)
    {
        long listInitialTime = System.nanoTime();
        for (int i = 0; i < size; i++)
        {
            hashSet.add((int)(Math.random() * 100000));
        }
        return System.nanoTime() - listInitialTime;
    }

    long containsElementInHashSet()
    {
        int el = 155200;
        hashSet.add(el);
        long listInitialTime = System.nanoTime();
        if (hashSet.contains(el))
            return System.nanoTime() - listInitialTime;
        else
            return System.nanoTime() - listInitialTime;
    }


}
