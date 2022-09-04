/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service;

import com.ntd.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Admin
 */
public interface UserService extends UserDetailsService {
    User getUserById(int userId);
    boolean addUser(User user);
    List<User> getUsers(String username);
    List<Object[]> getUsersGoShipper();
    boolean changeRole(User user);
    List<User> getUserShipper(int page);
    long countUserShipper();
    boolean checkShiper(int id);
    List<Object[]> getUserShipper();
    boolean changeRoleToCustomer(User user);
    Object getShipperById(int userId);
    boolean updateUser(User user, int id);
    long countCustomer();
    boolean checkUserName(String username);
}
