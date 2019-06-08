package com.pizza.model.crust;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class FreshPanCrustModel extends AbstractCrustModel {
    public FreshPanCrustModel(){
        this.setName(CrustName.FRESH_PAN_PIZZA.getName());
    }
}
