package BankIlia;

import java.util.Map;
import java.util.Set;

public class Registration
{
   static int registerNewUser(Map<String, String> userLogin,
                               String login, String password)
    {
        Set<String> users = userLogin.keySet();
        if (users.contains(login))
        {
            return 3;

        }
        else
        {
            LoginController.userLogin.put(login, password);
            return 4;
        }
    }
}
