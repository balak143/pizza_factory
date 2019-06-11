package com.pizza.grid;

import com.pizza.dao.Data;
import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryDataLoader extends DataLoader<InventoryDataKey, InventoryData> {
  public static final int HUNDRED = 100;
  public static final int FIVE = 5;
  public static final int FOUR = 4;
  public static final int TEN = 10;
  public static final int SEVEN = 7;
  public static final int SIX = 6;
  public static final int NINE = 9;
  public static final int EIGHT = 8;
  private Map<InventoryDataKey, InventoryData> inventoryMap = new ConcurrentHashMap<>();

  @Override
  public Map<InventoryDataKey, InventoryData> loadAll() {
    if (inventoryMap.isEmpty()) {
      dummyData();
    }
    return inventoryMap;
  }

  @Override
  public Data load(InventoryDataKey dataKey) {
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
    inventoryMap.entrySet().stream()
        .forEach(
            entry -> {
              if (keys.contains(entry.getKey())) {
                resultList.add(entry.getValue());
              }
            });
    return resultList;
  }

  private void dummyData() {
    // Toppings - Veg
    inventoryMap.put(
        new InventoryDataKey("Black Olive"), new InventoryData("Black Olive", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Capsicum"), new InventoryData("Capsicum", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(new InventoryDataKey("Paneer"), new InventoryData("Paneer", SEVEN * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Mushroom"), new InventoryData("Mushroom", SIX * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Extra Cheese"), new InventoryData("Extra Cheese", SEVEN * HUNDRED, "GRAM"));
    // Toppings Non-veg
    inventoryMap.put(
        new InventoryDataKey("Fresh Tomato"), new InventoryData("Fresh Tomato", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Chicken Tikka"), new InventoryData("Chicken Tikka", SEVEN * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Barbeque Chicken"),
        new InventoryData("Barbeque Chicken", NINE * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Grilled Chicken"),
        new InventoryData("Grilled Chicken", EIGHT * HUNDRED, "GRAM"));
    // Crust
    inventoryMap.put(
        new InventoryDataKey("Wheat Thin"), new InventoryData("Wheat Thin", 0.0, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("New Hand Tossed"), new InventoryData("New Hand Tossed", 0.0, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Cheese Burst"), new InventoryData("Cheese Burst", 0.0, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Fresh Pan Pizza"), new InventoryData("Fresh Pan Pizza", 0.0, "GRAM"));
    // Sides
    inventoryMap.put(
        new InventoryDataKey("Cold Drink"), new InventoryData("Cold Drink", TEN * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Mousse Cake"), new InventoryData("Mousse Cake", TEN * HUNDRED, "GRAM"));

    // Pizza Ingradients
    inventoryMap.put(new InventoryDataKey("Sauce"), new InventoryData("Sauce", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(new InventoryDataKey("Cheese"), new InventoryData("Cheese", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Pepperoni"), new InventoryData("Pepperoni", FOUR * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Red Pepper"), new InventoryData("Red Pepper", FOUR * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Oregano"), new InventoryData("Oregano", FOUR * HUNDRED, "GRAM"));
    inventoryMap.put(new InventoryDataKey("Garlic"), new InventoryData("Garlic", FOUR * HUNDRED, "GRAM"));
    inventoryMap.put(new InventoryDataKey("Corn"), new InventoryData("Corn", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Paneer Chop"), new InventoryData("Paneer Chop", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Chicken"), new InventoryData("Chicken", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Red meat"), new InventoryData("Red meat", FIVE * HUNDRED, "GRAM"));
    inventoryMap.put(
        new InventoryDataKey("Ginger Chicken"),
        new InventoryData("Ginger Chicken", FIVE * HUNDRED, "GRAM"));
  }
}
