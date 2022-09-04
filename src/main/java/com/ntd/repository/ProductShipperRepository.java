/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository;

import com.ntd.pojo.ProductShipper;
import com.ntd.pojo.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductShipperRepository {
    ProductShipper addProductShipper(String content, int productId, User creator);
    List<ProductShipper> checkShipperAndPro(int productId, int shipperId);
    ProductShipper updateProductShipper(int id,String content);
    List<ProductShipper> getByProductId(int productId);
    List<ProductShipper> getByShipperId(int shipperId);
    ProductShipper active(int id);
    ProductShipper accept(int id);
    ProductShipper getActive(int id);
    ProductShipper getProSByProId(int id);
}
