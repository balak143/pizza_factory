package com.pizza.grid;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.utils.PizzaDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CostDataLoader extends DataLoader<CostDataKey, CostData> {
  public static final int FIVE = 5;
  public static final int FOUR = 4;
  public static final int SEVEN = 7;
  public static final int SIX = 6;
  public static final int TEN = 10;
  public static final int NINE = 9;
  public static final int EIGHT = 8;
  private Map<CostDataKey, CostData> costData = new TreeMap<>();

  private void dummyData() {
    // Toppings - Veg
    costData.put(
        new CostDataKey("Black Olive", today()),
        new CostData("Black Olive", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Capsicum", today()), new CostData("Capsicum", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Paneer", today()), new CostData("Paneer", today(), SEVEN, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Mushroom", today()), new CostData("Mushroom", today(), SIX, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Extra Cheese", today()),
        new CostData("Extra Cheese", today(), SEVEN, "INR", "GRAM"));
    // Toppings Non-veg
    costData.put(
        new CostDataKey("Fresh Tomato", today()),
        new CostData("Fresh Tomato", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Chicken Tikka", today()),
        new CostData("Chicken Tikka", today(), SEVEN, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Barbeque Chicken", today()),
        new CostData("Barbeque Chicken", today(), NINE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Grilled Chicken", today()),
        new CostData("Grilled Chicken", today(), EIGHT, "INR", "GRAM"));
    // Crust
    costData.put(
        new CostDataKey("Wheat Thin", today()),
        new CostData("Wheat Thin", today(), 0.0, "INR", "GRAM"));
    costData.put(
        new CostDataKey("New Hand Tossed", today()),
        new CostData("New Hand Tossed", today(), 0.0, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Cheese Burst", today()),
        new CostData("Cheese Burst", today(), 0.0, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Fresh Pan Pizza", today()),
        new CostData("Fresh Pan Pizza", today(), 0.0, "INR", "GRAM"));
    // Sides
    costData.put(
        new CostDataKey("Cold Drink", today()),
        new CostData("Cold Drink", today(), TEN, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Mousse Cake", today()),
        new CostData("Mousse Cake", today(), TEN, "INR", "GRAM"));

    // Pizza Ingradients
    costData.put(
        new CostDataKey("Sauce", today()), new CostData("Sauce", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Cheese", today()), new CostData("Cheese", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Pepperoni", today()),
        new CostData("Pepperoni", today(), FOUR, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Red Pepper", today()),
        new CostData("Red Pepper", today(), FOUR, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Oregano", today()), new CostData("Oregano", today(), FOUR, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Garlic", today()), new CostData("Garlic", today(), FOUR, "INR", "GRAM"));
    costData.put(new CostDataKey("Corn", today()), new CostData("Corn", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Paneer Chop", today()),
        new CostData("Paneer Chop", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Chicken", today()), new CostData("Chicken", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Red meat", today()), new CostData("Red meat", today(), FIVE, "INR", "GRAM"));
    costData.put(
        new CostDataKey("Ginger Chicken", today()),
        new CostData("Ginger Chicken", today(), FIVE, "INR", "GRAM"));
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
    costData.entrySet().stream()
        .forEach(
            entry -> {
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
