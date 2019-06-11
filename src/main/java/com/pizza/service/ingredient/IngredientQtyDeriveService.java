package com.pizza.service.ingredient;

import com.pizza.exception.ApplicationException;
import com.pizza.model.crust.CrustName;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.ingredients.IngredientRequiredQty;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.sides.SidesName;
import com.pizza.model.topping.ToppingName;

import java.util.HashMap;
import java.util.Map;

/**
 * It supposed to be derived from ingredients required recipe but for simplicity I am using it from
 * here. Ideally should be like Cost and Inventory service using memory grid.
 */
public class IngredientQtyDeriveService {
  private static final IngredientQtyDeriveService INSTANCE = new IngredientQtyDeriveService();

  private Map<String, IngredientRequiredQty> quantities = new HashMap<>();

  public static IngredientQtyDeriveService getInstance() {
    return INSTANCE;
  }

  public IngredientRequiredQty getQty(String name) throws ApplicationException {

    if (!isExist(name)) {
      throw new ApplicationException("Ingredient is not available for  Product - " + name);
    }

    return quantities.get(name);
  }

  public boolean isExist(String name) {
    return quantities.containsKey(name);
  }

  /** At Application Start Up */
  public void loadRequiredQuantities() {
    addRequiredQty(
        new IngredientRequiredQty(
            CrustName.WHEAT_THIN_CRUST.getName(), 100, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            CrustName.CHEESE_BURST.getName(), 100, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            CrustName.FRESH_PAN_PIZZA.getName(), 150, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            CrustName.NEW_HAND_TOSSED.getName(), 110, "GRAM", IngredientType.VEG));
    // INGREDIENTS
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.SAUCE.getName(), 8, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.CHEESE.getName(), 10, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.CORN.getName(), 5, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.PANEER_CHOP.getName(), 2, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.PEPPERONI.getName(), 5, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.RED_PEPPER.getName(), 6, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.OREGANO.getName(), 2, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.GARLIC.getName(), 2, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.CHICKEN.getName(), 3, "GRAM", IngredientType.NON_VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.RED_MEAT.getName(), 2, "GRAM", IngredientType.NON_VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.GINGER_CHICKEN.getName(), 4, "GRAM", IngredientType.NON_VEG));

    // Toppings
    addRequiredQty(
        new IngredientRequiredQty(ToppingName.PANEER.getName(), 5, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(ToppingName.CAPSICUM.getName(), 5, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.FRESH_TOMATO.getName(), 2, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(ToppingName.MUSHROOM.getName(), 5, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.BLACK_OLIVE.getName(), 4, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.EXTRA_CHEESE.getName(), 5, "GRAM", IngredientType.VEG));

    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.CHICKEN_TIKKA.getName(), 5, "GRAM", IngredientType.NON_VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.BARBEQUE_CHICKEN.getName(), 5, "GRAM", IngredientType.NON_VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.GRILLED_CHICKEN.getName(), 5, "GRAM", IngredientType.NON_VEG));

    addRequiredQty(
        new IngredientRequiredQty(
            SidesName.COLD_DRINK.getName(), 5.5, "GRAM", IngredientType.BEVERAGES));
    addRequiredQty(
        new IngredientRequiredQty(
            SidesName.MOUSSE_CAKE.getName(), 9, "GRAM", IngredientType.BEVERAGES));
  }

  public void clearQuantities() {
    quantities.clear();
  }

  private void addRequiredQty(IngredientRequiredQty requiredQty) {
    quantities.put(requiredQty.getName(), requiredQty);
  }
}
