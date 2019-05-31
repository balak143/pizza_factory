package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;

import java.util.function.Supplier;

public enum ToppingName {
    BLACK_OLIVE("Black Olive" , ()-> new IngredientModel("Black Olive", IngredientType.VEG, 20.00, "GRAM") ),
    CAPSICUM("Capsicum", ()-> new IngredientModel("Capsicum", IngredientType.VEG, 30.00, "GRAM")),
    PANEER("Paneer", ()-> new IngredientModel("Paneer", IngredientType.VEG, 50.00, "GRAM")),
    MUSHROOM("Mushroom",()-> new IngredientModel("Mushroom", IngredientType.VEG, 50.00, "GRAM")),
    FRESH_TOMATO("Fresh Tomato",()-> new IngredientModel("Mushroom", IngredientType.VEG, 50.00, "GRAM")),
    // Non Veg
    CHICKEN_TIKKA("Chicken Tikka",()-> new IngredientModel("Mushroom", IngredientType.NON_VEG, 100.00, "GRAM")),
    BARBEQUE_CHICKEN("Barbeque Chicken",()-> new IngredientModel("Mushroom", IngredientType.NON_VEG, 120.00, "GRAM")),
    GRILLED_CHICKEN("Grilled Chicken",()-> new IngredientModel("Mushroom", IngredientType.NON_VEG, 50.00, "GRAM")),
    // Extra Cheese
    EXTRA_CHEESE("Extra Cheese",()-> new IngredientModel("Mushroom", IngredientType.VEG, 50.00, "GRAM"));

    private String name = null;
    private Supplier<IngredientModel> supplier;
    ToppingName(String name, Supplier supplier) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IngredientModel getIngredientModel(){
        return supplier.get();
    }

}
