package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;

public abstract class AbstractToppingModel implements ToppingModel {
    protected String name;

    protected IngredientModel ingredientModel ;

    public IngredientModel getIngredientModel() {
        return ingredientModel;
    }

    public AbstractToppingModel setIngredientModel(IngredientModel ingredientModel) {
        this.ingredientModel = ingredientModel;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
