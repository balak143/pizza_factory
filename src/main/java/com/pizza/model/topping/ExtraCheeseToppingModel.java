package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class ExtraCheeseToppingModel extends AbstractToppingModel implements VegetarianToppingModel {
    public ExtraCheeseToppingModel() {
        this.setName(ToppingName.EXTRA_CHEESE.getName());
    }
}
