package org.example.models;

public class Good
{
    String productName;
    Float price;

    public Good(String productName, Float price) {
        this.productName = productName;
        this.price = price;
    }

    public Good() {

    }

    public  String getProductName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public Float getPrice() {
        return price;
    }


    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
