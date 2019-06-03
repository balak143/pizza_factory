package com.pizza.model.crust;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class NewHandTossedCrustModel extends AbstractCrustModel {
    public NewHandTossedCrustModel(){
        this.setName(CrustName.NEW_HAND_TOSSED.getName());
    }
    @Override
    public List<Price> cost(Date date) {
        return null;
    }
}
