package com.pizza.model.cost;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.Size;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaCostModel extends AbstractCostModel {
    //private AbstractPizzaModel pizzaModel;

    @Override
    public List<Price> cost(Date orderDate) {
        List<Price> prices = new ArrayList<>();

        double pizzaPrice = 0.0;
        Price crustPrice = getCrustPrice(orderDate);
        pizzaPrice += crustPrice.getPrice();

        pizzaPrice += getPizzaIngredientsPrice(orderDate).getPrice();

        pizzaPrice += getPizzaToppingsPrice(orderDate).getPrice();

        prices.add(new Price(pizzaModel.getName(), pizzaPrice, crustPrice.getCurrency()));

        return prices;
    }

    private Price getCrustPrice(Date orderDate) {
        return getCostService().cost(pizzaModel.getCrustModel().getIngredientModel(), orderDate);
    }

    private Price getPizzaIngredientsPrice(Date orderDate) {
        List<IngredientModel> ingredients = pizzaModel.getPizzaIngredientsModel().getIngredients();
        return getPrice(orderDate, ingredients);
    }

    private Price getPizzaToppingsPrice(Date orderDate) {
        if (pizzaModel.getToppings().isEmpty()) {
            return getZeroPrice();
        }

        List<IngredientModel> ingredients = pizzaModel.getToppings().stream().map(toppingModel -> toppingModel.getIngredientModel()).collect(Collectors.toList());

        ingredients = checkOffer(ingredients);

        return getPrice(orderDate, ingredients);
    }


    protected List<IngredientModel> checkOffer(List<IngredientModel> ingredients) {
        List<IngredientModel> targetIngredients = ingredients;
        int size = ingredients.size();

        if (isLargeSize() && !ingredients.isEmpty()) {
            if (size >= 2) {
                targetIngredients = ingredients.subList(0, size - 2);
            }else if(size == 1){
                targetIngredients = ingredients.subList(0, size - 1);
            }

        }
        return targetIngredients;
    }

    private boolean isLargeSize() {
        return pizzaModel.getSize() == Size.LARGE;
    }

    public AbstractPizzaModel getPizzaModel() {
        return pizzaModel;
    }

    public PizzaCostModel setPizzaModel(AbstractPizzaModel pizzaModel) {
        this.pizzaModel = pizzaModel;
        return this;
    }
}
