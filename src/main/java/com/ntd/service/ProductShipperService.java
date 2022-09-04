/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service;

import com.ntd.pojo.Product;
import com.ntd.pojo.ProductShipper;
import com.ntd.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface ProductShipperService {
    ProductShipper addProductShipper(String content, int shipperId, User creator);
    List<ProductShipper> checkShipperAndPro(int productId, int shipperId);
    ProductShipper updateProductShipper(int id,String content);
    List<ProductShipper> getByProductId(int productId);
    ProductShipper active(int id);
    ProductShipper getActive(int id);
    List<ProductShipper> getByShipperId(int shipperId);
    ProductShipper accept(int id);
//    List<ProductShipper> getProducts(Map<String, String> params, List<Product> pro);
    ProductShipper getProSByProId(int id);
}
