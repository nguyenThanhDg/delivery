/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.User;
import com.ntd.service.UserService;
import com.ntd.service.UserShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiAdminController {
    
    @Autowired
    private UserShipperService userShipperService;
    
    @Autowired
    private UserService userService;
    
    @DeleteMapping("/usershipper/{userShipperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGotoShipper(@PathVariable(value = "userShipperId") int id) {
        this.userShipperService.deleteGotoShipper(id);
    }
    
    @PutMapping("/usershipper/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addGotoShipper(@PathVariable(value = "userId") int id) {
        User user = this.userService.getUserById(id);
        this.userService.changeRole(user);
    }
    
    @PutMapping("/shipper/{shipperId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void changeRoleOfShipper(@PathVariable(value = "shipperId") int id) {
        User user = this.userService.getUserById(id);
        this.userService.changeRoleToCustomer(user);
    }
}
