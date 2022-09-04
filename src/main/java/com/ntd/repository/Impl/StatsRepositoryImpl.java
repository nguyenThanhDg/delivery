/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository.Impl;

import com.ntd.pojo.Product;
import com.ntd.pojo.ProductShipper;
import com.ntd.pojo.User;
import com.ntd.repository.StatsRepository;
import java.util.ArrayList;
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
public class StatsRepositoryImpl implements StatsRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> stats(String kw,Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootPs = q.from(ProductShipper.class);
        Root rootP = q.from(Product.class);
        Root rootU = q.from(User.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootPs.get("product"), rootP.get("id")));
        predicates.add(b.equal(rootPs.get("shipper"), rootU.get("id")));
        predicates.add(b.equal(rootPs.get("active1"), 2));
        
        q.multiselect(rootPs.get("id"),rootP.get("image"), rootP.get("name"),rootU.get("firstName"),rootU.get("lastName"),rootPs.get("cost"),rootPs.get("updatedDate"));
        
        if (kw != null && !kw.isEmpty())
            predicates.add(b.like(rootP.get("name"), String.format("%%%s%%", kw)));
        
        if (fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootPs.get("updatedDate"), fromDate));
        
        if (toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootPs.get("updatedDate"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueStats(int y) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root root = q.from(ProductShipper.class);
        q.where(b.equal(root.get("active1"), 2),
                b.equal(b.function("YEAR", Integer.class, root.get("updatedDate")), y));
        q.multiselect(b.function("MONTH", Integer.class, root.get("updatedDate")),b.function("YEAR", Integer.class, root.get("updatedDate")),b.count(root.get("id")), b.sum(root.get("cost")));
        q.groupBy(b.function("MONTH", Integer.class, root.get("updatedDate")),b.function("YEAR", Integer.class, root.get("updatedDate")));
        Query query = session.createQuery(q);
        return query.getResultList();
    }
  
}
