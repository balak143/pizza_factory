package com.pizza.model.cost;

import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SidesCostModel extends AbstractCostModel {
  private AbstractSidesModel sidesModel;

  @Override
  public List<Price> cost(Date orderDate) {
    List<Price> prices = new ArrayList<>();

    Price sidesPrice = getPrice(orderDate, this.sidesModel.getIngredientModel());

    prices.add(new Price(sidesModel.getName(), sidesPrice.getPrice(), sidesPrice.getCurrency()));

    return prices;
  }

  public SidesCostModel setSidesModel(AbstractSidesModel sidesModel) {
    this.sidesModel = sidesModel;
    return this;
  }
}
