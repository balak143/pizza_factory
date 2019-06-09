package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class GrilledChickenToppingModel extends AbstractToppingModel implements NonVegetarianToppingModel{
    public GrilledChickenToppingModel() {
        this.setName(ToppingName.GRILLED_CHICKEN.getName());
    }
}
