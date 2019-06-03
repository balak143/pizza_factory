package com.pizza.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PizzaOrderInputData {
    private Date orderDate;
    private List<PizzaInputData> pizzaInputDatas = new ArrayList<>();
    private List<String> sides = new ArrayList<>() ;

    public List<PizzaInputData> getPizzaInputDatas() {
        return pizzaInputDatas;
    }

    public void setPizzaInputDatas(PizzaInputData... pizzaInputDatas) {
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

    public Date getOrderDate() {
        return orderDate;
    }

    public PizzaOrderInputData setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }
}
