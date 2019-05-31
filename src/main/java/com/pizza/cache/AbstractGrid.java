package com.pizza.cache;

import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;
import java.util.Map;

public abstract class AbstractGrid<K extends DataKey, V extends Data> implements Grid<K, V> {
    DataLoader gridDataLoader;
    private Map<K, V> data;

    protected abstract void createDataMap();

    public Map<K, V> getData() {
        return data;
    }

    public void setData(Map<K, V> data) {
        this.data = data;
    }

    protected boolean isExist(K key) {
        return data.containsKey(key);
    }

    protected V loadOnDemand(K key) {
        return this.load(key);
    }
}
