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
    String name;

    public Client(Map<Good, Integer> basket, String name, Float cash, List<Check> ordersHistory) {
        this.basket = basket;
        this.name = name;
        this.cash = cash;
        this.ordersHistory = ordersHistory;
    }

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

    @Override
    public String toString() {
        return "Client{" +
                "basket=" + basket +
                ", name='" + name + '\'' +
                ", cash=" + cash +
                ", ordersHistory=" + ordersHistory +
                '}';
    }
}
