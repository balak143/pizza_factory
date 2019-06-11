package com.pizza.grid;

import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;

/**
 * We can use hazel case here as an in memory distributed cache.
 * @param <K>
 * @param <V>
 */
public interface Grid<K extends DataKey, V extends Data> {
    GridType getType();
    V getData(K key);
    void updateData(K key, V data);
    void loadAll();
    V load(K dataKey);
    List<V> load(List<K> dataKeyList);
}
