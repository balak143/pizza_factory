package com.pizza.utils;

public class Price {
  private String name;
  private Double price;
  private String currency;

  public Price(String name, Double price, String currency) {
    this.name = name;
    this.price = price;
    this.currency = currency;
  }

  public Price(Double price, String currency) {
    this.price = price;
    this.currency = currency;
  }


  public Double getPrice() {
    return price;
  }

  public String getCurrency() {
    return currency;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "{Name - "
        + this.getName()
        + ", Price - "
        + this.getPrice()
        + ", Currency - "
        + this.getCurrency()+"}";
  }
}
