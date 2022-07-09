package Ceasar_Code_Project;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CesarCryptFile
{
    static int key ;
    static void cesarСipher(Scanner scanner,
                            List<Character> encryptedDoc,
                            List<Character> unencryptedFile,
                            List<Character> cyrillicTemplate)
    {
        boolean isExit = false;
        while(!isExit) {
            try {
                System.out.print("Введите ключ :");
                key = Math.abs(scanner.nextInt());
                isExit = true;
            } catch (InputMismatchException e) {
                System.out.println("""
                        ____________________
                        Некорректный ключ!
                        Введите число!
                        ____________________
                        """);
                scanner.nextLine();
            }
        }
        encryptedDoc.clear();
        for (int i =0; i < unencryptedFile.size(); i++)
        {
            for (int j = 0; j < cyrillicTemplate.size(); j++)
            {
                if (unencryptedFile.get(i).equals(cyrillicTemplate.get(j)))
                {
                    encryptedDoc.add(cyrillicTemplate.get((j + key) % 93));
                    //if char don't find
                } else if (encryptedDoc.size() == i && j+1 == cyrillicTemplate.size())
                {
                    encryptedDoc.add(unencryptedFile.get(i));
                }
            }
        }
        if(!encryptedDoc.isEmpty())
            System.out.println("<-----Документ успешно зашифрован----->");
    }
    static void printEncryptedDocument(List<Character> encryptedFile)
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
