package com.pizza.input;

import java.util.Arrays;
import java.util.List;

public class PizzaOrderInputData {
    private List<PizzaInputData> pizzaInputDatas;
    private List<String> sides ;

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

}
