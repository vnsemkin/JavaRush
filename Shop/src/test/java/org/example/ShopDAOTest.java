package org.example;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.example.dao.ShopDAO;
import org.example.models.Check;
import org.example.models.EmployeeType;
import org.example.models.Good;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class ShopDAOTest
{
    ShopDAO shopDAO;
    @Before
    public void initShopDAO()
    {
        shopDAO = new ShopDAO();
    }

    @Test
    public void addGoodTest()
    {
        System.out.println("!!!!!!!!!!!!!!ADD GOOD TEST!!!!!!!!!!!!!!!");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("goods.txt"))) {
            while (bufferedReader.ready()) {
                String str = (bufferedReader.readLine());
                String[] goods = str.split(",", 3);
                shopDAO.addGood(new Good(goods[0], Float.parseFloat(goods[1])), Integer.parseInt(goods[2]));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        printStore();
        int expectedSize = 6;
        int realSize = shopDAO.getShop().getStore().size();
        Assert.assertEquals(expectedSize, realSize);
    }


    @Test
    public void removeGoodTest()
    {
        System.out.println("!!!!!!!!!!!!!!REMOVE GOOD TEST!!!!!!!!!!!!!!!");
        Good apple = new Good("apple", 500F);


        // adding goods to shop
        shopDAO.addGood(apple, 100);

        printStore();
        System.out.println("=============Print before removing============");

        // removing good from shop
        boolean isRemoved = shopDAO.removeGood("apple");
        printStore();
        System.out.println("=============Print after removing============");


        assertTrue( isRemoved );
    }

    @Test
    public void findGoodTest()
    {
        Good apple = new Good("apple", 500F);

        // adding goods to shop
        shopDAO.addGood(apple, 100);

        Good result = shopDAO.findGood("apple");
        Assert.assertNotNull(result);

    }

    @Test
    public void addEmployee()
    {
        shopDAO.addEmployee("Anton", EmployeeType.CASHIER);
        assertTrue(shopDAO.getShop().getEmployees().containsKey("Anton"));
    }


    @Test
    public void createCheckTest()
    {
        System.out.println("========Add goods========");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("goods.txt"))) {
            while (bufferedReader.ready()) {
                String str = (bufferedReader.readLine());
                String[] goods = str.split(",", 3);
                shopDAO.addGood(new Good(goods[0], Float.parseFloat(goods[1])), Integer.parseInt(goods[2]));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        assertNotNull(shopDAO.showGoods());
        System.out.println("Goods added to shop successfully");


        //Print goods in the shop
        System.out.println("========Show Goods========");
        HashMap<Good, Integer> goodsHashMap = shopDAO.showGoods();
        for(Map.Entry<Good, Integer> product : goodsHashMap.entrySet())
        {
            System.out.println("Name= " + product.getKey().getProductName()
                    + ", price= " + product.getKey().getPrice()
                    + ", amount= " + product.getValue());
        }

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

        Check check = shopDAO.createCheck(basket, "Anton");
        System.out.println("============Check Output=========");
        System.out.print("Goods in basket :" );
        for(Map.Entry<Good, Integer> product : check.getGoodList().entrySet()) {
            System.out.print(
                    "\nProduct: " + product.getKey().getProductName()
                    +"\nPrice: " + product.getKey().getPrice()
                    +"\nAmount: " + product.getValue());
        }
        System.out.println("\nCashier " + check.getCashier()
                +"\nTime " + check.getSellTime()
                +"\nThank you for purchase. See you later!");
        Assert.assertNotNull(shopDAO.createCheck(basket, "Anton"));
    }

    @Test
    public void removeGoodByAmount()
    {
        System.out.println("!!!!!!!!!!!!!!REMOVE GOOD TEST!!!!!!!!!!!!!!!");
        Good apple = new Good("apple", 500F);


        // adding goods to shop
        shopDAO.addGood(apple, 100);

        printStore();
        System.out.println("=============Print before removing============");

        // removing good from shop
        boolean isRemoved = shopDAO.removeGood("apple", 50);
        printStore();
        System.out.println("=============Print after removing============");


        assertTrue( isRemoved );

    }


    public void printStore()
    {

        HashMap<Good, Integer> hashMap = shopDAO.showGoods();
        System.out.println(hashMap);
        Assert.assertNotEquals(null, hashMap);
    }



}
