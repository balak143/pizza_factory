package com.pizza.order.cache;

import com.pizza.order.dao.Data;
import com.pizza.order.dao.DataKey;

public interface Grid {
    GridType getType();
    Data getKey(DataKey key);

}
