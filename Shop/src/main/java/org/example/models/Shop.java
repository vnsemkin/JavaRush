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
    private static HashMap<Good, Integer> store = new HashMap<>();
    private static Float cash = 50000F;
    private static HashMap<String, EmployeeType> employees = new HashMap<>();

    public static Shop getINSTANCE() {
       if(INSTANCE == null)
           INSTANCE = new Shop();
       return INSTANCE;
    }
    private Shop(){}

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

    public void setEmployees(HashMap<String, EmployeeType> employees) {
        this.employees = employees;
    }


}
