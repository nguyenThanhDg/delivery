/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository.Impl;

import com.ntd.pojo.Comment;
import com.ntd.pojo.User;
import com.ntd.repository.CommentRepository;
import com.ntd.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CommnetRepositoryImpl implements CommentRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment addComment(String content, int shipperId, User creator) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Comment c = new Comment();
        c.setContent(content);
        c.setShipper(this.userRepository.getUserById(shipperId));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        formatter.format(date);
        System.out.print(date);
        c.setCreatedDate(date);
        c.setCustomer(creator);
        
        session.save(c);
        
        return c;
    }
    
}
