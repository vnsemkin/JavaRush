package BankIlia;
import java.util.Map;
import java.util.Set;

public class Authorization {
  static int checkUsers(Map<String, String> userLogin,
                        String login, String password)
  {
      Set<String> users = userLogin.keySet();
       if (users.size() != 0)
       {
           for (String user : users)
           {
               if (user.equals(login))
               {
                   if (userLogin.get(user).equals(password))
                   {
                       return 0;//authorized.
                   } else
                   {
                       return 1;//wrong password.
                   }
               }
           }
       }
       return 2;//not authorize
   }
}

