package BankIlia;

import java.util.Scanner;

public class Address {
   private String city;
   private String street;
   private int building;
   private int flat;
    
    Address(){}
    
    void setAddress(Scanner sc){
        System.out.print("Input city : ");
        this.city = sc.nextLine();
        System.out.print("Input street : ");
        this.street = sc.nextLine();
        System.out.print("Input building : ");
        this.building = sc.nextInt();
        System.out.print("Input flat : ");
        this.flat = sc.nextInt();
        System.out.println();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    public int getFlat() {
        return flat;
    }
}
