package com.pizza.order.dao;

import java.util.Date;

public final class CostDataKey implements DataKey {
    private String productCode;
    private Date effectiveDate;

    public CostDataKey(String productCode, Date effectiveDate) {
        this.productCode = productCode;
        this.effectiveDate = effectiveDate;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
