package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;

import java.util.AbstractMap;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

public enum IngredientDB {

    // Toppings and Ingredients
    BLACK_OLIVE(() -> new IngredientModel("Black Olive", IngredientType.VEG, 50.0, "GRAM")),
    CAPSICUM(() -> new IngredientModel("Capsicum", IngredientType.VEG, 30.0, "GRAM")),
    PANEER(() -> new IngredientModel("Paneer", IngredientType.VEG, .30, "GRAM")),
    MUSHROOM(() ->new IngredientModel("Mushroom", IngredientType.VEG, 50.0, "GRAM")),
    FRESH_TOMATO(()-> new IngredientModel("Fresh Tomato", IngredientType.VEG, 50.00, "GRAM")),

    CHICKEN_TIKKA(()-> new IngredientModel("Chicken Tikka", IngredientType.NON_VEG, 100.00, "GRAM")),
    BARBEQUE_CHICKEN(()-> new IngredientModel("Barbeque Chicken", IngredientType.NON_VEG, 120.00, "GRAM")),
    GRILLED_CHICKEN(()-> new IngredientModel("Grilled Chicken", IngredientType.NON_VEG, 50.00, "GRAM")),
     // Extra Cheese
    EXTRA_CHEESE(()-> new IngredientModel("Extra Cheese",IngredientType.VEG, 50.00, "GRAM")),

    // Crust
    NEWHANDTOSSED(()-> new IngredientModel("New hand tossed", IngredientType.VEG, 100.00, "GRAM")),
    WHEATTHINCRUST(()-> new IngredientModel("Wheat Thin", IngredientType.VEG, 100.00, "GRAM")),
    CHEESEBURST(()-> new IngredientModel("Cheese Burst", IngredientType.VEG, 100.00, "GRAM")),
    FRESHPANPIZZA(()-> new IngredientModel("Fresh pan Pizza", IngredientType.VEG, 100.00, "GRAM")),
    // Sides
    COLD_DRINK(()-> new IngredientModel("Cold Drink", IngredientType.VEG, 100.00, "GRAM")),
    MOUSSE_CAKE(()-> new IngredientModel("Mousse Cake", IngredientType.VEG, 100.00, "GRAM"));

    private Supplier<IngredientModel> supplier;

    IngredientDB(Supplier supplier) {
        this.supplier = supplier;
    }


    public IngredientModel ingredientModel() {
        return supplier.get();
    }

}
