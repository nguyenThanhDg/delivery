/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service;

import com.ntd.pojo.Rating;
import com.ntd.pojo.User;
import java.util.List;

/**
 *
 * @author Admin
 */

public interface RatingService {
    Rating addRating(String content, int shipperId, User creator);
    List<Rating> checkUserAndPro(User user, int shipperId);
    Rating updateRating(int id,String content);
    long avgRating(int id);
}
