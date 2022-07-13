package org.example.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Check
{
    private List<Good> goodList = new ArrayList<>();
    private String cashier;
    private Date sellTime;

    public Check(List<Good> goodList, String cashier) {
        this.goodList = goodList;
        this.cashier = cashier;
        this.sellTime = new Date();
    }


    @Override
    public String toString() {
        return "\nCheck{" +
                "\ngoodList=" + goodList +
                "\ncashier='" + cashier + '\'' +
                "\nsellTime=" + sellTime +
                '}';
    }
}

