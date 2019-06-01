package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class PaneerToppingModel extends AbstractToppingModel {
    public PaneerToppingModel() {
        this.setName(ToppingName.PANEER.getName());
    }

    @Override
    public List<Price> cost(Date date) {
        return null;
    }
}
