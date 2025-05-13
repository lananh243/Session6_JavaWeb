package com.data.session06_javaweb.ra.dao;

import com.data.session06_javaweb.ra.model.Categories;

import java.util.List;

public interface CategoriesDAO {
    List<Categories> findAll();

    boolean save(Categories catalog);

    Categories findById(int catalogId);

    boolean update(Categories catalog);

    boolean delete(int catalogId);
}
