package Ceasar_Code_Project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput
{
    private static int userInput = -1;
    private static int userInput(Scanner scanner)
    {
            try
            {
                userInput = scanner.nextInt();
                if (userInput < 0 || userInput > 9)
                {
                    System.out.println("""
                            <-------------------->
                             Нет такого пункта меню!
                            <-------------------->
                            """);
                }
            } catch (InputMismatchException e)
            {
                System.out.println("""
                        \n<-------------------->
                        Некорректный ввод!
                        Введите число!
                        <-------------------->
                        """);
                scanner.next();
            }
        return userInput;
    }

    public static int getUserInput(Scanner scanner)
    {
        return userInput(scanner);
    }
}
