/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.repository;

import com.ntd.pojo.User;
import com.ntd.pojo.UserShipper;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserShipperRepository {
    boolean addUserShipper(UserShipper userShipper);
    boolean deleteGotoShipper(int id);
    UserShipper getShipperById(int id);
    boolean updateShipperInfo(UserShipper shipper, int id);
}
