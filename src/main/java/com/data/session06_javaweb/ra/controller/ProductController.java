package com.data.session06_javaweb.ra.controller;

import com.data.session06_javaweb.ra.model.Product;
import com.data.session06_javaweb.ra.model.ProductCart;
import com.data.session06_javaweb.ra.service.ProductService;
import com.data.session06_javaweb.ra.service.ProductServiceImp;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private final ProductService productService;

    public ProductController() {
        productService = new ProductServiceImp();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllProduct(request, response);
        }
    }

    public void findAllProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> listProducts = productService.findAll();
        request.setAttribute("listProducts", listProducts);
        request.getRequestDispatcher("views/listProduct.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Add")) {
            try {
                int productId = Integer.parseInt(request.getParameter("productId"));
                int userId = Integer.parseInt(request.getParameter("userId"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));

                ProductCart productCart = new ProductCart();
                productCart.setProductId(productId);
                productCart.setUserId(userId);
                productCart.setQuantity(quantity);

                boolean result = productService.addToCart(productCart);

                if (result) {
                    System.out.println("Thêm vào giỏ hàng thành công");
                    request.setAttribute("message", "Thêm vào giỏ hàng thành công");
                    findAllProduct(request, response);

                } else {
                    System.out.println("Thêm vào giỏ hàng thất bại");
                    request.setAttribute("message", "Thêm vào giỏ hàng thất bại");
                }

            } catch (NumberFormatException e) {
                request.setAttribute("message", "Thông tin không hợp lệ. Vui lòng kiểm tra lại.");
            } catch (Exception e) {
                request.setAttribute("message", "Đã xảy ra lỗi khi thêm vào giỏ hàng.");
                e.printStackTrace();
            }

        }
    }
}