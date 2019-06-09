package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class BarbequeChickenToppingModel extends AbstractToppingModel implements NonVegetarianToppingModel {
    public BarbequeChickenToppingModel() {
        this.setName(ToppingName.BARBEQUE_CHICKEN.getName());
    }
}
