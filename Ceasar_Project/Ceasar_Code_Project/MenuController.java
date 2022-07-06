import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MenuController
{
    private static final Character[] ALPHABET_RUS = {'А', 'а', 'Б', 'б', 'В', 'в', 'Г', 'г', 'Д', 'д', 'Е', 'е', 'Ё', 'ё', 'Ж', 'ж', 'З', 'з', 'И', 'и',
            'Й', 'й', 'К', 'к', 'Л', 'л', 'М', 'м', 'Н', 'н', 'О', 'о', 'П', 'п', 'Р', 'р', 'С', 'с', 'Т', 'т', 'У', 'у', 'Ф', 'ф', 'Х', 'х',
            'Ц', 'ц', 'Ч', 'ч', 'Ш', 'ш', 'Щ', 'щ', 'Ъ', 'ъ', 'Ы', 'ы', 'Ь', 'ь', 'Э', 'э', 'Ю', 'ю', 'Я', 'я',
            '.', ',', '"', '”', ':', '-', '!', '?', '_', ' ', '(', ')', ';', '@', '+', '#', '№',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private static final UserInput userInput = new UserInput();
    private static final Menu menu = new Menu();
    private static final ReadFile readFile = new ReadFile();
    private static final WriteEncryptedFile writeEncryptedFile = new WriteEncryptedFile();
    private static final DecodeFile decodeFile = new DecodeFile();
    private static final BruteForceDecode bruteForceDecode = new BruteForceDecode();
    private static final CesarCryptFile cesarCryptFile = new CesarCryptFile();

    private static ArrayList<Character> unencryptedFile = new ArrayList<>();
    private static ArrayList<Character> encryptedDoc = new ArrayList<>();
    private static final ArrayList<Character> cyrillicTemplate = new ArrayList<>();
    private static void setCyrillicTemplate(){
        cyrillicTemplate.addAll(Arrays.asList(ALPHABET_RUS));
    }


    static void menuController(Scanner scanner)
    {
        boolean isExit = false;
        while (!isExit)
        {
            menu.mainMenu();
            System.out.print("Выберите пункт меню :");
            int userSelectedMenuItem = userInput.getUserInput(scanner);
        switch(userSelectedMenuItem)
        {
                case 0 -> {System.out.println("<-----До свидания!----->");
                        isExit = true ;}
                case 1 -> unencryptedFile = readFile.fileReader(scanner, unencryptedFile);
                case 2 -> readFile.printFile(unencryptedFile);
                case 3 -> encryptedDoc = cesarCryptFile.cesarСipher(scanner,unencryptedFile,cyrillicTemplate);
                case 4 -> cesarCryptFile.printEncryptedDocument(encryptedDoc);
                case 5 -> writeEncryptedFile.writeEncryptedFile(scanner, encryptedDoc);
                case 6 -> writeEncryptedFile.readEncryptedFile(scanner,encryptedDoc);
                case 7 -> unencryptedFile = decodeFile.cesarDecoder(scanner, encryptedDoc, cyrillicTemplate,unencryptedFile);
                case 8 -> unencryptedFile = bruteForceDecode.bruteForceDecode(unencryptedFile,cyrillicTemplate,encryptedDoc);
                case 9 -> System.out.println("Выбран пункт 9");
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

