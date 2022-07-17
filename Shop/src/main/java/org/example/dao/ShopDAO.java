package org.example.dao;

import org.example.models.Check;
import org.example.models.EmployeeType;
import org.example.models.Good;
import org.example.models.Shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
ShopDAO
1. addGood;
2. findGood;
3. removeGood;
4. createCheck;
5. showGoods;
6. addEmploee
7.
 */
public class ShopDAO
{

    private Shop shop = Shop.getINSTANCE();


    public final Shop getShop()
    {
        return shop;
    }
    public void addGood(Good good, int amount)
    {
        HashMap<Good, Integer> store = shop.getStore();
        Set<Good> goods = store.keySet();
        for (Good goodIterator : goods)
        {
            if (goodIterator.getName().equals(good.getName()))
            {
                store.put(goodIterator, store.get(goodIterator) + amount);
                shop.setStore(store);
                return;
            }
        }

        store.put(good, amount);
        shop.setStore(store);

    }
    public Good findGood(String name)
    {

        HashMap<Good, Integer> store = shop.getStore();
        Set<Good> goods = store.keySet();

        for (Good goodIterator : goods)
            if (goodIterator.getName().equals(name))
                return goodIterator;


        return null;
    }
    public boolean removeGood(String name)
    {
        HashMap<Good, Integer> store = shop.getStore();
        Set<Good> goods = store.keySet();

        for (Good goodIterator : goods)
            if (goodIterator.getName().equals(name))
            {
                store.remove(goodIterator);
                shop.setStore(store);
                return true;
            }
        return false;
    }

    public void addCash(Float amount)
    {
        shop.setCash(shop.getCash()+ amount);
    }

    public boolean removeGood(String name, Integer amount)
    {

        HashMap<Good, Integer> store = shop.getStore();
        Set<Good> goods = store.keySet();
        for (Good good : goods)
        {
            if(good.getName().equals(name))
            {

                int currAmount = store.get(good);

                if(currAmount > amount)
                {
                    shop.getStore().put(good, (currAmount-amount));
                    return true;
                }
            }
        }
        return false;
    }
    public Check createCheck(Map<Good, Integer> basket, String name)
    {

        return new Check(basket, name);
    }
    public HashMap<Good, Integer> showGoods()
    {
        return shop.getStore();
    }
    public void addEmployee(String name, EmployeeType employeeType)
    {
        shop.getEmployees().put(name, employeeType);
    }

}
