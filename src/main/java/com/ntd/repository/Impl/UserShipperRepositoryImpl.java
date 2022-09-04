/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository.Impl;

import com.ntd.pojo.User;
import com.ntd.pojo.UserShipper;
import com.ntd.repository.UserShipperRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class UserShipperRepositoryImpl implements UserShipperRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public boolean addUserShipper(UserShipper userShipper) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(userShipper);
            
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }
    
    @Override
    public boolean deleteGotoShipper(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            UserShipper p = session.get(UserShipper.class, id);
            session.delete(p);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public UserShipper getShipperById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(UserShipper.class, id);
    }

    @Override
    public boolean updateShipperInfo(UserShipper shipper, int id) {
       Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            UserShipper u = session.get(UserShipper.class, id);
            u.setIdentity(shipper.getIdentity());
            u.setAddress(shipper.getAddress());
            u.setDob(shipper.getDob());
            session.update(u);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

}
