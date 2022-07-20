package org.example.models;

import java.util.Date;
import java.util.Map;

public class Check
{
    private Map<Good, Integer> goodList;
    private String cashier;
    private Date sellTime;

    public Check(Map<Good, Integer> goodList, String cashier) {
        this.goodList = goodList;
        this.cashier = cashier;
        this.sellTime = new Date();
    }


    public Map<Good, Integer> getGoodList() {
        return goodList;
    }

    public String getCashier() {
        return cashier;
    }

    public Date getSellTime() {
        return sellTime;
    }

    @Override
    public String toString() {
        return "Check{" +
                "goodList=" + goodList +
                ", cashier='" + cashier + '\'' +
                ", sellTime=" + sellTime +
                '}';
    }
}

