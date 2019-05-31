package com.pizza.model.cost;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.service.cost.CostService;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public abstract class AbstractCostModel implements CostModel {

    private CostService costService;


    protected Price getPrice(Date orderDate, List<IngredientModel> ingredients) {
        double totalPrice = 0;
        Price imPrice = null;

        if (ingredients.isEmpty()) {
            return getZeroPrice();
        }

        for (IngredientModel ingredient :
                ingredients) {
            imPrice = getCostService().cost(ingredient, orderDate);
            if (imPrice == null) {
                throw new IllegalArgumentException("Price not found for " + ingredient.getProductCode());
            }
            totalPrice += imPrice.getPrice();
        }

        return new Price(totalPrice, imPrice.getCurrency());
    }

    protected Price getPrice(Date orderDate, IngredientModel ingredient) {
        Price imPrice = null;

        if (ingredient == null) {
            return getZeroPrice();
        }

        imPrice = getCostService().cost(ingredient, orderDate);
        if (imPrice == null) {
            throw new IllegalArgumentException("Price not found for " + ingredient.getProductCode());
        }

        return new Price(imPrice.getPrice(), imPrice.getCurrency());
    }


    protected Price getZeroPrice() {
        return new Price(0.0, "USD");
    }

    protected List<IngredientModel> checkOffer(List<IngredientModel> ingredients) {
        return ingredients;
    }


    public CostService getCostService() {
        return costService;
    }

    public void setCostService(CostService costService) {
        this.costService = costService;
    }

}
