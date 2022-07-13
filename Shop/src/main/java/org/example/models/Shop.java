package org.example.models;

import java.util.HashMap;

/*
1. Goods : HashMap
2. Cash : float
3. Employee : HashMap
 */
public class Shop
{
    private static Shop INSTANCE = null;
    private static final String shopName = "toolsShop";
    private HashMap<Good, Integer> store = new HashMap<>();
    private Float cash;
    private static HashMap<String, EmployeeType> employees = new HashMap<String, EmployeeType>();

    private Shop(){

    }
    public static Shop getINSTANCE()
    {
        if(INSTANCE == null)
            INSTANCE = new Shop();
        return INSTANCE;
    }
    public static String getShopName(){
        return shopName;
    }


    public HashMap<Good, Integer> getStore() {
        return store;
    }

    public void setStore(HashMap<Good, Integer> store) {
        this.store = store;
    }

    public Float getCash() {
        return cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }

    public HashMap<String, EmployeeType> getEmployees() {
        return employees;
    }

    public void setEmployees(String name, EmployeeType employeeType)
    {
        employees.put(name, employeeType);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "\nstore=" + store +
                "\ncash=" + cash + " usd" +
                "\nemployees=" + employees +
                "\n" +'}';
    }
}

