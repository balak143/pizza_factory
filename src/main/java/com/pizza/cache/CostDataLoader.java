package com.pizza.cache;

import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.DataKey;

import java.util.*;
import java.util.stream.Collectors;

public class CostDataLoader extends DataLoader<CostDataKey, CostData> {
    private Map<CostDataKey, CostData> costData = new TreeMap<>();

    public CostDataLoader() {
        dummyData();
    }

    private void dummyData() {
        costData.put(new CostDataKey("Black Olive", today()),
                new CostData("Black Olive", today(), 0.20, "INR", "GRAM"));
        costData.put(new CostDataKey("Capsicum", today()),
                new CostData("Capsicum", today(), 0.10, "INR", "GRAM"));
        costData.put(new CostDataKey("Paneer", today()),
                new CostData("Paneer", today(), 0.30, "INR", "GRAM"));
        costData.put(new CostDataKey("Mushroom", today()),
                new CostData("Mushroom", today(), 0.12, "INR", "GRAM"));
    }

    private static Date today() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    @Override
    public Map<CostDataKey, CostData> loadAll() {
        if (costData.isEmpty()) {
            dummyData();
        }
        return costData;

    }

    @Override
    public List<CostData> load(List<CostDataKey> keys) {
        if (costData.isEmpty()) {
            dummyData();
        }
        List<CostData> resultList = new ArrayList<>();
        costData.entrySet().stream().forEach(entry -> {
            if (keys.contains(entry.getKey())) {
                resultList.add(entry.getValue());
            }
        });
        return resultList;
    }

    @Override
    public CostData load(CostDataKey dataKey) {
        if (costData.isEmpty()) {
            dummyData();
        }
        return costData.get(dataKey);
    }


}
