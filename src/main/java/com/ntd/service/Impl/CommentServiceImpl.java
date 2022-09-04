/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service.Impl;

import com.ntd.pojo.Comment;
import com.ntd.pojo.User;
import com.ntd.repository.CommentRepository;
import com.ntd.repository.UserRepository;
import com.ntd.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(String content, int shipperId, User creator) {
        return this.commentRepository.addComment(content, shipperId, creator);
    }

}
