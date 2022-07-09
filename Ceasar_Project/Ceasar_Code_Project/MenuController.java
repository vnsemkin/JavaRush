package Ceasar_Code_Project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuController
{
    private static final Character[] ALPHABET_RUS = {'А', 'а', 'Б', 'б', 'В', 'в', 'Г', 'г', 'Д', 'д', 'Е', 'е', 'Ё', 'ё', 'Ж', 'ж', 'З', 'з', 'И', 'и',
            'Й', 'й', 'К', 'к', 'Л', 'л', 'М', 'м', 'Н', 'н', 'О', 'о', 'П', 'п', 'Р', 'р', 'С', 'с', 'Т', 'т', 'У', 'у', 'Ф', 'ф', 'Х', 'х',
            'Ц', 'ц', 'Ч', 'ч', 'Ш', 'ш', 'Щ', 'щ', 'Ъ', 'ъ', 'Ы', 'ы', 'Ь', 'ь', 'Э', 'э', 'Ю', 'ю', 'Я', 'я',
            '.', ',', '"', '”', ':', '-', '!', '?', '_', ' ', '(', ')', ';', '@', '+', '#', '№',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    private static final List<Character> unencryptedFile = new ArrayList<>();
    private static final List<Character> encryptedDoc = new ArrayList<>();
    private static final List<Character> cyrillicTemplate = new ArrayList<>();
    private static void setCyrillicTemplate()
    {
        cyrillicTemplate.addAll(Arrays.asList(ALPHABET_RUS));
    }


    static void menuController(Scanner scanner)
    {
        while (true)
        {
            Menu.mainMenu();
            System.out.print("Выберите пункт меню :");
            int userSelectedMenuItem = UserInput.getUserInput(scanner);
        switch(userSelectedMenuItem)
        {
                case 0 ->
                {
                    System.out.println("<-----До свидания!----->");
                    System.exit(0);
                }
                case 1 -> ReadFile.fileReader(scanner, unencryptedFile);
                case 2 -> ReadFile.printFile(unencryptedFile);
                case 3 -> CesarCryptFile.cesarСipher(scanner,encryptedDoc,unencryptedFile,cyrillicTemplate);
                case 4 -> CesarCryptFile.printEncryptedDocument(encryptedDoc);
                case 5 -> WriteEncryptedFile.writeEncryptedFile(scanner, encryptedDoc);
                case 6 -> WriteEncryptedFile.readEncryptedFile(scanner,encryptedDoc);
                case 7 -> DecodeFile.cesarDecoder(scanner, encryptedDoc, cyrillicTemplate, unencryptedFile);
                case 8 -> BruteForceDecode.bruteForceDecode(unencryptedFile, cyrillicTemplate, encryptedDoc);
                case 9 -> System.out.println("Метод не реализован.");
                default -> System.out.println("Еще одна попытка. Сосредоточтесь");
            }
        }
    }

    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            setCyrillicTemplate();
            menuController(scanner);
        }
    }
}

