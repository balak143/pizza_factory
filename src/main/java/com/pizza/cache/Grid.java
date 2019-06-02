package com.pizza.cache;

import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;

public interface Grid<K extends DataKey, V extends Data> {
    GridType getType();
    V getData(K key);
    void updateData(K key, V data);
    void loadAll();
    V load(K dataKey);
    List<V> load(List<K> dataKeyList);
}
