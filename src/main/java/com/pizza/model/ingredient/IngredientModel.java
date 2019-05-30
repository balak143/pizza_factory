package com.pizza.model.ingredient;

import com.pizza.model.cost.CostModel;
import com.pizza.utils.Price;

import java.util.Date;

public class IngredientModel implements CostModel {
    private String productCode;
    private IngredientType type;
    private Double requiredQty;
    private String qtyUom;

    public IngredientModel(String productCode, IngredientType type, Double requiredQty, String qtyUom) {
        this.productCode = productCode;
        this.type = type;
        this.requiredQty = requiredQty;
        this.qtyUom = qtyUom;
    }

    @Override
    public Price cost(Date date) {
        return null;
    }
}
