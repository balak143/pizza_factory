package com.pizza.order.dao;

import java.util.Map;

public interface DAO<T> {
   /* int save(T t);
    int update(T t);
    int delete(T t);
    T findById(int id);*/
    void load();
}
