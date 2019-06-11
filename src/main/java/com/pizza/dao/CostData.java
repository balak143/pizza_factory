package com.pizza.dao;

import java.util.Date;

public class CostData implements Data {
  private String uuid;
  private String productCode;
  private Date effectiveDate;

  private double price;
  private String priceUOM;
  private String priceCcy;

  public CostData(
      String productCode, Date effectiveDate, double price, String priceCcy, String priceUOM) {
    this.productCode = productCode;
    this.effectiveDate = effectiveDate;
    this.price = price;
    this.priceCcy = priceCcy;
    this.priceUOM = priceUOM;
  }

  public double getPrice() {
    return price;
  }

  public String getPriceUOM() {
    return priceUOM;
  }

  public String getPriceCcy() {
    return priceCcy;
  }

  public String getUuid() {
    return uuid;
  }

  public String getProductCode() {
    return productCode;
  }

  public Date getEffectiveDate() {
    return effectiveDate;
  }
}
