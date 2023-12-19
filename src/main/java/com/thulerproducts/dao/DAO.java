package com.thulerproducts.dao;

import java.util.ArrayList;

public interface DAO<T> {

    ArrayList<T> getAll();

    T getByCode(int code);

    boolean insert(T object);

    boolean update(T object);

    boolean deleteByCode(int code);

    boolean deleteAll();

}
