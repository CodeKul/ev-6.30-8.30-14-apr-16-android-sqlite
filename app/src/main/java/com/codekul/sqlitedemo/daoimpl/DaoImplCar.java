package com.codekul.sqlitedemo.daoimpl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.codekul.sqlitedemo.dao.DaoCar;
import com.codekul.sqlitedemo.db.DbHelper;
import com.codekul.sqlitedemo.model.Car;

/**
 * Created by melayer on 14/4/16.
 */
public class DaoImplCar implements DaoCar {

    private DbHelper helper;

    @Override
    public Car findCarByName(String name) throws Exception {
        return null;
    }

    @Override
    public Car findCarByVer(Integer version) throws Exception {
        return null;
    }

    @Override
    public void insert(Car car) throws Exception {

        SQLiteDatabase sqDb = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("car_name",car.getCarName());
        values.put("car_ver",car.getCarNum());
        sqDb.insert("tab_car","car_name",values);
        sqDb.close();
    }

    @Override
    public void update(Car car) throws Exception {

    }

    @Override
    public void delete(Car car) throws Exception {

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.delete("tab_car","car_ver = ?",new String[]{""+car.getCarNum()});
        sqDb.close();
    }

    @Override
    public Car query(Long id) throws Exception {

        SQLiteDatabase sqDb = helper.getReadableDatabase();

        String[] columns = {"car_name"};
        String selection = "car_ver = ?";
        String[] selectionArgs = {""+id};
        String orderBy = "car_name";

        Cursor cursor = sqDb.query("tab_car", columns, selection, selectionArgs, null, null, orderBy);

        Car car = new Car();
        if (cursor.moveToNext()) {

            String carName = cursor.getString(cursor.getColumnIndex("car_name"));
            car.setCarName(carName);
            Log.i("@codekul", "Car Name - " + carName);
        }

        sqDb.close();

        return car;
    }
}
