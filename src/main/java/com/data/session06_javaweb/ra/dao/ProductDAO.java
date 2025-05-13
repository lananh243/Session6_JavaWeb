package com.data.session06_javaweb.ra.dao;

import com.data.session06_javaweb.ra.model.Product;
import com.data.session06_javaweb.ra.model.ProductCart;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    boolean addToCart(ProductCart productCart);
}
