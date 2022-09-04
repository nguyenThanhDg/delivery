/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntd.pojo.Product;
import com.ntd.pojo.User;
import com.ntd.repository.ProductRepository;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@EnableTransactionManagement
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> getProducts(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        int max = 3;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        return q.getResultList();
    }

    @Override
    public Product getProductById(int productId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, productId);
    }

    @Override
    public long countProduct() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select count(*) from Product");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdate(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(product);

            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Product> getProductsByUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("customer"), user.getId());
        query = query.where(p);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean updateProduct(Product product, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {

            Product p = session.get(Product.class, id);
            if (!product.getFile().isEmpty()) {
                Map r;
                try {
                    r = this.cloudinary.uploader().upload(product.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    p.setImage((String) r.get("secure_url"));
                } catch (IOException ex) {
                    Logger.getLogger(ProductRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setDescription(product.getDescription());
            p.setDiliveryAddress(product.getDiliveryAddress());
            p.setGetAddress(product.getGetAddress());
            session.update(p);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public void deleteProduct(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Product p = session.get(Product.class, id);
            session.delete(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean checkActive(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Product p = session.get(Product.class, id);
        if(p.getStatus() == Product.active)
            return true;
        return false;
    }

    @Override
    public List<Product> getProducts(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }
        Query q = session.createQuery(query);
        return q.getResultList();
    }
}
