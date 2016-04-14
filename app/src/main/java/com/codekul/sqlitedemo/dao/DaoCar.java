package com.codekul.sqlitedemo.dao;

import com.codekul.sqlitedemo.model.Car;

/**
 * Created by melayer on 14/4/16.
 */
public interface DaoCar extends DaoBase<Car>{

    Car findCarByName(String name) throws Exception;

    Car findCarByVer(Integer version) throws Exception;
}
