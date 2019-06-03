package com.pizza.model.order;

import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.SidesModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class KalyaniPizzaStoreOrderModel implements PizzaOrderModel {
    private List<AbstractPizzaModel> pizzaModels = new ArrayList<>();
    private List<AbstractSidesModel> sidesModels = new ArrayList<>();


    public void addPizzaModel(AbstractPizzaModel... pizzaModels) {
        this.pizzaModels.addAll(Arrays.asList(pizzaModels));
    }

    @Override
    public List<AbstractPizzaModel> getPizzaModels() {
        return this.pizzaModels;
    }


    public void addSidesModel(AbstractSidesModel... sidesModels) {
        this.sidesModels.addAll(Arrays.asList(sidesModels));
    }

    @Override
    public List<AbstractSidesModel> getSidesModels() {
        return this.sidesModels;
    }

    public KalyaniPizzaStoreOrderModel setPizzaModels(List<AbstractPizzaModel> pizzaModels) {
        this.pizzaModels = pizzaModels;
        return this;
    }

    public KalyaniPizzaStoreOrderModel setSidesModels(List<AbstractSidesModel> sidesModels) {
        this.sidesModels = sidesModels;
        return this;
    }
}
