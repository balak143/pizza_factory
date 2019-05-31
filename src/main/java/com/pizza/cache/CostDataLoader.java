package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.DataKey;

import java.util.*;
import java.util.stream.Collectors;

public class CostDataLoader extends DataLoader {
    static Map<CostDataKey, CostData> costData = new TreeMap<>();

    {
        costData.entrySet().add(CostDB.BLACK_OLIVE.getCostMapEntry());
        costData.entrySet().add(CostDB.CAPSICUM.getCostMapEntry());
        costData.entrySet().add(CostDB.MUSHROOM.getCostMapEntry());
        costData.entrySet().add(CostDB.PANEER.getCostMapEntry());
    }

    @Override
    public Map<CostDataKey, CostData> loadAll() {
        return costData;

    }

    @Override
    public List<CostData> load(List<? extends DataKey> list) {
        List<CostData> resultList = new ArrayList<>();
        costData.entrySet().stream().forEach(entry -> {
            if (list.contains(entry.getKey())) {
                resultList.add(entry.getValue());
            }
        });
        return resultList;
    }

    @Override
    public CostData load(DataKey dataKey) {
        return costData.get(dataKey);
    }


}
