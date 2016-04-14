package com.codekul.sqlitedemo.dao;

/**
 * Created by melayer on 14/4/16.
 */
public interface DaoBase<T> {

    void insert(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(T t) throws Exception;

    T query(Long id) throws Exception;
}
