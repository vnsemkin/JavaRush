package org.example;

import static org.junit.Assert.assertTrue;

import org.example.dao.ShopDAO;
import org.example.models.Good;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Unit test for simple App.
 */
public class ShopDAOTest
{


    @Test
    public void removeGoodTest()
    {

        ShopDAO shopDAO = new ShopDAO();
        Good chicken = new Good("Chicken", 1500F);
        Good apple = new Good("apple", 500F);
        Good candy = new Good("candy", 1900F);
        Good banana = new Good("Banana ", 483F );

        // adding goods to shop
        shopDAO.addGood(candy, 100);
        shopDAO.addGood(apple, 100);
        shopDAO.addGood(banana, 100);
        shopDAO.addGood(chicken, 100);


        // removing good from shop
        boolean isRemoved = shopDAO.removeGood("apple");

        assertTrue( isRemoved );
    }

    @After
    public void printStore()
    {
        ShopDAO shopDAO = new ShopDAO();

        HashMap<Good, Integer> hashMap = shopDAO.showGoods();
        System.out.println(hashMap);
        Assert.assertNotEquals(null, hashMap);
    }


}
