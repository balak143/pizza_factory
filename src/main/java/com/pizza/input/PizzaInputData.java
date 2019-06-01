package com.pizza.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaInputData {
    private String name;
    private String crustName;
    private String pizzaSize;

    private List<String> toppings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getCrustName() {
        return crustName;
    }

    public void setCrustName(String crustName) {
        this.crustName = crustName;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void addToppings(String ... toppings) {
        this.toppings.addAll(Arrays.asList(toppings));
    }
}
