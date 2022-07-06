import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteEncryptedFile
{

    private Path inputFilePath(Scanner scanner)
    {
        scanner.nextLine();
        System.out.print("Введите путь к файлу :");
        return Path.of(scanner.nextLine());
    }

    void writeEncryptedFile(Scanner scanner, ArrayList<Character> encryptedDoc)
    {
        try {
            Path outPath = inputFilePath(scanner);
            Files.createFile(outPath);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(outPath))))
            {
                for (Character character : encryptedDoc)
                {
                    bufferedWriter.write(character);
                    bufferedWriter.flush();
                }
                if (Files.exists(outPath) && Files.size(outPath) != 0)
                {
                    System.out.println("<----- Файл_Успешно_Создан----->");
                    System.out.println(outPath.toAbsolutePath());
                    System.out.println("--------------------------------");
                }
            } catch (IOException e)
            {
                System.out.println("<-----Ошибка_Записи_Файла!----->");
            }
        } catch (IOException e)
        {
            System.out.println("<-----Ошибка_Создания_Файла----->");
        }
    }

    void readEncryptedFile(Scanner scanner, ArrayList<Character> encryptedDoc)
    {
        Path outPath = inputFilePath(scanner);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(outPath))))
        {
            encryptedDoc.clear();
            while (bufferedReader.ready())
            {
                encryptedDoc.add((char) bufferedReader.read());
            }
            if (Files.exists(outPath) && encryptedDoc.size() != 0)
            {
                System.out.println("<------Файл_Успешно_Считан----->");
                System.out.println("<-------Файл для дешифровки----->");
                System.out.println(outPath.toAbsolutePath());
                System.out.println("---------------------------------");
            }
        } catch(FileNotFoundException e)
                {
                    System.out.println("<-----Файл_Не_Найден----->");
                } catch(IOException e){
                    System.out.println("<-----Ошибка_Чтения_Файла----->");
                }
            }

}
