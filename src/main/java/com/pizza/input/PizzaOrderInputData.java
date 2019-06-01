package com.pizza.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaOrderInputData {
    private List<PizzaInputData> pizzaInputDatas = new ArrayList<>();
    private List<String> sides = new ArrayList<>() ;

    public List<PizzaInputData> getPizzaInputData() {
        return pizzaInputDatas;
    }

    public void setPizzaInputData(PizzaInputData... pizzaInputDatas) {
        this.pizzaInputDatas.addAll(Arrays.asList(pizzaInputDatas));
    }

    public List<String> getSides() {
        return sides;
    }

    public void setSides(List<String> sides) {
        this.sides = sides;
    }
    public void addSides(String... sides) {
        this.sides.addAll(Arrays.asList(sides));
    }

}
