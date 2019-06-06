package com.pizza.grid;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.InventoryDataKey;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CostMemoryGrid extends AbstractGrid<CostDataKey, CostData> {

    public CostMemoryGrid(DataLoader dataLoader) {
        super(dataLoader);
    }

    @Override
    public GridType getType() {
        return GridType.COST;
    }

    protected boolean isExist(InventoryDataKey key) {
        return getData().containsKey(key);
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
    public void updateData(CostDataKey key, CostData data) {
        getData().put(key, data);
    }


    @Override
    public void loadAll() {
        this.setData(this.getDataLoader().loadAll());
    }

    @Override
    public CostData load(CostDataKey dataKey) {
        return (CostData) this.getDataLoader().load(dataKey);
    }

    @Override
    public List<CostData> load(List<CostDataKey> dataKeyList) {
       return this.getDataLoader().load(dataKeyList);
    }

    public TreeMap<CostDataKey, CostData> getData() {
        TreeMap<CostDataKey, CostData> data = (TreeMap<CostDataKey, CostData>) super.getData();
        return data;
    }

    @Override
    public void createDataMap() {
        this.setData(this.getDataLoader().loadAll());
    }


}
