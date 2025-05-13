package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.model.Product;
import com.data.session06_javaweb.ra.model.ProductCart;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean addToCart(ProductCart productCart);
}
