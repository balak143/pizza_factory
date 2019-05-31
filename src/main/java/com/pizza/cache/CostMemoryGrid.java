package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CostMemoryGrid extends AbstractGrid<CostDataKey, CostData> {

    CostMemoryGrid() {
        this.gridDataLoader = new CostDataLoader();
    }

    @Override
    public GridType getType() {
        return GridType.COST;
    }

    @Override
    public CostData getData(CostDataKey key) {
        if (isExist(key)) {
            return getData().get(key);
        }

        Map.Entry<CostDataKey, CostData> dataEntry = getData().floorEntry(key);

        return (dataEntry != null) ? dataEntry.getValue() : null;
    }

    @Override
    public void loadAll() {
        this.setData((Map<CostDataKey, CostData>) this.gridDataLoader.loadAll());
    }

    @Override
    public CostData load(CostDataKey dataKey) {
        return (CostData) this.gridDataLoader.load(dataKey);
    }

    @Override
    public List<CostData> load(List<CostDataKey> dataKeyList) {
        return null;
    }

    public TreeMap<CostDataKey, CostData> getData() {
        return (TreeMap<CostDataKey, CostData>) super.getData();
    }

    @Override
    protected void createDataMap() {
        this.setData((Map<CostDataKey, CostData>) this.gridDataLoader.loadAll());
    }


}
