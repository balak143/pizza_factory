package com.pizza.grid;

import com.pizza.dao.Data;
import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryDataLoader extends DataLoader<InventoryDataKey,InventoryData> {

    @Override
    public Map<InventoryDataKey, InventoryData> loadAll(){

       return new HashMap<InventoryDataKey, InventoryData>();
    }

    @Override
    public <V> Data load(InventoryDataKey dataKey) {
        return null;
    }

    @Override
    public List<InventoryData> load(List<InventoryDataKey> keys) {
        return null;
    }


}
