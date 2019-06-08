package com.pizza.model.pizza.ingredients;

import com.pizza.model.ingredient.IngredientType;

public class IngredientRequiredQty {
    private String name;
    private double qty;
    private String qtyUom;
    private IngredientType type;

    public IngredientRequiredQty(String name, double qty, String qtyUom, IngredientType type) {
        this.name = name;
        this.qty = qty;
        this.qtyUom = qtyUom;
        this.type = type;
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

    public IngredientType getType() {
        return type;
    }
}
