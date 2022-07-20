package org.example.controllers;
import org.example.dao.ClientDAO;
import org.example.dao.ShopDAO;
import org.example.models.Check;
import org.example.models.Client;
import org.example.models.Good;
import java.io.*;
import java.util.*;

public class ClientController {

    public static void main(String[] args) {
        clientBuy();
    }
    public static void clientBuy() {
        String name = "Anton";
        Client client = new Client(12500F);
        ClientDAO clientDAO = new ClientDAO(client);
        ShopDAO shopDAO = new ShopDAO();
        //Read goods from file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("goods.txt"))) {
            while (bufferedReader.ready()) {
                String str = (bufferedReader.readLine());
                String[] goods = str.split(",", 3);
                shopDAO.addGood(new Good(goods[0], Float.parseFloat(goods[1])), Integer.parseInt(goods[2]));
            }
        } catch (IOException e) {
           e.getMessage();
        }
        //Print goods in the shop
        System.out.println("========Show Goods========");
        HashMap<Good, Integer> goodsHashMap = shopDAO.showGoods();
        for(Map.Entry<Good, Integer> product : goodsHashMap.entrySet())
        {
            System.out.println("Name= " + product.getKey().getProductName()
                    + ", price= " + product.getKey().getPrice()
                    + ", amount= " + product.getValue());
        }

        // Достаем из базы корзину покупателя
        Map<Good, Integer> clientBasket = clientDAO.getClient().getBasket();


        Set<Map.Entry<Good, Integer>> clientBasketEntrySet = clientBasket.entrySet();


        // Создаем корзину покупок и уменьшаем количество товара на  складе
        Map<Good, Integer> basket = new HashMap<>();
        for(Map.Entry<Good, Integer> product : goodsHashMap.entrySet())
        {
            switch (product.getKey().getProductName()) {
                case "cheese":
                    basket.put(product.getKey(), 5);
                    goodsHashMap.put(product.getKey(), product.getValue() - 5);
                    break;
                case "apple":
                    basket.put(product.getKey(), 15);
                    goodsHashMap.put(product.getKey(), product.getValue() - 15);
                    break;
                case "chicken":
                    basket.put(product.getKey(), 3);
                    goodsHashMap.put(product.getKey(), product.getValue() - 3);
                    break;
            }

        }
        //Выводим чек покупателю
        Check check = shopDAO.createCheck(basket, "Anton");
        System.out.println("============Check Output=========");
        System.out.print("Goods in basket :" );
        for(Map.Entry<Good, Integer> product : check.getGoodList().entrySet()) {
            System.out.print(
                    "\nProduct: " + product.getKey().getProductName()
                            +"\nPrice: " + product.getKey().getPrice()
                            +"\nAmount: " + product.getValue());
        }
        System.out.println("\nCashier: " + check.getCashier()
                +"\nTime " + check.getSellTime()
                +"\nThank you for purchase. See you later!");
        //Записываем чек в файл
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("clientsCheck.txt")))
        {
            for(Map.Entry<Good, Integer> product : check.getGoodList().entrySet())
            {
                bufferedWriter.write(product.getKey().getProductName()
                        + "," + product.getKey().getPrice()
                        + "," + product.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.write(check.getCashier());
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(check.getSellTime()));
        } catch (IOException e) {
            e.getMessage();
        }
        // Перекидываем деньги от клиента магазину
        shopDAO.addCash(clientDAO.removeCash());
        // Передаем чек клиенту
        clientDAO.addCheck(check);
    }

}