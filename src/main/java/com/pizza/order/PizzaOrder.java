package com.pizza.order;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaOrder {
    private Pizza pizza = null;
    private List<Side> sides = new ArrayList<>();

    private int quantity;

    public PizzaOrder(Pizza pizza, int quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
    }

    public PizzaOrder withSides(Side... side) {
        sides.addAll(Arrays.asList(side));
        return this;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public List<Side> getSides() {
        return sides;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double calculateTotal() {
        return (this.getQuantity() * pizza.getCost()) +
                this.getSides().stream()
                        .mapToDouble(Side::getCost).sum();
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append(this.pizza.toString()).append("Along with Sides  ").append(System.lineSeparator());
        for (Side sides: this.sides) {
            result.append(" * ").append(sides).append(System.lineSeparator());
        }
        return result.toString();
    }
}
