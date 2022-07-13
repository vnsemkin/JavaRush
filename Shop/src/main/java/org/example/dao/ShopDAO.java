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
1. addGood+
2. findGood+
3. removeGood+
4. createCheck;
5. showGoods;+
6. addEmployee+

 */
public class ShopDAO
{

    private final Shop toolsShop = Shop.getINSTANCE();
    private HashMap<Good, Integer> store = toolsShop.getStore();
    Set<Good> goods;

    public HashMap<Good, Integer> getStore() {
        return store;
    }

    public Shop getToolsShop() {
        return toolsShop;
    }

    public void addGood(Good good, int amount)
    {
        goods = store.keySet();
        for (Good goodIterator : goods)
        {
            if (goodIterator.getName().equals(good.getName()))
            {
                store.put(goodIterator, store.get(goodIterator) + amount);
                toolsShop.setStore(store);
                return;
            }
        }

        store.put(good, amount);
        toolsShop.setStore(store);

    }
    public void getGoods(){
        System.out.println("###################################################");
        System.out.println("Store of our "+ Shop.getShopName() + " contains : ");
        System.out.println("###################################################");
        for (Good goodIterator : goods){
            System.out.println(goodIterator +", amount " + store.get(goodIterator));
        }
    }
    public Good findGood(String name)
    {
        goods = store.keySet();
        for (Good goodIterator : goods)
            if (goodIterator.getName().equals(name))
                return goodIterator;
        return null;
    }
    public boolean removeGood(String name)
    {
        goods = store.keySet();
        for (Good goodIterator : goods)
            if (goodIterator.getName().equals(name))
            {
                store.remove(goodIterator);
                toolsShop.setStore(store);
                return true;
            }
        return false;
    }
    public Check createCheck(List<Good> basket)
    {
        Check check = new Check(basket, "Liza");

        return check;
    }
    public HashMap<Good, Integer> showGoods()
    {
        return toolsShop.getStore();
    }
    public void addEmployee(String name, EmployeeType employeeType)
    {
        toolsShop.setEmployees(name, employeeType);
    }

}


