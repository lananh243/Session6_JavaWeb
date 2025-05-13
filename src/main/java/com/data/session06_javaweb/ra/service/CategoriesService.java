package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();

    boolean save(Categories catalog);

    Categories findById(int id);

    boolean update(Categories catalog);

    boolean delete(int catalogId);
}
