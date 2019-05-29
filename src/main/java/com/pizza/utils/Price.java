package com.pizza.utils;

import java.util.Currency;

public class Price {
     Double price;

     public Double getPrice() {
          return price;
     }

     public String getCurrency() {
          return currency;
     }

     public String getUom() {
          return uom;
     }

     String currency;
     String uom;

     public Price(Double price, String currency, String uom) {
          this.price = price;
          this.currency = currency;
          this.uom = uom;
     }
}
