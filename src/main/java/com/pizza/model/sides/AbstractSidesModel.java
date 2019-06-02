package com.pizza.model.sides;

import com.pizza.model.ingredient.IngredientModel;

public class AbstractSidesModel implements SidesModel {

    protected String name;
    private IngredientModel ingredientModel;

    public IngredientModel getIngredientModel() {
        return ingredientModel;
    }

    public AbstractSidesModel setIngredientModel(IngredientModel ingredientModel) {
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
