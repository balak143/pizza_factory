package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class MushroomToppingModel extends AbstractToppingModel implements VegetarianToppingModel {
    public MushroomToppingModel() {
        this.setName(ToppingName.MUSHROOM.getName());
    }
}
