//Methods for LinkedList
import java.util.LinkedList;

public class LinkedListTest
{
    LinkedList<Integer> linkedList = new LinkedList<>();
    long createLinkedList(int size)
    {
        long listInitialTime = System.nanoTime();
        for (int i = 0; i < size; i++)
        {
            linkedList.add((int)(Math.random() * 100000));
        }
        return System.nanoTime() - listInitialTime;
    }
    long addElementToStartLinkedList()
    {
        long initialTime = System.nanoTime();
        linkedList.add(0,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }
    long addElementToEndLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.add(size,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }
    long addElementToMiddleOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.add(size/2 ,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }
    long getElementFromMiddleOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.get(size/2);
        return System.nanoTime() - initialTime;
    }

    long getElementFromStartOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.get(0);
        return System.nanoTime() - initialTime;
    }

    long getElementFromEndOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.get(size);
        return System.nanoTime() - initialTime;
    }
    long setElementToMiddleOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.set(size/2,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }

    long setElementToStartOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.set(0,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }

    long setElementToEndOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.set(size,(int)(Math.random() * 100000));
        return System.nanoTime() - initialTime;
    }

    long removeElementToMiddleOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.remove(size / 2);
        return System.nanoTime() - initialTime;
    }

    long removeElementToStartOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.remove(0);
        return System.nanoTime() - initialTime;
    }

    long removeElementToEndOfLinkedList(int size)
    {
        long initialTime = System.nanoTime();
        linkedList.remove(size);
        return System.nanoTime() - initialTime;
    }

    long containsElementInLinkedList()
    {
        int el = 155200;
        linkedList.add(el);
        long listInitialTime = System.nanoTime();
        if (linkedList.contains(el))
            return System.nanoTime() - listInitialTime;
        else
            return System.nanoTime() - listInitialTime;
    }
}
