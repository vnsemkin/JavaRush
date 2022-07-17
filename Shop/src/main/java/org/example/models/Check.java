package org.example.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public String getCasheir() {
        return cashier;
    }

    public Date getSellTime() {
        return sellTime;
    }
}

