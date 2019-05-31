package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;

import java.util.*;
import java.util.function.Supplier;

public enum CostDB {

    // Toppings
    BLACK_OLIVE(() ->
            new AbstractMap.SimpleImmutableEntry(new CostDataKey("Black Olive", today()),
                    new CostData("Black Olive", today(), 0.20, "INR", "GRAM"))
    ),
    CAPSICUM(() ->
            new AbstractMap.SimpleImmutableEntry(new CostDataKey("Capsicum", today()),
                    new CostData("Capsicum", today(), 0.10, "INR", "GRAM"))
    ),
    PANEER(() ->
            new AbstractMap.SimpleImmutableEntry(new CostDataKey("Paneer", today()),
                    new CostData("Paneer", today(), 0.30, "INR", "GRAM"))
    ),
    MUSHROOM(() ->
            new AbstractMap.SimpleImmutableEntry(new CostDataKey("Mushroom", today()),
                    new CostData("Mushroom", today(), 0.12, "INR", "GRAM"))
    );

    /*
     CAPSICUM("Capsicum", ()-> new IngredientModel("Capsicum", IngredientType.VEG, 30.00, "GRAM")),
     PANEER("Paneer", ()-> new IngredientModel("Paneer", IngredientType.VEG, 50.00, "GRAM")),
     MUSHROOM("Mushroom",()-> new IngredientModel("Mushroom", IngredientType.VEG, 50.00, "GRAM")),
     FRESH_TOMATO("Fresh Tomato",()-> new IngredientModel("Mushroom", IngredientType.VEG, 50.00, "GRAM")),
     // Non Veg
     CHICKEN_TIKKA("Chicken Tikka",()-> new IngredientModel("Mushroom", IngredientType.NON_VEG, 100.00, "GRAM")),
     BARBEQUE_CHICKEN("Barbeque Chicken",()-> new IngredientModel("Mushroom", IngredientType.NON_VEG, 120.00, "GRAM")),
     GRILLED_CHICKEN("Grilled Chicken",()-> new IngredientModel("Mushroom", IngredientType.NON_VEG, 50.00, "GRAM")),
     // Extra Cheese
     EXTRA_CHEESE("Extra Cheese");
     EXTRA_CHEESE("Extra Cheese",()-> new IngredientModel("Mushroom",IngredientType.VEG, 50.00, "GRAM"));
 */

    private static Date today() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private Supplier<Map.Entry<CostDataKey, CostData>> supplier;

    CostDB(Supplier supplier) {
        this.supplier = supplier;
    }


    public Map.Entry<CostDataKey, CostData> getCostMapEntry() {
        return supplier.get();
    }

}
