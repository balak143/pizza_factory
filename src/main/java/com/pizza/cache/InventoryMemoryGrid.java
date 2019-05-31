package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;
import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryMemoryGrid extends AbstractGrid <InventoryDataKey, InventoryData> {


    @Override
    protected void createDataMap() {
        this.setData(new ConcurrentHashMap<>());
    }

    @Override
    public GridType getType() {
        return null;
    }

    @Override
    public InventoryData getData(InventoryDataKey key) {
        return this.getData().get(key);
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
