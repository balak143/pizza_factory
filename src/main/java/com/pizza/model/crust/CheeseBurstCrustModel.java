package com.pizza.model.crust;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class CheeseBurstCrustModel extends AbstractCrustModel{
    public CheeseBurstCrustModel(){
        this.setName(CrustName.CHEESE_BURST.getName());
    }
    @Override
    public List<Price> cost(Date date) {
        return null;
    }
}
