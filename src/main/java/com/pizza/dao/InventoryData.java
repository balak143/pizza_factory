package com.pizza.dao;

public class InventoryData implements Data{
    private String uuid;
    private String productCode;
    private double stockQty;
    private String qtyUOM;

    public String getProductCode() {
        return productCode;
    }

    public double getStockQty() {
        return stockQty;
    }

    public String getQtyUOM() {
        return qtyUOM;
    }

    public InventoryData(String productCode, double stockQty, String qtyUOM) {
        this.productCode = productCode;
        this.stockQty = stockQty;
        this.qtyUOM = qtyUOM;
    }
}
