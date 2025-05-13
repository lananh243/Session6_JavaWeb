package com.data.session06_javaweb.ra.dao;

import com.data.session06_javaweb.ra.model.Product;
import com.data.session06_javaweb.ra.model.ProductCart;
import com.data.session06_javaweb.ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO {
    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_product()}");
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("product_price"));
                product.setImageUrl(rs.getString("product_imageUrl"));
                listProduct.add(product);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }

    @Override
    public boolean addToCart(ProductCart productCart) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_to_cart(?,?,?)}");
            callSt.setInt(1, productCart.getProductId());
            callSt.setInt(2, productCart.getUserId());
            callSt.setInt(3, productCart.getQuantity());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }


}
