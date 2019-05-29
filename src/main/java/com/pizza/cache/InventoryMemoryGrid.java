package com.pizza.cache;

import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;
import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryMemoryGrid extends AbstractGrid {
    Map<InventoryDataKey, InventoryData> inventoryMap = new ConcurrentHashMap<InventoryDataKey, InventoryData>();

    public InventoryMemoryGrid(CostDataLoader costDataLoader) {
        this.gridDataLoader = costDataLoader;
    }

    @Override
    void loadAll() {
        //inventoryMap.putAll(this.gridDataLoader.loadAll());
    }

    @Override
    Data load(DataKey dataKey) {
        return null;
    }

    @Override
    List<Data> load(List<DataKey> dataKeyList) {
        return null;
    }

    public InventoryData getCost(InventoryDataKey key) {
        return inventoryMap.get(key);
    }
}
