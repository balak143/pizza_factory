package com.pizza.dao;

import java.util.Objects;

public final class InventoryDataKey implements DataKey {
  private String productCode;

  public InventoryDataKey(String productCode) {
    this.productCode = productCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InventoryDataKey that = (InventoryDataKey) o;
    return productCode.equals(that.productCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCode);
  }
}
