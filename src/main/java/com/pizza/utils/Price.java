package com.pizza.utils;

import java.util.Currency;

public class Price {
     private String name;
     private Double price;
     private String currency;

     public Double getPrice() {
          return price;
     }

     public String getCurrency() {
          return currency;
     }

     public String getName() {
          return name;
     }

     public Price(String name, Double price, String currency) {
          this.name = name;
          this.price = price;
          this.currency = currency;
     }

     public Price(Double price, String currency) {
          this.price = price;
          this.currency = currency;
     }
}
