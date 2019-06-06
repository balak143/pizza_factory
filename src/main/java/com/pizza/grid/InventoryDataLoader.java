package com.pizza.grid;

import com.pizza.dao.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryDataLoader extends DataLoader<InventoryDataKey,InventoryData> {
    private Map<InventoryDataKey, InventoryData> inventoryMap = new ConcurrentHashMap<>();

    @Override
    public Map<InventoryDataKey, InventoryData> loadAll(){
        if (inventoryMap.isEmpty()) {
            dummyData();
        }
       return inventoryMap;
    }

    @Override
    public <V> Data load(InventoryDataKey dataKey) {
        if (inventoryMap.isEmpty()) {
            dummyData();
        }
        return inventoryMap.get(dataKey);
    }

    @Override
    public List<InventoryData> load(List<InventoryDataKey> keys) {
        if (inventoryMap.isEmpty()) {
            dummyData();
        }
        List<InventoryData> resultList = new ArrayList<>();
        inventoryMap.entrySet().stream().forEach(entry -> {
            if (keys.contains(entry.getKey())) {
                resultList.add(entry.getValue());
            }
        });
        return resultList;
    }
    private void dummyData() {
        // Toppings - Veg
        inventoryMap.put(new InventoryDataKey("Black Olive"),
                new InventoryData("Black Olive", 5 *100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Capsicum"),
                new InventoryData("Capsicum", 5*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Paneer"),
                new InventoryData("Paneer", 7*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Mushroom"),
                new InventoryData("Mushroom", 6*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Extra Cheese"),
                new InventoryData("Extra Cheese", 7*100,  "GRAM"));
        // Toppings Non-veg
        inventoryMap.put(new InventoryDataKey("Fresh Tomato"),
                new InventoryData("Fresh Tomato", 5*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Chicken Tikka"),
                new InventoryData("Chicken Tikka", 7*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Barbeque Chicken"),
                new InventoryData("Barbeque Chicken", 9*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Grilled Chicken"),
                new InventoryData("Grilled Chicken", 8*100,  "GRAM"));
        //Crust
        inventoryMap.put(new InventoryDataKey("Wheat Thin"),
                new InventoryData("Wheat Thin", 0.0,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("New Hand Tossed"),
                new InventoryData("New Hand Tossed", 0.0,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Cheese Burst"),
                new InventoryData("Cheese Burst", 0.0,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Fresh Pan Pizza"),
                new InventoryData("Fresh Pan Pizza", 0.0,  "GRAM"));
        // Sides
        inventoryMap.put(new InventoryDataKey("Cold Drink"),
                new InventoryData("Cold Drink", 10,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Mousse Cake"),
                new InventoryData("Mousse Cake", 10,  "GRAM"));

        // Pizza Ingradients
        inventoryMap.put(new InventoryDataKey("Sauce"),
                new InventoryData("Sauce", 5*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Cheese"),
                new InventoryData("Cheese", 5*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Pepperoni"),
                new InventoryData("Pepperoni", 4*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Red Pepper"),
                new InventoryData("Red Pepper", 4*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Oregano"),
                new InventoryData("Oregano", 4*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Garlic"),
                new InventoryData("Garlic", 4*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Corn"),
                new InventoryData("Corn", 5*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Paneer Chop"),
                new InventoryData("Paneer Chop", 5*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Chicken"),
                new InventoryData("Chicken", 5*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Red meat"),
                new InventoryData("Red meat", 5*100,  "GRAM"));
        inventoryMap.put(new InventoryDataKey("Fish"),
                new InventoryData("Fish", 5*100,  "GRAM"));

    }



}
