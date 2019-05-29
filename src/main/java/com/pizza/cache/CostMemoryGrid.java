package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

import java.util.List;
import java.util.Map;

public class CostMemoryGrid extends AbstractGrid {
    Map<DataKey, Data> data ;
    @Override
    void loadAll() {

    }

    @Override
    Data load(DataKey dataKey) {
        return null;
    }

    @Override
    List<Data> load(List<DataKey> dataKeyList) {
        return null;
    }


    public CostData getCost(CostDataKey key) {
        return null;
    }
}
