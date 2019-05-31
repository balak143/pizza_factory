package com.pizza.cache;

import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;
import com.pizza.dao.DataKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryDataLoader extends DataLoader {

    @Override
    public Map<InventoryDataKey, InventoryData> loadAll(){

       return new HashMap<InventoryDataKey, InventoryData>();
    }

    @Override
    public List<InventoryData> load(List<? extends DataKey> list) {
        return null;
    }

    @Override
    public InventoryData load(DataKey dataKey) {
        return null;
    }


}
