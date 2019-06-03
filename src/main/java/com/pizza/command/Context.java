package com.pizza.command;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<Object, Object> datas = new HashMap<>();

    public void setData(Object key, Object data) {
        datas.put(key, data);
    }

    public Object getData(Object key) {
        return datas.get(key);
    }
}
