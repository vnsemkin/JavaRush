package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Client:
1. CardNumber : String
2. BuyHistory : ArrayListy
3. Backet : ArrayList
 */
public class Client
{

    Map<Good, Integer> basket = new HashMap<>();

    Float cash;
    List<Check> ordersHistory = new ArrayList<>();

    public Float getCash() {
        return cash;
    }


    public Map<Good, Integer> getBasket() {
        return basket;
    }


    public List<Check> getOrdersHistory() {
        return ordersHistory;
    }

    public Client(Float cash) {
        this.cash = cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }
}
