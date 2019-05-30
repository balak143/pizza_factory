package com.pizza.model.order;

public enum OrderType {
    Terminal,
    Online;
    @Override
    public String toString() {
        return " Order Type - " + this.name() ;
    }
}
