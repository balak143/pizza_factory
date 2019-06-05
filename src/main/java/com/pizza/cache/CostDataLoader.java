package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.DataKey;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.utils.PizzaDateTime;

import java.util.*;
import java.util.stream.Collectors;

public class CostDataLoader extends DataLoader<CostDataKey, CostData> {
    private Map<CostDataKey, CostData> costData = new TreeMap<>();

    public CostDataLoader() {
    }

    private void dummyData() {
        // Toppings - Veg
        costData.put(new CostDataKey("Black Olive", today()),
                new CostData("Black Olive", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Capsicum", today()),
                new CostData("Capsicum", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Paneer", today()),
                new CostData("Paneer", today(), 7, "INR", "GRAM"));
        costData.put(new CostDataKey("Mushroom", today()),
                new CostData("Mushroom", today(), 6, "INR", "GRAM"));
        costData.put(new CostDataKey("Extra Cheese", today()),
                new CostData("Extra Cheese", today(), 7, "INR", "GRAM"));
        // Toppings Non-veg
        costData.put(new CostDataKey("Fresh Tomato", today()),
                new CostData("Fresh Tomato", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Chicken Tikka", today()),
                new CostData("Chicken Tikka", today(), 7, "INR", "GRAM"));
        costData.put(new CostDataKey("Barbeque Chicken", today()),
                new CostData("Barbeque Chicken", today(), 9, "INR", "GRAM"));
        costData.put(new CostDataKey("Grilled Chicken", today()),
                new CostData("Grilled Chicken", today(), 8, "INR", "GRAM"));
        //Crust
        costData.put(new CostDataKey("Wheat Thin", today()),
                new CostData("Wheat Thin", today(), 0.0, "INR", "GRAM"));
        costData.put(new CostDataKey("New Hand Tossed", today()),
                new CostData("New Hand Tossed", today(), 0.0, "INR", "GRAM"));
        costData.put(new CostDataKey("Cheese Burst", today()),
                new CostData("Cheese Burst", today(), 0.0, "INR", "GRAM"));
        costData.put(new CostDataKey("Fresh Pan Pizza", today()),
                new CostData("Fresh Pan Pizza", today(), 0.0, "INR", "GRAM"));
        // Sides
        costData.put(new CostDataKey("Cold Drink", today()),
                new CostData("Cold Drink", today(), 10, "INR", "GRAM"));
        costData.put(new CostDataKey("Mousse Cake", today()),
                new CostData("Mousse Cake", today(), 10, "INR", "GRAM"));

       // Pizza Ingradients
        costData.put(new CostDataKey("Sauce", today()),
                new CostData("Sauce", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Cheese", today()),
                new CostData("Cheese", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Pepperoni", today()),
                new CostData("Pepperoni", today(), 4, "INR", "GRAM"));
        costData.put(new CostDataKey("Red Pepper", today()),
                new CostData("Red Pepper", today(), 4, "INR", "GRAM"));
        costData.put(new CostDataKey("Oregano", today()),
                new CostData("Oregano", today(), 4, "INR", "GRAM"));
        costData.put(new CostDataKey("Garlic", today()),
                new CostData("Garlic", today(), 4, "INR", "GRAM"));
        costData.put(new CostDataKey("Corn", today()),
                new CostData("Corn", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Paneer Chop", today()),
                new CostData("Paneer Chop", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Chicken", today()),
                new CostData("Chicken", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Red meat", today()),
                new CostData("Red meat", today(), 5, "INR", "GRAM"));
        costData.put(new CostDataKey("Fish", today()),
                new CostData("Fish", today(), 5, "INR", "GRAM"));

    }

    private static Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }

    @Override
    public Map<CostDataKey, CostData> loadAll() {
        if (costData.isEmpty()) {
            dummyData();
        }
        return costData;

    }

    @Override
    public List<CostData> load(List<CostDataKey> keys) {
        if (costData.isEmpty()) {
            dummyData();
        }
        List<CostData> resultList = new ArrayList<>();
        costData.entrySet().stream().forEach(entry -> {
            if (keys.contains(entry.getKey())) {
                resultList.add(entry.getValue());
            }
        });
        return resultList;
    }

    @Override
    public CostData load(CostDataKey dataKey) {
        if (costData.isEmpty()) {
            dummyData();
        }
        return costData.get(dataKey);
    }


}
