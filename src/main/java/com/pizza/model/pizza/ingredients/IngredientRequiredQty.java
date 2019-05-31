package com.pizza.model.pizza.ingredients;

public class IngredientRequiredQty {
    private String name;
    private double qty;
    private String qtyUom;

    public IngredientRequiredQty(String name, double qty, String qtyUom) {
        this.name = name;
        this.qty = qty;
        this.qtyUom = qtyUom;
    }

    public String getName() {
        return name;
    }

    public double getQty() {
        return qty;
    }

    public String getQtyUom() {
        return qtyUom;
    }
}
