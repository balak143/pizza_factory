package com.pizza.cache;

import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;
import java.util.Map;

public abstract class DataLoader {
    public abstract Map<? extends DataKey, ? extends Data> loadAll();
    public abstract <T extends Data> Data load(DataKey dataKey);
    public abstract List<? extends Data> load(List<? extends DataKey> list);
}
