package BankIlia;

import java.util.Scanner;

public class User
{
    private Info info;
    private Card card;
    long id = (long)(Math.random() * 999999999);
    User(){}

    public Info getInfo() {
        return info;
    }

    public Card getCard() {
        return card;
    }


    public long getId() {
        return id;
    }

    void setUserInfo(Scanner scanner)
    {
        info = new Info();
        info.setInfo(scanner);
    }
    void setUserCard(long id, CardType cardType)
    {
        card = new Card();
        card.createCard(id, cardType);
    }

    void setTopUpCard(float money){
        card.topUpCard(money);
    }

   void deposit(float money){
        card.deposit(money);
   }
    void withdraw(float money){
        card.withdraw(money);
    }
}
