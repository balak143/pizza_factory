package com.pizza.model.order;

import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.SidesModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KalyaniPizzaStoreOrderModel implements PizzaOrderModel {
    private List<AbstractPizzaModel> pizzaModels = new ArrayList<>();
    private List<AbstractSidesModel> sidesModels = new ArrayList<>(); ;


    @Override
    public List<Price> cost(Date date) {
        return null;
    }

    public void addPizzaModel(AbstractPizzaModel pizzaModel){
        this.pizzaModels.add(pizzaModel);
    }

    @Override
    public List<AbstractPizzaModel> getPizzaModels() {
        return this.pizzaModels;
    }


    public void addSidesModel(AbstractSidesModel sidesModel){
        this.sidesModels.add(sidesModel);
    }

    @Override
    public List<AbstractSidesModel> getSidesModels() {
        return this.getSidesModels();
    }
}
