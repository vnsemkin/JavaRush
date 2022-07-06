import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput
{
    private int userInput = -1;
    private int userInput(Scanner scanner)
    {
            try
            {
                userInput = scanner.nextInt();
                if (userInput < 0 || userInput > 9)
                {
                    System.out.println("""
                            <-------------------->
                             Некорректный ввод!
                             Нет такого пункта меню!
                            <-------------------->
                            """);
                }
            } catch (InputMismatchException e)
            {
                System.out.println("""
                        <-------------------->
                        Некорректный ввод!
                        Введите число!
                        <-------------------->
                        """);
                scanner.nextLine();
            }
        return userInput;
    }

    public int getUserInput(Scanner scanner)
    {
        return userInput(scanner);
    }
}
