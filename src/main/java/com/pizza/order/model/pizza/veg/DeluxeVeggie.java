package com.pizza.order.model.pizza.veg;

import com.pizza.order.dao.CostDAO;
import com.pizza.order.dao.CostData;
import com.pizza.order.model.enums.VEGETARIAN;
import com.pizza.order.model.pizza.AbstractPizzaModel;
import com.pizza.order.utils.Price;

import java.util.Date;

public class DeluxeVeggie extends AbstractPizzaModel {

  /*@Override
  public Double getCost() {
    return PriceDAO.pizzaPriceMap.get(VEGETARIAN.DeluxeVeggie+"."+this.getSize())
            + this.getToppingsCost();
  }*/

  public DeluxeVeggie() {
    this.name = VEGETARIAN.DeluxeVeggie.getName();
  }


  @Override
  public Price cost(Date date) {
    CostData costData = new CostDAO().getCostMap().get("Paneer");
    double price =costData.getPrice();
    String priceCcy = costData.getPriceCcy();
    String priceUOM = costData.getPriceUOM();
    return new Price(price,priceCcy, priceUOM);
  }
}
