import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CesarCryptFile
{
    private static final ArrayList<Character> encryptedFile = new ArrayList<>();
    ArrayList<Character> cesarСipher(Scanner scanner,ArrayList<Character> unencryptedFile,
                                             ArrayList<Character> cyrillicTemplate)
    {
        int key = 0;
        try
        {
            System.out.print("Введите ключ :");
            key =Math.abs(scanner.nextInt());
        }catch (InputMismatchException e)
        {
            System.out.println("""
                        ____________________
                        Некорректный ключ!
                        Введите число!
                        ____________________
                        """);
            scanner.nextLine();
        }
        encryptedFile.clear();
        for (int i =0; i < unencryptedFile.size(); i++)
        {
            for (int j = 0; j < cyrillicTemplate.size(); j++)
            {
                if (unencryptedFile.get(i).equals(cyrillicTemplate.get(j)))
                {
                    encryptedFile.add(cyrillicTemplate.get((j + key) % 93));
                    continue;
                } else if (encryptedFile.size() == i && j+1 == cyrillicTemplate.size())
                {
                    encryptedFile.add(unencryptedFile.get(i));
                }
            }
        }
        if(!encryptedFile.isEmpty())
            System.out.println("<-----Документ успешно зашифрован----->");
        return encryptedFile;
    }
    void printEncryptedDocument(ArrayList<Character> encryptedFile)
    {
        System.out.println("<-----Encoded_Document----->");
        System.out.println();
        for (Character character:encryptedFile)
        {
            System.out.print(character);
        }
        System.out.println();
        System.out.println("<-----Encoded_Document----->");
    }
}
