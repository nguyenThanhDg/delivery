/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service.Impl;

import com.ntd.pojo.UserShipper;
import com.ntd.repository.UserShipperRepository;
import com.ntd.service.UserShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service
@Transactional
public class UserShipperServiceImpl implements UserShipperService{

    @Autowired
    private UserShipperRepository userShipperRepository;
    @Override
    
    public boolean addUserShipper(UserShipper userShipper) {
        if(this.userShipperRepository.addUserShipper(userShipper)== true)
           return true;
        return false;
    }

    @Override
    public boolean deleteGotoShipper(int id) {
        return this.userShipperRepository.deleteGotoShipper(id);
    }

    @Override
    public UserShipper getShipperById(int id) {
        return this.userShipperRepository.getShipperById(id);
    }

    @Override
    public boolean updateShipperInfo(UserShipper user, int id) {
        return this.userShipperRepository.updateShipperInfo(user, id);
    }
    
}
