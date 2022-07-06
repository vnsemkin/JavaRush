package BankIlia;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import static BankIlia.BankController.scanner;

public class LoginController
{
    static Map<String, String> userLogin = new HashMap();
    static String login;
    static String password;
    static int isAuthorization;
    static int loginCount = 0;

    static void userInput(Scanner scanner)
    {
        System.out.print("Input login :");
        login = scanner.next();
        System.out.print("Input password :");
        password = scanner.next();
        loginCount ++;
    }

    static int loginMenu(Scanner scanner) {
        while (true) {
            try {
                System.out.println("#####Welcome to Bank#####");
                System.out.println("1 - to Login to account" +
                        "\n2 - for Register");
                System.out.print("Make your choice:");
                int userInputLoginMenu = scanner.nextInt();
                if(userInputLoginMenu == 1)
                {
                    return 1;
                }
                else if(userInputLoginMenu == 2)
                {
                   return 2;
                }
                else
                System.out.println("Input 1 to Login" +
                        "\nInput 2 to Register");
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Wrong input!");
            }
        }
    }

    static boolean isLogin() {
        switch (isAuthorization = loginControl()) {
            case 0 ->
            {
                System.out.println();
                System.out.println("Success Authorization!");
                System.out.println("#####Welcome to Bank#####");
                return true;
            }
            case 1 ->
            {
                System.out.println("#####Wrong password#####");
                return false;
            }
            case 2 ->
            {
                System.out.println();
                System.out.println("<-----User_Not_Found----->");
                System.out.println("<--You have to Registration-->");
                System.out.println();
                return false;
            }
            case 3 ->
            {
                System.out.println("You are registered already! Please Login!");
                return false;
            }
            case 4 ->
            {
                System.out.println("<-----User_Have_Been_Registered----->");
                return false;
            }
        }
        return false;
    }

    static int loginControl(){
        int result = -1;
        int isUserLoginOrRegistration = loginMenu(scanner);
        if(isUserLoginOrRegistration == 1)
        {
            if(loginCount < 3)
            {
                System.out.println("#####################");
                System.out.println("You have " + (3 - loginCount) + " attempts to login!");
                System.out.println("#####################");
                userInput(scanner);
                result = Authorization.checkUsers(userLogin, login, password);
            }
            else
            {
                System.out.println("####################");
                System.out.println("Number of attempts exceeded");
                System.exit(0);
            }
        }
        if(isUserLoginOrRegistration == 2)
        {
            userInput(scanner);
            result = Registration.registerNewUser(userLogin, login, password);
            loginCount = 0;
        }
        return result;
    }

}