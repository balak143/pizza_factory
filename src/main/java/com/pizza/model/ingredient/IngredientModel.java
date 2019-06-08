package com.pizza.model.ingredient;

import com.pizza.model.cost.CostModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class IngredientModel {
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

    public String getProductCode() {
        return productCode;
    }

    public IngredientType getType() {
        return type;
    }

    public Double getRequiredQty() {
        return requiredQty;
    }

    public String getQtyUom() {
        return qtyUom;
    }
}
