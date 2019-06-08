package com.pizza.model.crust;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class WheatThinCrustModel extends AbstractCrustModel {
    public WheatThinCrustModel(){
        this.setName(CrustName.WHEAT_THIN_CRUST.getName());
    }
}
