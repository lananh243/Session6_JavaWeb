package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.dao.ProductDAO;
import com.data.session06_javaweb.ra.dao.ProductDAOImp;
import com.data.session06_javaweb.ra.model.Product;
import com.data.session06_javaweb.ra.model.ProductCart;

import java.util.List;

public class ProductServiceImp implements ProductService{

    private final ProductDAO productDAO;

    public ProductServiceImp() {
        productDAO = new ProductDAOImp();
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean addToCart(ProductCart productCart) {
        return productDAO.addToCart(productCart);
    }

}
