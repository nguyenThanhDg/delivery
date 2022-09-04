/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository;

import com.ntd.pojo.Product;
import com.ntd.pojo.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductRepository {
    List<Product> getProducts(String kw, int page);
    Product getProductById(int productId);
    long countProduct();
    boolean addOrUpdate(Product product);
    List<Product> getProductsByUser(User user);
    boolean updateProduct(Product product, int id);
    void deleteProduct(int id);
    boolean checkActive(int id);
    List<Product> getProducts(String kw);
}
