package com.pizza.cache;

import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;
import java.util.Map;

public abstract class AbstractGrid {
    DataLoader gridDataLoader;
    Map<DataKey, Data> data ;
    abstract void loadAll();
    abstract Data load(DataKey dataKey);
    abstract List<Data> load(List<DataKey> dataKeyList);
}
