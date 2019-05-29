package com.pizza.model.topping;

import com.pizza.model.pizza.IngredientType;
import com.pizza.utils.Price;

import java.util.Date;

public class BlackOliveToppingModelModel implements ToppingModel {
    IngredientType type ;
    BlackOliveToppingModelModel(){
        type = IngredientType.VEG;
    }
    @Override
    public Price cost(Date date) {
        return null;
    }
}
