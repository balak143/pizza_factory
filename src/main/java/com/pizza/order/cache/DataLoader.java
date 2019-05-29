package com.pizza.order.cache;

import com.pizza.order.dao.Data;
import com.pizza.order.dao.DataKey;

import java.util.List;
import java.util.Map;

public abstract class DataLoader {
    public abstract Map<? extends DataKey, ? extends Data> loadAll();
    public abstract <T extends Data> Data load(DataKey dataKey);
    public abstract List<? extends Data> load(List<DataKey> list);
}
