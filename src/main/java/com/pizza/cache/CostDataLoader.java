package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.DataKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostDataLoader extends DataLoader {
    @Override
    public Map<CostDataKey, CostData> loadAll(){
       return new HashMap<CostDataKey, CostData>();
    }

    @Override
    public List<CostData> load(List<? extends DataKey> list) {
        return null;
    }

    @Override
    public CostData load(DataKey dataKey) {
        return null;
    }


}
