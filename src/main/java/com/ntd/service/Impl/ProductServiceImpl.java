/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntd.pojo.Product;
import com.ntd.pojo.User;
import com.ntd.repository.ProductRepository;
import com.ntd.service.ProductService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Product> getProducts(String kw, int page) {
        return this.productRepository.getProducts(kw, page);
    }
    @Override
    public long countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }

    @Override
    public boolean addOrUpdate(Product product) {
        try {
            Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            product.setImage((String) r.get("secure_url"));
            product.setCreatedDate(new Date());
            product.setStatus(Product.on);
            return this.productRepository.addOrUpdate(product);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public List<Product> getProductsByUser(User user) {
        return this.productRepository.getProductsByUser(user);
    }

    @Override
    public boolean updateProduct(Product product, int id) {
        return this.productRepository.updateProduct(product,id);
    }

    @Override
    public void deleteProduct(int id) {
        this.productRepository.deleteProduct(id);
    }

    @Override
    public boolean checkActive(int id) {
        return this.productRepository.checkActive(id);
    }

    @Override
    public List<Product> getProducts(String kw) {
        return this.productRepository.getProducts(kw);
    }
}
