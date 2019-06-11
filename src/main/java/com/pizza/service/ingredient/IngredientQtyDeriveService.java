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
  public static final int HUNDRED = 100;
  public static final int FIVE = 5;
  public static final int SIX = 6;
  public static final int TWO = 2;
  public static final int FOUR = 4;
  public static final int TEN = 10;
  public static final int NINE = 9;
  public static final int EIGHT = 8;
  public static final int THREE = 3;
  public static final int ONEFIFTY = 150;
  public static final int ONETEN = 110;
  public static final double FIVEFIVE = 5.5;

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
            CrustName.WHEAT_THIN_CRUST.getName(), HUNDRED, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            CrustName.CHEESE_BURST.getName(), HUNDRED, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            CrustName.FRESH_PAN_PIZZA.getName(), ONEFIFTY, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            CrustName.NEW_HAND_TOSSED.getName(), ONETEN, "GRAM", IngredientType.VEG));
    // INGREDIENTS
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.SAUCE.getName(), EIGHT, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.CHEESE.getName(), TEN, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.CORN.getName(), FIVE, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.PANEER_CHOP.getName(), TWO, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.PEPPERONI.getName(), FIVE, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.RED_PEPPER.getName(), SIX, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.OREGANO.getName(), TWO, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.GARLIC.getName(), TWO, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.CHICKEN.getName(), THREE, "GRAM", IngredientType.NON_VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.RED_MEAT.getName(), TWO, "GRAM", IngredientType.NON_VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            PizzaIngredientsName.GINGER_CHICKEN.getName(), FOUR, "GRAM", IngredientType.NON_VEG));

    // Toppings
    addRequiredQty(
        new IngredientRequiredQty(ToppingName.PANEER.getName(), FIVE, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(ToppingName.CAPSICUM.getName(), FIVE, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.FRESH_TOMATO.getName(), TWO, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(ToppingName.MUSHROOM.getName(), FIVE, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.BLACK_OLIVE.getName(), FOUR, "GRAM", IngredientType.VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.EXTRA_CHEESE.getName(), FIVE, "GRAM", IngredientType.VEG));

    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.CHICKEN_TIKKA.getName(), FIVE, "GRAM", IngredientType.NON_VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.BARBEQUE_CHICKEN.getName(), FIVE, "GRAM", IngredientType.NON_VEG));
    addRequiredQty(
        new IngredientRequiredQty(
            ToppingName.GRILLED_CHICKEN.getName(), FIVE, "GRAM", IngredientType.NON_VEG));

    addRequiredQty(
        new IngredientRequiredQty(
            SidesName.COLD_DRINK.getName(), FIVEFIVE, "GRAM", IngredientType.BEVERAGES));
    addRequiredQty(
        new IngredientRequiredQty(
            SidesName.MOUSSE_CAKE.getName(), NINE, "GRAM", IngredientType.BEVERAGES));
  }

  public void clearQuantities() {
    quantities.clear();
  }

  private void addRequiredQty(IngredientRequiredQty requiredQty) {
    quantities.put(requiredQty.getName(), requiredQty);
  }
}
