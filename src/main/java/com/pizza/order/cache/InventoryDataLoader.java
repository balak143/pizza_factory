package com.pizza.order.cache;

import com.pizza.order.dao.Data;
import com.pizza.order.dao.DataKey;
import com.pizza.order.dao.InventoryData;
import com.pizza.order.dao.InventoryDataKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryDataLoader extends DataLoader {
    public Map<InventoryDataKey, InventoryData> loadAll(){
       return new HashMap<InventoryDataKey, InventoryData>();
    }
    public InventoryData load(DataKey dataKey){
        new InventoryData();
    }
    public List<Data> load(List<DataKey> list);
}
