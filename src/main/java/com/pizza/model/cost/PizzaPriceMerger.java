package com.pizza.model.cost;

import com.pizza.utils.Price;

import java.util.List;

public class PizzaPriceMerger {

    public Price merge(List<Price> prices) {
        double totalPizzasPrice = 0.0;
        for (Price price : prices) {
            totalPizzasPrice += price.getPrice();
        }
        return new Price(totalPizzasPrice, "INR");
    }
}
