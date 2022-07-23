package org.example.dao;
import org.example.models.Check;
import org.example.models.EmployeeType;
import org.example.models.Good;
import org.example.models.Shop;
import java.io.*;
import java.util.*;
/*
ShopDAO
1. addGood;
2. findGood;
3. removeGood;
4. createCheck;
5. showGoods;
6. addEmployee
7.
 */
public class ShopDAO {

    private final Shop shop = Shop.getINSTANCE();
    Check check;
    public HashMap<Good, Integer> getActualProductName()
    {
        getGoodFromStore();
        return shop.getStore();
    }

    //Read goods from file and fill shop store with goods.
    public void getGoodFromStore()
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("goods.txt")))
        {
            HashMap<Good, Integer> shopStore = new HashMap<>();
            while (bufferedReader.ready())
            {
                String str = (bufferedReader.readLine());
                String[] goods = str.split(",", 3);
                shopStore.put(new Good(goods[0], Float.parseFloat(goods[1])), Integer.parseInt(goods[2]));
            }
            //Rewrite shop store
           shop.setStore(shopStore);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public final Shop getShop() {
        return shop;
    }

    public void addGoodAmount(Good good, int amount)
    {
        HashMap<Good, Integer> store = getActualProductName();
        Set<Good> goods = getActualProductName().keySet();
            for (Good storeGood : goods) {
                if (storeGood.getProductName().equals(good.getProductName())) {
                store.put(storeGood , store.get(storeGood) + amount);
                //Rewrite shop store
                shop.setStore(store);
            }
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("goods.txt")))
        {
            //Rewrite goods.txt from changed Hashmap store.
            for (Good storeGood : goods)
            {
               bufferedWriter.write(storeGood+","+ store.get(storeGood));
            }
        }catch (IOException e)
        {
            e.getMessage();
        }
    }
    public void addGood(Good good, int amount) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("goods.txt", true)))
        {
            HashMap<Good, Integer> store = getActualProductName();
            int goodsCount = store.size();
            int matchCount = 0;
            for (Map.Entry < Good, Integer > goodToAdd :store.entrySet()){
                if (!goodToAdd.getKey().getProductName().equals(good.getProductName())) {
                    matchCount++;
                }
            }
            if(goodsCount == matchCount)
            {
                store.put(good, amount);
                    //Rewrite goods.txt from changed Hashmap store.
                    bufferedWriter.write(good.getProductName()
                            + "," + good.getPrice()
                            + "," + amount + "\n");
            }
            shop.setStore(store);
        }catch (IOException e)
        {
            e.getMessage();
        }
    }

    public Good findGood(String name)
    {
        Set<Good> goods = getActualProductName().keySet();
        for (Good goodOfInterest : goods)
            if (goodOfInterest.getProductName().equals(name))
                return goodOfInterest;
        return null;
    }

    public void removeGood(String name) {
        HashMap<Good, Integer> store = getActualProductName();
        HashMap<Good, Integer> tempStore = new HashMap<>();
        for (Map.Entry<Good, Integer> good: store.entrySet()) {
            if (!good.getKey().getProductName().equals(name)) {
                tempStore.put(good.getKey(), good.getValue());
            }
        }
        // Rewrite shop store
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("goods.txt"))) {
            store = tempStore;
            shop.setStore(store);
            //Rewrite goods.txt from changed Hashmap store.
            for (Map.Entry<Good, Integer> good: store.entrySet()) {
                bufferedWriter.write(good.getKey().getProductName()
                        +"," +good.getKey().getPrice()
                        +"," +good.getValue()+"\n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void addCash(Float amount)
    {
        shop.setCash(shop.getCash() + amount);
    }

    public boolean removeGoodAmount(String name, Integer amount) {
        HashMap<Good, Integer> store = getActualProductName();
        Set<Good> goods = getActualProductName().keySet();
        for (Good good : goods) {
            if (good.getProductName().equals(name)) {
                int currAmount = store.get(good);
                if (currAmount > amount) {
                    store.put(good, (currAmount - amount));
                    return true;
                }
            }
        }
        return false;
    }

    public Check createCheck(Map<Good, Integer> basket, String name) {
        check = new Check(basket, name);
        return check;
    }

    public void writeClientsCheck() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("clientCheck.txt", true)))
        {
            for (Map.Entry<Good, Integer> product : check.getGoodList().entrySet())
            {
                bufferedWriter.write(product.getKey().getProductName()
                        + "," + product.getKey().getPrice()
                        + "," + product.getValue()
                        + ":");
            }
            bufferedWriter.write("cashier," + check.getCashier());
            bufferedWriter.write(":time," + String.valueOf(check.getSellTime()) + ";");
            bufferedWriter.write("\n");

        } catch (IOException e) {
            e.getMessage();
        }
    }

        public HashMap<Good, Integer> showGoods ()
        {
            getGoodFromStore();
            return shop.getStore();
        }
        public void addEmployee (String name, EmployeeType employeeType)
        {
            shop.getEmployees().put(name, employeeType);
        }


}
