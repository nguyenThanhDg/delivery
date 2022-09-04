/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service.Impl;

import com.ntd.pojo.Product;
import com.ntd.pojo.ProductShipper;
import com.ntd.pojo.User;
import com.ntd.repository.ProductShipperRepository;
import com.ntd.service.ProductShipperService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ProductShipperServiceImpl implements ProductShipperService{
    @Autowired
    private ProductShipperRepository productShipperRepository;

    @Override
    public ProductShipper addProductShipper(String content, int shipperId, User creator) {
        return this.productShipperRepository.addProductShipper(content, shipperId, creator);
    }

    @Override
    public List<ProductShipper> checkShipperAndPro(int productId, int shipperId) {
        return this.productShipperRepository.checkShipperAndPro(productId, shipperId);
    }

    @Override
    public ProductShipper updateProductShipper(int id, String string) {
        return this.productShipperRepository.updateProductShipper(id, string);
    }

    @Override
    public List<ProductShipper> getByProductId(int id) {
        return this.productShipperRepository.getByProductId(id);
    }

    @Override
    public ProductShipper active(int id) {
        return this.productShipperRepository.active(id);
    }

    @Override
    public ProductShipper getActive(int id) {
        return this.productShipperRepository.getActive(id);
    }

    @Override
    public List<ProductShipper> getByShipperId(int id) {
        return this.productShipperRepository.getByShipperId(id);
    }

    @Override
    public ProductShipper accept(int id) {
        return this.productShipperRepository.accept(id);
    }

//    @Override
//    public List<ProductShipper> getProducts(Map<String, String> params,List<Product> pro) {
//        return this.productShipperRepository.getProducts(params, pro);
//    }

    @Override
    public ProductShipper getProSByProId(int i) {
        return this.productShipperRepository.getProSByProId(i);
    }
}
