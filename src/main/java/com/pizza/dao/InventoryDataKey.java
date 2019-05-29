package com.pizza.dao;

public final class InventoryDataKey implements DataKey {
    private String productCode;
    InventoryDataKey(String productCode){
        this.productCode = productCode;
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
