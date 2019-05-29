package com.pizza.cache;

import com.pizza.dao.Data;
import com.pizza.dao.DataKey;

public interface Grid {
    GridType getType();
    Data getKey(DataKey key);

}
