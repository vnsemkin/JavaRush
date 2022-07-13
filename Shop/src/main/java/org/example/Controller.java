package org.example;

import org.example.dao.ShopDAO;
import org.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Controller
{
    static ShopDAO shopDAO = new ShopDAO();
    static String good = "axe";
    public static void main(String[] args) {
        //create goods

        Good hammer = new Good("Hammer", 1500F);
        Good screwdriver = new Good("screwdriver", 500F);
        Good drill = new Good("drill", 5500F);
        Good axe = new Good("axe", 4000F);
        Good saw = new Good("saw", 2700F);
        //add goods to store
        shopDAO.addGood(hammer, 120);
        shopDAO.addGood(screwdriver, 500);
        shopDAO.addGood(drill, 20);
        shopDAO.addGood(axe, 150);
        shopDAO.addGood(saw, 370);
        //Print store
        System.out.println(shopDAO.showGoods());
        shopDAO.getGoods();
        //Find good
        Good isGoodExist = shopDAO.findGood(good);
        if(isGoodExist != null)
        {
            System.out.println();
            System.out.println("#####Good was found#####");
            System.out.println(isGoodExist +", amount " + shopDAO.getStore().get(isGoodExist));
            System.out.println("########################");
        }else
            System.out.println("Good not found.");
        //remove good
        boolean isGoodRemoved = shopDAO.removeGood(good);
        if(isGoodRemoved)
        {
            System.out.println();
            System.out.println("#####Good " + "\"" + good + "\"" + " was removed#####");
            System.out.println();
            shopDAO.getGoods();
        }else
        {
            System.out.println();
            System.out.println("#####Good " + "\"" + good + "\"" + " was`t removed#####");
            System.out.println();
            shopDAO.getGoods();
    }
        shopDAO.addEmployee("Bob", EmployeeType.CASHIER);
        shopDAO.addEmployee("Alice", EmployeeType.CLEANER);
        shopDAO.addEmployee("Brain", EmployeeType.MANAGER);
        shopDAO.addEmployee("Jack", EmployeeType.DIRECTOR);
        shopDAO.addEmployee("Lily", EmployeeType.FINANCE_MANGER);
        shopDAO.addEmployee("Liza", EmployeeType.CASHIER);


        Set<String> employee = shopDAO.getToolsShop().getEmployees().keySet();
        System.out.println();
        System.out.println("#####Our Stuff : #####");
        for(String name:employee){
            System.out.println(name + " is the " +shopDAO.getToolsShop().getEmployees().get(name));
        }

        //Create check
        List<Good> basket = new ArrayList<>();
        List<Check> checkList = new ArrayList<>();
        basket.add(hammer);
        basket.add(drill);
        Check check = shopDAO.createCheck(basket);
        checkList.add(check);
        System.out.println();
        System.out.println("#####Check#####");
        System.out.println(check);
        System.out.println();

        //Add cash
        Shop.getINSTANCE().setCash(150400F);
        System.out.println("#####Shop cash#####");
        System.out.println(Shop.getINSTANCE().getCash() + " usd");
        System.out.println("###################");
        //Add client
        Client client = new Client("John", basket, checkList);
        System.out.println();
        System.out.println(client);
        System.out.println();
        //Get shop information
        System.out.println();
        System.out.println(Shop.getINSTANCE());
    }

}
