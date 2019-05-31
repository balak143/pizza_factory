package com.pizza.model.pizza.ingredients;

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
    }

    public static IngredientQtyDeriveService getInstance() {
        return INSTANCE;
    }

    public IngredientRequiredQty getQty(String name) {

        if(!isExist(name)) {
            throw new IllegalArgumentException("Not a valid product.");
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
        this.addRequiredQty(new IngredientRequiredQty("", 50, "GR"));
    }

    private void addRequiredQty(IngredientRequiredQty requiredQty) {
        quantities.put(requiredQty.getName(), requiredQty);
    }
}
