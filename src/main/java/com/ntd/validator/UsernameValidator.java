/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.validator;

import com.ntd.pojo.User;
import com.ntd.repository.UserRepository;
import com.ntd.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Admin
 */
@Component
public class UsernameValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User u = (User) o;
        System.out.println(u.getUsername());
         System.out.println("check");
//        User user = this.userDetailsService.getUsers(u.getUsername()).get(0);
        
        if ("".equals(u.getUsername())) {
            errors.rejectValue("username", "Err.username.null");
        }
//        else
//        if (user != null) {
//            errors.rejectValue("username", "Err.username.multi");
//        }

    }

}
