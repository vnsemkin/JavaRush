//I do not use getters and setters. I am lazy);.../
public class Main
{
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    static MenuLists menu = new MenuLists();
    static LinkedListTest linkedListTest = new LinkedListTest();
    static ArrayListTest arrayListTest = new ArrayListTest();

    static HashSetTest hashSetTest = new HashSetTest();

    public static void main(String[] args)
    {
        int size = menu.menu();
        System.out.println("<-----List_Size----->");
        System.out.println(size);
        System.out.println("<-----Time_to_create_LinkedList_Vs_ArrayList_Vs_HashSet---->");
        System.out.println("LinkedList -> :"+linkedListTest.createLinkedList(size) + " ns"
                + "\n ArrayList -> :" + ArrayListTest.createArrayList(size) + " ns"
                + "\n HashSet  ->  :" + hashSetTest.createHashSet(size) + " ns");
        if (linkedListTest.createLinkedList(size)>ArrayListTest.createArrayList(size)
            && linkedListTest.createLinkedList(size)> hashSetTest.createHashSet(size))
            System.out.println(YELLOW + "LinkedList is slower than ArrayList and HashSet" + RESET);
        else if (linkedListTest.createLinkedList(size)>ArrayListTest.createArrayList(size)
                && linkedListTest.createLinkedList(size)<hashSetTest.createHashSet(size))
            System.out.println(YELLOW + "LinkedList is faster than HashSet, bun is slower than ArrayList" + RESET);
        else if (linkedListTest.createLinkedList(size)<ArrayListTest.createArrayList(size)
                && linkedListTest.createLinkedList(size)>hashSetTest.createHashSet(size))
            System.out.printf(YELLOW + "LinkedList is faster than ArrayList, bun is slower than HashSet" + RESET);
        else System.out.println(YELLOW + "LinkedList is faster than ArrayList and HashSet" + RESET);


        System.out.println("<-----Time_to_Add_First_Element_To_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.addElementToStartLinkedList() + " ns"
                + "\n ArrayList -> :" + arrayListTest.addElementToStartArrayList() + " ns");
        if (linkedListTest.addElementToStartLinkedList()>arrayListTest.addElementToStartArrayList())
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("\n<-----Time_to_Add_Last_Element_To_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.addElementToEndLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.addElementToEndArrayList(size) + " ns");
        if (linkedListTest.addElementToEndLinkedList(size)>arrayListTest.addElementToEndArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Add_Element_To_Middle_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.addElementToMiddleOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.addElementToMiddleOfArrayList(size) + " ns");
        if (linkedListTest.addElementToMiddleOfLinkedList(size)>arrayListTest.addElementToMiddleOfArrayList(size))
        System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Get_Element_From_Middle_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.getElementFromMiddleOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.getElementFromMiddleOfArrayList(size) + " ns");
        if (linkedListTest.getElementFromMiddleOfLinkedList(size)>arrayListTest.getElementFromMiddleOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Get_Element_From_Start_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.getElementFromStartOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.getElementFromStartOfArrayList(size) + " ns");
        if (linkedListTest.getElementFromStartOfLinkedList(size)>arrayListTest.getElementFromStartOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Get_Element_From_End_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.getElementFromEndOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.getElementFromEndOfArrayList(size) + " ns");
        if (linkedListTest.getElementFromEndOfLinkedList(size)>arrayListTest.getElementFromEndOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Set_Element_To_Middle_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.setElementToMiddleOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.setElementToMiddleOfArrayList(size) + " ns");
        if (linkedListTest.setElementToMiddleOfLinkedList(size)>arrayListTest.setElementToMiddleOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Set_Element_To_Start_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.setElementToStartOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.setElementToStartOfArrayList(size) + " ns");
        if (linkedListTest.setElementToStartOfLinkedList(size)>arrayListTest.setElementToStartOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Set_Element_To_Middle_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.setElementToEndOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.setElementToEndOfArrayList(size) + " ns");
        if (linkedListTest.setElementToEndOfLinkedList(size)>arrayListTest.setElementToEndOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Remove_Element_To_Middle_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.removeElementToMiddleOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.removeElementToMiddleOfArrayList(size) + " ns");
        if (linkedListTest.removeElementToMiddleOfLinkedList(size)>arrayListTest.removeElementToMiddleOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Remove_Element_To_Start_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.removeElementToStartOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.removeElementToStartOfArrayList(size) + " ns");
        if (linkedListTest.removeElementToStartOfLinkedList(size)>arrayListTest.removeElementToStartOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Remove_Element_To_End_Of_LinkedList_Vs_ArrayList----->");
        System.out.println("LinkedList -> :"+linkedListTest.removeElementToEndOfLinkedList(size) + " ns"
                + "\n ArrayList -> :" + arrayListTest.removeElementToEndOfArrayList(size) + " ns");
        if (linkedListTest.removeElementToEndOfLinkedList(size)>arrayListTest.removeElementToEndOfArrayList(size))
            System.out.println(YELLOW + "LinkedList is slower" + RESET);
        else System.out.printf(YELLOW + "LinkedList is faster" + RESET);


        System.out.println("<-----Time_to_Check_of_contains_Element_Of_LinkedList_Vs_ArrayList_Vs_HashSet----->");
        System.out.println("LinkedList -> :"+linkedListTest.containsElementInLinkedList() + " ns"
                + "\n ArrayList -> :" + arrayListTest.containsElementInArrayList() + " ns"
                + "\n HashSet  ->  :" + hashSetTest.containsElementInHashSet() + " ns");
        if (linkedListTest.containsElementInLinkedList()>arrayListTest.containsElementInArrayList()
                && linkedListTest.containsElementInLinkedList()> hashSetTest.containsElementInHashSet())
            System.out.println(YELLOW + "LinkedList is slower than ArrayList and HashSet" + RESET);
        else if (linkedListTest.containsElementInLinkedList()>arrayListTest.containsElementInArrayList()
                && linkedListTest.containsElementInLinkedList()<hashSetTest.containsElementInHashSet())
            System.out.printf(YELLOW + "LinkedList is faster than HashSet, bun is slower than ArrayList" + RESET);
        else if (linkedListTest.containsElementInLinkedList()<arrayListTest.containsElementInArrayList()
                && linkedListTest.containsElementInLinkedList()>hashSetTest.containsElementInHashSet())
            System.out.printf(YELLOW + "LinkedList is faster than ArrayList, bun is slower than HashSet" + RESET);
        else System.out.println(YELLOW + "LinkedList is faster than ArrayList and HashSet" + RESET);

    }
}



