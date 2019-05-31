package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CostMemoryGrid extends AbstractGrid<CostDataKey, CostData> {

    @Override
    public GridType getType() {
        return GridType.COST;
    }

    @Override
    public CostData getData(CostDataKey key) {
        if(isExist(key)) {
            return getData().get(key);
        }

        Map.Entry<CostDataKey, CostData> dataEntry = getData().floorEntry(key);

        return (dataEntry != null ) ? dataEntry.getValue() : null;
    }

    @Override
    public void loadAll() {

    }

    @Override
    public CostData load(CostDataKey dataKey) {
        return null;
    }

    @Override
    public List<CostData> load(List<CostDataKey> dataKeyList) {
        return null;
    }

    @Override
    protected void createDataMap() {
        this.setData(new TreeMap<>());
    }

    public TreeMap<CostDataKey, CostData> getData() {
        return (TreeMap<CostDataKey, CostData>) super.getData();
    }
}
