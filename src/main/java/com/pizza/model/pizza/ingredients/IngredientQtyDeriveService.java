package com.pizza.model.pizza.ingredients;

import com.pizza.exception.ApplicationException;

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

    public IngredientRequiredQty getQty(String name)throws ApplicationException {

        if(!isExist(name)) {
            throw new ApplicationException("Not a valid product.");
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
