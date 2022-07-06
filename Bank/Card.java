package BankIlia;

public class Card
{
    CardType cardType = CardType.UNKNOWN;
    private long cardNumber = (long)(Math.random() * 999999999);
    private short cvv = (short)(100+(Math.random() * 900));
    long userId;
    private float money;
    boolean hasCard = false;
    Card(){}
    void createCard(long userId, CardType cardType)
    {
        Card card = new Card();
        this.cardType = cardType;
        this.userId = userId;
        this.hasCard = true;

    }

    void topUpCard(float money) {
            this.money = money;
        }

    public long getCardNumber() {
            return cardNumber;
        }

    public short getCvv() {
        return cvv;
    }
    public float getMoney() {
       return money;
       }
    public CardType getCardType()
    {
            return cardType;
    }

    public boolean isHasCard() {
        return hasCard;
    }
    void deposit(float money){
        this.money +=money;
    }
    void withdraw(float money){
        this.money -=money;
    }
}

