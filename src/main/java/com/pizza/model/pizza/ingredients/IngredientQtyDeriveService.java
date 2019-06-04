package com.pizza.model.pizza.ingredients;

import com.pizza.exception.ApplicationException;
import com.pizza.model.crust.CrustName;
import com.pizza.model.sides.SidesName;
import com.pizza.model.topping.ToppingName;

import java.util.HashMap;
import java.util.Map;

/**
 * It supposed to be derived from recipe but for simplecity I am using it from here.
 */
public class IngredientQtyDeriveService {
    private static final IngredientQtyDeriveService INSTANCE = new IngredientQtyDeriveService();

    private Map<String, IngredientRequiredQty> quantities = new HashMap<>();

    private IngredientQtyDeriveService() {
        //Don't allow to create Objects from Outside
        defaultQuantities();
    }

    public static IngredientQtyDeriveService getInstance() {
        return INSTANCE;
    }

    public IngredientRequiredQty getQty(String name)throws ApplicationException {

        if(!isExist(name)) {
            throw new ApplicationException(name + " - not a valid product.");
        }

        return quantities.get(name);
    }

    public boolean isExist(String name) {
        return quantities.containsKey(name);
    }

    /**
     * At Application Start Up
     */
    public void defaultQuantities() {
        addRequiredQty(new IngredientRequiredQty(CrustName.WHEAT_THIN_CRUST.getName(), 100, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(CrustName.CHEESE_BURST.getName(), 100, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(CrustName.FRESH_PAN_PIZZA.getName(), 150, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(CrustName.NEW_HAND_TOSSED.getName(), 110, "GRAM"));
        // INGREDIENTS
        addRequiredQty(new IngredientRequiredQty(PizzaIngredientsName.SAUCE.getName(), 10, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(PizzaIngredientsName.CHEESE.getName(), 20, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(PizzaIngredientsName.OREGANO.getName(), 5, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(PizzaIngredientsName.PEPERONI.getName(), 10, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(PizzaIngredientsName.RED_PEPPER.getName(), 5, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(PizzaIngredientsName.GARLIC.getName(), 20, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(PizzaIngredientsName.CORN.getName(), 20, "GRAM"));

        // Toppings
        addRequiredQty(new IngredientRequiredQty(ToppingName.PANEER.getName(), 50, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(ToppingName.CAPSICUM.getName(), 40, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(ToppingName.FRESH_TOMATO.getName(), 60, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(ToppingName.MUSHROOM.getName(), 50, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(ToppingName.BLACK_OLIVE.getName(), 30, "GRAM"));
        
        addRequiredQty(new IngredientRequiredQty(ToppingName.CHICKEN_TIKKA.getName(), 100, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(ToppingName.BARBEQUE_CHICKEN.getName(), 90.5, "GRAM"));
        addRequiredQty(new IngredientRequiredQty(ToppingName.GRILLED_CHICKEN.getName(), 100, "GRAM"));
        
        addRequiredQty(new IngredientRequiredQty(SidesName.COLD_DRINK.getName(), 250, "ML"));
        addRequiredQty(new IngredientRequiredQty(SidesName.MOUSSE_CAKE.getName(), 100, "GRAM"));
    }

    private void addRequiredQty(IngredientRequiredQty requiredQty) {
        quantities.put(requiredQty.getName(), requiredQty);
    }
}
