import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    ArrayList<Character> fileReader(Scanner scanner, ArrayList<Character> unencryptedFile)
    {
        boolean successReadingFile = true;
        Path path = null;
            try {
                unencryptedFile.clear();
                scanner.nextLine();
                System.out.print("Введите путь к файлу :");
                path = Path.of(scanner.nextLine());
                BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(path)));
                while (bufferedReader.ready())
                {
                    unencryptedFile.add((char) bufferedReader.read());
                }
            } catch (FileNotFoundException e)
            {
                System.out.println("<------Файл_Не_Найден!----->");
                System.out.println(path.toAbsolutePath());
                successReadingFile = false;
            } catch (IOException e)
            {
                System.out.println("<-----Ошибка_Чтения_Файла!----->");
                successReadingFile = false;
            }
            if (successReadingFile && unencryptedFile.size() != 0)
            {
                System.out.println("<-----Файл_Успешно_Считан----->!");
            }
        return unencryptedFile;
    }
    void printFile(ArrayList<Character> unencryptedFile)
    {
        if(unencryptedFile.size() == 0)
        {
            System.out.println("<-----Файл_Не_Считан!----->");
        }else
        {
            System.out.println("<------Незашифрованный_Файл----->");
            for (Character character : unencryptedFile)
            {
                System.out.print(character);
            }
        }
        System.out.print("\n---------------------------------------\n");
    }
}
