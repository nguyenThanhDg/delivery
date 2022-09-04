/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository.Impl;

import com.ntd.pojo.User;
import com.ntd.pojo.UserShipper;
import com.ntd.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(User.class, id);
    }

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Object[]> getUsersGoShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rU = q.from(User.class);
        Root rUS = q.from(UserShipper.class);
        Predicate p1 = b.equal(rU.get("id"), rUS.get("id"));
        Predicate p2 = b.like(rU.get("userRole").as(String.class), "CUSTOMER");
        q.where(b.and(p1, p2));
        q.multiselect(rU.get("firstName"), rU.get("lastName"), rU.get("email"), rU.get("phone"), rU.get("avatar"), rUS.get("identity"), rUS.get("dob"), rUS.get("address"), rU.get("id"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean changeRole(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            User u = session.get(User.class, user.getId());
            System.out.print(u.getUserRole());
            u.setUserRole(User.shipper);
            System.out.print(u.getUserRole());
            session.update(u);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<User> getUserShipper(int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        Predicate p = builder.equal(root.get("userRole").as(String.class), "SHIPPER");
        query = query.where(p);
        Query q = session.createQuery(query);
        int max = 3;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        return q.getResultList();
    }

    @Override
    public long countUserShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT count(*) FROM User u WHERE u.userRole = :userRole");
        q.setParameter("userRole", "SHIPPER");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean checkShiper(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        User u = session.get(User.class, id);
        return u.getUserRole().equals(User.shipper);
    }

    @Override
    public List<Object[]> getUserShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rU = q.from(User.class);
        Root rUS = q.from(UserShipper.class);
        Predicate p1 = b.equal(rU.get("id"), rUS.get("id"));
        Predicate p2 = b.like(rU.get("userRole").as(String.class), "SHIPPER");
        q.where(b.and(p1, p2));
        q.multiselect(rU.get("firstName"), rU.get("lastName"), rU.get("email"), rU.get("phone"), rU.get("avatar"), rUS.get("identity"), rUS.get("dob"), rUS.get("address"), rU.get("id"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
    @Override
    public boolean changeRoleToCustomer(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            User u = session.get(User.class, user.getId());
            u.setUserRole(User.customer);
            session.update(u);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public Object getShipperById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rU = q.from(User.class);
        Root rUS = q.from(UserShipper.class);
        Predicate p1 = b.equal(rU.get("id"), rUS.get("id"));
        Predicate p2 = b.equal(rU.get("id"), id);
        q.where(b.and(p1, p2));
        q.multiselect(rU.get("firstName"), rU.get("lastName"), rU.get("email"), rU.get("phone"), rU.get("avatar"), rUS.get("identity"), rUS.get("dob"), rUS.get("address"), rU.get("id"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean updateUser(User user, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            System.err.println(user.getFirstName());
            
            User u = session.get(User.class, id);
            System.err.println(u.getFirstName());
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            u.setPhone(user.getPhone());
            session.update(u);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public long countCustomer() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT count(*) FROM User u WHERE u.userRole = :userRole");
        q.setParameter("userRole", "CUSTOMER");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean checkUserName(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT count(*) FROM User u WHERE u.username = :username");
        q.setParameter("username", username);
        if (Long.parseLong(q.getSingleResult().toString()) > 0)
            return false;
        else
            return true;
    }

}
