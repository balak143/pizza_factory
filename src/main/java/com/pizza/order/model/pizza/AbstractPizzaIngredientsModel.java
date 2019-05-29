package com.pizza.order.model.pizza;

import com.pizza.order.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractPizzaIngredientsModel implements PizzaIngredientsModel {

    protected List<IngredientModel> ingredients = new ArrayList<>();

    @Override
    public Price cost(Date date) {
        return null;
    }

    public void create(){
        this.ingredients.add(new IngredientModel("Paneer", IngredientType.VEG, 50.00, "GRAM"));
        this.ingredients.add(new IngredientModel("Cheese", IngredientType.VEG, 20.00, "GRAM"));
    }
    public List<IngredientModel> getIngredients() {
        return ingredients;
    }

}
