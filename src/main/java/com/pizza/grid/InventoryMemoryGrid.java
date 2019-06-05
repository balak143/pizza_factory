package com.pizza.grid;

import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryMemoryGrid extends AbstractGrid <InventoryDataKey, InventoryData> {


    public InventoryMemoryGrid(InventoryDataLoader inventoryDataLoader) {
        super(inventoryDataLoader);
    }

    @Override
    public void createDataMap() {
        this.setData(new ConcurrentHashMap<>());
    }

    @Override
    public GridType getType() {
        return GridType.INVENTORY;
    }

    @Override
    public InventoryData getData(InventoryDataKey key) {
        return this.getData().get(key);
    }

    @Override
    public void updateData(InventoryDataKey key, InventoryData data) {
        this.getData().put(key,data);
    }
    @Override
    public void loadAll() {

    }

    @Override
    public InventoryData load(InventoryDataKey dataKey) {
        return null;
    }

    @Override
    public List<InventoryData> load(List<InventoryDataKey> dataKeyList) {
        return null;
    }
}
