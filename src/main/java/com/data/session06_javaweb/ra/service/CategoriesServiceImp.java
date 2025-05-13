package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.dao.CategoriesDAO;
import com.data.session06_javaweb.ra.dao.CategoriesDAOImp;
import com.data.session06_javaweb.ra.model.Categories;

import java.util.List;

public class CategoriesServiceImp implements CategoriesService {

    private final CategoriesDAO categoriesDAO;

    public CategoriesServiceImp() {
        categoriesDAO = new CategoriesDAOImp();
    }

    @Override
    public List<Categories> findAll() {
        return categoriesDAO.findAll();
    }

    @Override
    public boolean save(Categories catalog) {
        return categoriesDAO.save(catalog);
    }

    @Override
    public Categories findById(int id) {
        return categoriesDAO.findById(id);
    }

    @Override
    public boolean update(Categories catalog) {
        return categoriesDAO.update(catalog);
    }

    @Override
    public boolean delete(int catalogId) {
        return categoriesDAO.delete(catalogId);
    }
}
