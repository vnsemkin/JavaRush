package org.example.models;

import java.util.ArrayList;
import java.util.List;

/*
Client:
1. CardNumber : String +
2. BuyHistory : ArrayList +
3. Basket: ArrayList +
 */
public class Client
{
    String name;
    List<Good> basket ;
    String  cardNumber;
    List<Check> ordersHistory;
    public Client(String name, List<Good>basket, List<Check> ordersHistory){
        cardNumber = "5375 4141 1569 2423";
        this.name = name;
        this.basket = basket;
        this.ordersHistory = ordersHistory;
    }

    @Override
    public String toString() {
        return "Client{" +
                "\nname='" + name + '\'' +
                "\nbasket=" + basket +
                "\ncardNumber='" + cardNumber + '\'' +
                "\nordersHistory=" + ordersHistory +
                "\n"+ '}';
    }
}
