/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.Comment;
import com.ntd.pojo.User;
import com.ntd.service.CommentService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    
    @Autowired
    private CommentService commentService;
    
    @PostMapping(path = "/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (u != null)
            try {
                String content = params.get("content");
                int shipperId = Integer.parseInt(params.get("shipperId"));

                Comment c = this.commentService.addComment(content, shipperId, u);

                return new ResponseEntity<>(c, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
