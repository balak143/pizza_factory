package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;

import java.util.AbstractMap;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

public enum InventoryDB {

    // Toppings
    BLACK_OLIVE(() ->
            new AbstractMap.SimpleImmutableEntry(new InventoryDataKey("Black Olive"),
                    new InventoryData("Black Olive", 10000, "GRAM"))
    ),
    CAPSICUM(() ->
            new AbstractMap.SimpleImmutableEntry(new InventoryDataKey("Capsicum"),
                    new InventoryData("Capsicum", 2000, "GRAM"))
    ),
    PANEER(() ->
            new AbstractMap.SimpleImmutableEntry(new InventoryDataKey("Paneer"),
                    new InventoryData("Paneer", 3000, "GRAM"))
    ),
    MUSHROOM(() ->
            new AbstractMap.SimpleImmutableEntry(new InventoryDataKey("Mushroom"),
                    new InventoryData("Mushroom", 1500, "GRAM"))
    );

    /*
     CAPSICUM("Capsicum", ()-> new IngredientModel("Capsicum", IngredientType.VEG, 30.00, "GRAM")),
     PANEER_CHOP("Paneer", ()-> new IngredientModel("Paneer", IngredientType.VEG, 50.00, "GRAM")),
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

    InventoryDB(Supplier supplier) {
        this.supplier = supplier;
    }


    public Map.Entry<CostDataKey, CostData> getCostMapEntry() {
        return supplier.get();
    }

}
