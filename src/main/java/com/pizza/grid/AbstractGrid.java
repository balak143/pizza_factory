package com.pizza.grid;

import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.Map;

public abstract class AbstractGrid<K extends DataKey, V extends Data> implements Grid<K, V> {
    private DataLoader<K,V> dataLoader;
    private Map<K, V> data;

    public AbstractGrid(DataLoader<K, V> dataLoader) {
        this.dataLoader = dataLoader;
    }

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

    public DataLoader<K, V> getDataLoader() {
        return dataLoader;
    }
}
