package com.pizza.order.model.enums;

public enum OrderType {
    Terminal,
    Online;
    @Override
    public String toString() {
        return " Order Type - " + this.name() ;
    }
}
