package com.pizza.dao;

import java.util.Date;
import java.util.Objects;

public final class CostDataKey implements DataKey, Comparable<CostDataKey> {
  private String productCode;
  private Date effectiveDate;

  public CostDataKey(String productCode, Date effectiveDate) {
    this.productCode = productCode;
    this.effectiveDate = effectiveDate;
  }

  /*
   * IntelliJ Generated
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CostDataKey that = (CostDataKey) o;
    return Objects.equals(productCode, that.productCode)
        && Objects.equals(effectiveDate, that.effectiveDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCode, effectiveDate);
  }

  @Override
  public int compareTo(CostDataKey o) {
    return this.productCode.compareTo(o.productCode);
  }
}
