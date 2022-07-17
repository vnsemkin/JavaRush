package org.example;

import static org.junit.Assert.assertTrue;

import org.example.dao.ShopDAO;
import org.example.models.EmployeeType;
import org.example.models.Good;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
        Good chicken = new Good("Chicken", 1500F);
        Good apple = new Good("apple", 500F);
        Good candy = new Good("candy", 1900F);
        Good banana = new Good("Banana ", 483F );

        // adding goods to shop
        shopDAO.addGood(candy, 100);
        shopDAO.addGood(apple, 100);
        shopDAO.addGood(banana, 100);
        shopDAO.addGood(chicken, 100);

        printStore();
        int expectedSize = 4;
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
        Good chicken = new Good("Chicken", 1500F);
        Good apple = new Good("apple", 500F);
        Good candy = new Good("candy", 1900F);
        Good banana = new Good("Banana ", 483F );
        List<Good> basket = new ArrayList<>();
        Collections.addAll(basket, chicken, apple, candy, banana);

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
