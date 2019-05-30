package com.pizza.model.order;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.SidesModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KalyaniPizzaStoreOrderModel implements PizzaOrderModel {
    private List<PizzaModel> pizzaModels = new ArrayList<>();
    private List<SidesModel> sidesModels = new ArrayList<>(); ;


    @Override
    public List<Price> cost(Date date) {
        return null;
    }

    public void addPizzaModel(PizzaModel pizzaModel){
        this.pizzaModels.add(pizzaModel);
    }

    @Override
    public List<PizzaModel> getPizzaModels() {
        return this.pizzaModels;
    }


    public void addSidesModel(SidesModel sidesModel){
        this.sidesModels.add(sidesModel);
    }

    @Override
    public List<SidesModel> getSidesModels() {
        return this.getSidesModels();
    }
}
