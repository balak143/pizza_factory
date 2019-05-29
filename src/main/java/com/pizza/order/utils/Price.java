package com.pizza.order.utils;

import java.util.Currency;

public class Price {
     Double price;
     String currency;
     String uom;

     public Price(Double price, String currency, String uom) {
          this.price = price;
          this.currency = currency;
          this.uom = uom;
     }
}
