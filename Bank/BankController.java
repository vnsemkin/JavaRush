package BankIlia;

import java.util.Scanner;

public class BankController {
    static Scanner scanner = new Scanner(System.in);
    static BankMenu bankMenu = new BankMenu();
    static boolean isAuthorization = false;

    public static void main(String[] args)
    {
        while (!isAuthorization)
        {
            isAuthorization = LoginController.isLogin();
        }
        //Create Singleton bank.
        var bank = Bank.getBank();
        while(true) {
            bankMenu.bankMenu();
            int userInput = scanner.nextInt();
            switch (userInput)
            {
                case 0 ->
                {
                    System.out.println("Goodbye");
                    scanner.close();
                    return;
                }
                case 1 -> bank.addUser(scanner);
                case 2 -> bank.getUser();
                case 3 -> bank.getUserById(scanner);
                case 4 -> bank.createUserCard(scanner);
                case 5 -> bank.setTopUpCard(scanner);
                case 6 -> bank.transferMoney(scanner);
            }
        }
    }
}
