import java.util.InputMismatchException;
import java.util.Scanner;

 class MenuLists {
    Scanner scanner = new Scanner(System.in);
    Integer size;
    public int menu() {
        try
        {
            System.out.print("Input size of testing array : ");
            size = Math.abs(scanner.nextInt());
            if(size > 10000000 )
            {
                System.out.println("Too much for compare");
                menu();
            }
        } catch (InputMismatchException e)
        {
            System.out.println("Input number");
            scanner.nextLine();
             menu();
        }finally {
            scanner.close();
        }
        return size;
    }
}

