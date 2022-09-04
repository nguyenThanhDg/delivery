/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository.Impl;

import com.ntd.pojo.Product;
import com.ntd.pojo.ProductShipper;
import com.ntd.pojo.User;
import com.ntd.repository.ProductRepository;
import com.ntd.repository.ProductShipperRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ProductShipperRepositoryImpl implements ProductShipperRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductShipper addProductShipper(String content, int productId, User creator) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        ProductShipper r = new ProductShipper();
        r.setProduct(this.productRepository.getProductById(productId));
        r.setCreatedDate(new Date());
        r.setUpdatedDate(new Date());
        r.setShipper(creator);
        int cost = Integer.parseInt(content);
        r.setCost(cost);
        session.save(r);
        return r;
    }

    @Override
    public List<ProductShipper> checkShipperAndPro(int productId, int shipperId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductShipper> query = builder.createQuery(ProductShipper.class);
        Root root = query.from(ProductShipper.class);
        query = query.select(root);
        Predicate p1 = builder.equal(root.get("product"), productId);
        Predicate p2 = builder.equal(root.get("shipper"), shipperId);
        query.where(builder.and(p1, p2));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public ProductShipper updateProductShipper(int id, String content) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        ProductShipper r = session.get(ProductShipper.class, id);
        int cost = Integer.parseInt(content);
        r.setCost(cost);
        r.setUpdatedDate(new Date());
        return r;

    }

    @Override
    public List<ProductShipper> getByProductId(int productId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductShipper> query = builder.createQuery(ProductShipper.class);
        Root root = query.from(ProductShipper.class);
        query = query.select(root);
        Predicate p1 = builder.equal(root.get("product"), productId);
        query = query.where(p1);
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public ProductShipper active(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        ProductShipper r = session.get(ProductShipper.class, id);
        r.setActive1(1);
        int pId = r.getProduct().getId();
        session.save(r);
        Product p = session.get(Product.class, pId);
        p.setStatus(Product.active);
        session.save(p);
        return r;
    }

    @Override
    public ProductShipper getActive(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductShipper> query = builder.createQuery(ProductShipper.class);
        Root root = query.from(ProductShipper.class);
        query = query.select(root);
        Predicate p1 = builder.equal(root.get("product"), id);
        Predicate p2 = builder.equal(root.get("active1"), 1);
        query.where(builder.and(p1, p2));
        Query q = session.createQuery(query);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (ProductShipper) q.getResultList().get(0);
    }

    @Override
    public List<ProductShipper> getByShipperId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductShipper> query = builder.createQuery(ProductShipper.class);
        Root root = query.from(ProductShipper.class);
        query = query.select(root);
        Predicate p1 = builder.equal(root.get("shipper"), id);
        Predicate p2 = builder.equal(root.get("active1"), 1);
        query.where(builder.and(p1, p2));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public ProductShipper accept(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        ProductShipper r = session.get(ProductShipper.class, id);
        r.setActive1(2);
        int pId = r.getProduct().getId();
        session.save(r);
        Product p = session.get(Product.class, pId);
        p.setStatus(Product.accept);
        session.save(p);
        return r;
    }

    @Override
    public ProductShipper getProSByProId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductShipper> query = builder.createQuery(ProductShipper.class);
        Root root = query.from(ProductShipper.class);
        query = query.select(root);
        Predicate p1 = builder.equal(root.get("product"), id);
        Predicate p2 = builder.equal(root.get("active1"), 2);
        query.where(builder.and(p1, p2));
        Query q = session.createQuery(query);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (ProductShipper) q.getResultList().get(0);
    }
}
