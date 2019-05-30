package com.pizza.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryDAO implements DAO {
Map<InventoryDataKey, InventoryData> inventoryMap = new ConcurrentHashMap<InventoryDataKey, InventoryData>();

    @Override
    public void load() {
        loadToppingsMap();
        loadPizzaIngredientsMap();
    }

    private void loadPizzaIngredientsMap() {
        inventoryMap.put(new InventoryDataKey("Paneer"),
                new InventoryData("Paneer", 20.00, "KG"));
        inventoryMap.put(new InventoryDataKey("Cheese"),
                new InventoryData("Cheese", 10.00, "KG"));
        inventoryMap.put(new InventoryDataKey("Capsicum"),
                new InventoryData("Capsicum", 30.00, "KG"));

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

