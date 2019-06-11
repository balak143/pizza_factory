package com.pizza.model.cost;

import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.Size;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaCostModel extends AbstractCostModel {
  public static final int SIZETWO = 2;
  protected AbstractPizzaModel pizzaModel;

  @Override
  public List<Price> cost(Date orderDate) {
    List<Price> prices = new ArrayList<>();
    double pizzaPrice = 0.0;
    Price crustPrice = getCrustPrice(orderDate);
    pizzaPrice += crustPrice.getPrice();

    pizzaPrice += Math.floor(getPizzaIngredientsPrice(orderDate).getPrice());

    pizzaPrice += getPizzaToppingsPrice(orderDate).getPrice();

    prices.add(new Price(pizzaModel.getName(), pizzaPrice, crustPrice.getCurrency()));

    return prices;
  }

  private Price getCrustPrice(Date orderDate) {
    AbstractCrustModel crustModel = pizzaModel.getCrustModel();
    IngredientModel ingredientModel = crustModel.getIngredientModel();

    Price cost = getCostService().cost(ingredientModel, orderDate);
    if (cost == null) {
      throw new IllegalArgumentException("Price not found for " + ingredientModel.getProductCode());
    }
    return cost;
  }

  private Price getPizzaIngredientsPrice(Date orderDate) {
    List<IngredientModel> ingredients = pizzaModel.getPizzaIngredientsModel().getIngredients();
    return getPrice(orderDate, ingredients);
  }

  private Price getPizzaToppingsPrice(Date orderDate) {
    if (pizzaModel.getToppings().isEmpty()) {
      return getZeroPrice();
    }

    List<IngredientModel> ingredients =
        pizzaModel.getToppings().stream()
            .map(toppingModel -> toppingModel.getIngredientModel())
            .collect(Collectors.toList());

    ingredients = applyOffer(ingredients);

    return getPrice(orderDate, ingredients);
  }

  protected List<IngredientModel> applyOffer(List<IngredientModel> ingredients) {
    List<IngredientModel> targetIngredients = ingredients;
    int size = ingredients.size();

    if (isLargeSize() && !ingredients.isEmpty()) {
      if (size >= SIZETWO) {
        targetIngredients = ingredients.subList(0, size - SIZETWO);
      } else if (size == 1) {
        targetIngredients = ingredients.subList(0, size - 1);
      }
    }
    return targetIngredients;
  }

  private boolean isLargeSize() {
    return pizzaModel.getSize() == Size.LARGE;
  }

  public void setPizzaModel(AbstractPizzaModel pizzaModel) {
    this.pizzaModel = pizzaModel;
  }
}
