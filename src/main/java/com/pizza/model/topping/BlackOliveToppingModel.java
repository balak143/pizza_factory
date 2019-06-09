package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class BlackOliveToppingModel extends AbstractToppingModel implements VegetarianToppingModel {
    public BlackOliveToppingModel() {
        this.setName(ToppingName.BLACK_OLIVE.getName());
    }
}
