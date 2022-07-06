package BankIlia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    CardType cardType;
    private static Bank INSTANCE;
    List<User> users = new ArrayList<>();
    short userCounter = 0;
    //Create private constructor for Singleton.
    private Bank(){}
    //Create Singleton object.
    public static Bank getBank()
    {
        if(INSTANCE == null)
            INSTANCE = new Bank();
        return INSTANCE;
    }

    public void addUser(Scanner scanner)
    {
            User user = new User();
            user.setUserInfo(scanner);
            users.add(user);
            if (users.get(userCounter) != null)
            {
                System.out.println("<-----User_Added----->");
                userCounter++;
            }
    }

    public void getUser()
    {
        int count = 0;
        System.out.println("Found : " + userCounter + " users");
        for (User user : users)
        {
            if (user != null)
            {
                count++;
                long cardNumber;
               try
               {
                   cardNumber = user.getCard().getCardNumber();
               }
               catch (NullPointerException e)
               {
                   cardNumber = -1;
               }
                try
                {
                    cardType = user.getCard().getCardType();
                }
                catch (NullPointerException e)
                {
                    cardType = CardType.UNKNOWN;
                }
                float moneyAmount;
                try
                {
                    moneyAmount = user.getCard().getMoney();
                }
                catch (NullPointerException e)
                {
                    moneyAmount = 0;
                }
                boolean hasCard;
                try
                {
                    hasCard = user.getCard().isHasCard();
                }
                catch (NullPointerException e)
                {
                    hasCard = false;
                }
                System.out.println("#####################");
                System.out.println(count + ") user : ");
                System.out.print("Name = " + user.getInfo().getName() + " ; "
                        +  "\nSurname = " + user.getInfo().getSurname() + " ; "
                        +  "\nCity = " + user.getInfo().getAddress().getCity() + " ; "
                        +  "\nStreet = " + user.getInfo().getAddress().getStreet() + " ; "
                        +  "\nBuilding = " + user.getInfo().getAddress().getBuilding() + " ; "
                        +  "\nFlat = " + user.getInfo().getAddress().getFlat() + " ; "
                        +  "\nuserId = " + user.getId() + " ; "
                        +  "\nCard Type = " + cardType + " ; "
                        +  "\nCard Number = " + cardNumber + " ; "
                        +  "\nMoney = " + moneyAmount + " ; "
                        +  "\nHas user card = " + hasCard + " ; ");
                System.out.println("\n######################");
            }
        }
    }

    public void getUserById(Scanner scanner)
    {
        System.out.print("Input id :");
        long userId = scanner.nextLong();
        for (User user : users) {
            if (user != null && userId == user.getId())
            {
                System.out.println("Id = " + userId
                        + "\n" + "belongs to "
                        + "\n" + "Name = " + user.getInfo().getName() + "\n");
            }
        }

    }

    void createUserCard(Scanner scanner)
    {
        System.out.print("Input username :");
        String userName = scanner.next();
        System.out.println("Input card type you want : " + "\n 1 "+CardType.GOLD
                +"\n 2 " + CardType.SILVER
                +"\n 3 " + CardType.BRONZE);
        System.out.print("Input your choice: ");
        switch(scanner.nextInt())
        {
            case 1 -> cardType = CardType.GOLD;
            case 2 -> cardType = CardType.SILVER;
            case 3 -> cardType = CardType.BRONZE;
        }
        for (User user : users) {
            boolean card;
            try
            {
                card = user.getCard().isHasCard();
            }
            catch (NullPointerException e)
            {
                card = false;
            }
            if (user != null && userName.equals(user.getInfo().getName()) && !card) {
                long id = user.getId();
                user.setUserCard(id, cardType);
                System.out.println();
                System.out.println("User = " + user.getInfo().getName()
                        +"\n" + "just got " + user.getCard().getCardType() + " card"
                        +"\n" + "Card number is = " + user.getCard().getCardNumber()
                        +"\n" + "cvv " + user.getCard().getCvv()
                        +"\n" + "money " + user.getCard().getMoney());
            } else if (user != null && userName.equals(user.getInfo().getName()) && card) {
                System.out.println("You already have the card");
            }

        }
    }

    void setTopUpCard(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Input username :");
        String userName = scanner.nextLine();
        System.out.print("Input money amount : ");
        float moneyAmount = scanner.nextFloat();
        for (User user : users) {
            if (user != null && userName.equals(user.getInfo().getName())) {
                long id = user.getId();
                user.setTopUpCard(moneyAmount);
                System.out.println("You : " + user.getInfo().getName() + "\n" + "just top up card Number "
                        + user.getCard().getCardNumber()
                        + " by " + user.getCard().getMoney());
            }
        }
    }
    void transferMoney(Scanner scanner){
        scanner.nextLine();
        System.out.print("Input  your name : ");
        String me = scanner.nextLine();
        System.out.print("Input  friend name : ");
        String friend = scanner.nextLine();
        System.out.print("Input money amount : ");
        float transferMoney = scanner.nextFloat();
        for(User user:users){
            if(user != null && friend.equals(user.getInfo().getName())){
                user.deposit(transferMoney);
            } else if (user != null && me.equals(user.getInfo().getName())) {
                user.withdraw(transferMoney);
            }
        }
    }
}



