import java.util.ArrayList;

public class BruteForceDecode
{
     ArrayList<Character> bruteForceDecode(ArrayList<Character> unencryptedFile
            , ArrayList<Character> cyrillicTemplate
            , ArrayList<Character> encryptedDoc)
     {
        for (int key = 0; key < cyrillicTemplate.size(); key++)
        {
            unencryptedFile.clear();
            for (int i = 0; i < encryptedDoc.size(); i++)
            {
                for (int j = 0; j < cyrillicTemplate.size(); j++)
                {
                    if (encryptedDoc.get(i).equals(cyrillicTemplate.get(j)))
                    {
                        int offset = j - key;
                        unencryptedFile.add(cyrillicTemplate.get(((offset % 93) + 93) % 93));
                    } else if (unencryptedFile.size() == i && j + 1 == cyrillicTemplate.size())
                    {
                        unencryptedFile.add(encryptedDoc.get(i));
                    }
                }
            }
            for (int x = 0, y = 1; y < unencryptedFile.size(); x++, y++)
            {
                if (unencryptedFile.get(x).equals(',')
                        && unencryptedFile.get(y).equals(' ')
                        && (unencryptedFile.get(unencryptedFile.size() - 1).equals('.')
                        || unencryptedFile.get(unencryptedFile.size() - 1).equals('!')
                        || unencryptedFile.get(unencryptedFile.size() - 1).equals('?')))
                {
                    System.out.println();
                    System.out.println("<-----Code_Key :" + key + "----->");
                    for (Character character : unencryptedFile)
                    {
                        System.out.print(character);
                    }
                    break;
                }
            }
        }
        return unencryptedFile;
    }
}
