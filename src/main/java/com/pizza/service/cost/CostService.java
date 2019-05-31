package com.pizza.service.cost;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public interface CostService {
    Price cost(IngredientModel model, Date date);
}
