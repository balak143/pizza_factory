package com.pizza.order.model.pizza;

import com.pizza.order.model.crust.Crust;
import com.pizza.order.model.crust.WheatThinCrust;
import com.pizza.order.model.enums.Size;
import com.pizza.order.model.topping.Topping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Pizza {
    private Size size;
    private Crust crust;
    protected String name;
    private List<Topping> toppings = new ArrayList<>();

    public abstract Double getCost();


    public Pizza() {
        crust = new WheatThinCrust();
        size = Size.REGULAR;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Crust getCrust() {
        return this.crust;
    }

    public List<Topping> getToppings() {
        return toppings;
    }


    public void addToppings(Topping... topping) {
        this.toppings.addAll(Arrays.asList(topping));
    }

    public Double getToppingsCost() {
        if (Size.LARGE == this.size) {
            // Large size pizzas come with any 2 toppings of customers choice with no additional cost
            return this.getToppings().subList(2, this.getToppings().size()).stream()
                    .mapToDouble(Topping::getCost)
                    .sum();
        } else {
            return this.getToppings().stream().mapToDouble(Topping::getCost).sum();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder().append( this.name + " Pizza ")
                .append("of "+ getSize().getName()).append(" Size ").append(System.lineSeparator())
                .append("With "+getCrust()).append(" as Crust ").append(System.lineSeparator())
                .append("Having Topping ").append(System.lineSeparator());
                //.append(pepperoni);
        for (Topping topping: this.toppings) {
            result.append(" + ").append(topping).append(System.lineSeparator());
        }
        return result.toString();
    }
}



