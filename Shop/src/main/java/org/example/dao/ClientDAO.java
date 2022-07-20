package org.example.dao;

import org.example.models.Check;
import org.example.models.Client;
import org.example.models.Good;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
addGoodToBasket
removeGoodFromBasket
buy
addCheck
 */

// add, save,
public class ClientDAO
{

    private final Client client;

    public Client getClient() {
        return client;
    }

    public ClientDAO(Client client)
    {
        this.client = client;
    }
    public void addGoodToBasket(Good good, Integer amount)
    {
        if(client.getBasket().containsKey(good))
            client.getBasket().put(good, client.getBasket().get(good) + amount);
        else
            client.getBasket().put(good, amount);
    }
    public void removeGoodFromBasket(Good good, Integer amount)
    {
        Integer currAmount = client.getBasket().get(good);
        if(!(client.getBasket().containsKey(good))) {}
        else if (Objects.equals(currAmount, amount) || currAmount < amount) {
                client.getBasket().remove(good);
        }
        else
        {
            client.getBasket().put(good, currAmount - amount);
        }
    }
    public Float removeCash()
    {
        Float total = 0F;
        Set<Map.Entry<Good, Integer>> basketEntrySet = client.getBasket().entrySet();

        for (Map.Entry<Good, Integer> good: basketEntrySet)
            total += good.getKey().getPrice() * good.getValue();
        client.setCash(client.getCash() - total);
        return total;
    }
    public void addCheck(Check check)
    {
        client.getOrdersHistory().add(check);
    }

}
