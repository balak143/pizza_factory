package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class ChickenTikkaToppingModel extends AbstractToppingModel implements NonVegetarianToppingModel {
    public ChickenTikkaToppingModel() {
        this.setName(ToppingName.CHICKEN_TIKKA.getName());
    }
}
