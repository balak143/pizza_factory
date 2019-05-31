package com.pizza.dao;

public final class InventoryDataKey implements DataKey {
    private String productCode;
    public InventoryDataKey(String productCode){
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
