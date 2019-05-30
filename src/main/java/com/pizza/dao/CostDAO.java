package com.pizza.dao;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

public class CostDAO implements DAO {
 private Map<CostDataKey, CostData> costMap = new TreeMap<>();

    public Map<CostDataKey, CostData> getCostMap() {
        return costMap;
    }

    @Override
    public void load() {
        loadToppingsMap();
        loadPizzaIngredientsMap();
    }

    private void loadPizzaIngredientsMap() {
                    // Vegetarian Pizza
        // Deluxe Veggie of 3 sizes
        Calendar today = Calendar.getInstance();
        costMap.put(new CostDataKey("Paneer", today.getTime()),
                new CostData("Paneer", today.getTime(), 200.00, "INR", "KG"));
        costMap.put(new CostDataKey("Cheese", today.getTime()),
                new CostData("Cheese", today.getTime(), 300.00, "INR", "KG"));
        costMap.put(new CostDataKey("Capsicum", today.getTime()),
                new CostData("Capsicum", today.getTime(), 80.00, "INR", "KG"));
    }

    private void loadToppingsMap() {
        // Veg ToppingModel
   /*     vegToppingPriceMap.put(VEGTOPPING.BlackOliveToppingModel,Double.valueOf(20));
        vegToppingPriceMap.put(VEGTOPPING.Capsicum,Double.valueOf(25));
        vegToppingPriceMap.put(VEGTOPPING.Paneer,Double.valueOf(35));
        vegToppingPriceMap.put(VEGTOPPING.Mushroom,Double.valueOf(30));
        vegToppingPriceMap.put(VEGTOPPING.FreshTomato,Double.valueOf(10));
        // Non Veg ToppingModel
        nonVegToppingPriceMap.put(NONVEGTOPPING.ChickenTikkaToppingModel,Double.valueOf(35));
        nonVegToppingPriceMap.put(NONVEGTOPPING.BarbequeChicken,Double.valueOf(45));
        nonVegToppingPriceMap.put(NONVEGTOPPING.GrilledChicken,Double.valueOf(40));*/
    }

 }

