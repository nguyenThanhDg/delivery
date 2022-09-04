/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service;

import com.ntd.pojo.Comment;
import com.ntd.pojo.User;

/**
 *
 * @author Admin
 */
public interface CommentService {
    Comment addComment(String content, int shipperId, User creator);
}
