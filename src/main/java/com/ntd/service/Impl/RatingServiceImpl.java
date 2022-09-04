/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.service.Impl;

import com.ntd.pojo.Rating;
import com.ntd.pojo.User;
import com.ntd.repository.RatingRepository;
import com.ntd.service.RatingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating addRating(String content, int shipperId, User creator) {
        return this.ratingRepository.addRating(content, shipperId, creator);
    }

    @Override
    public List<Rating> checkUserAndPro(User user, int shipperId) {
        return this.ratingRepository.checkUserAndPro(user, shipperId);
    }

    @Override
    public Rating updateRating(int id, String string) {
        return this.ratingRepository.updateRating(id, string);
    }

    @Override
    public long avgRating(int id) {
        return this.ratingRepository.avgRating(id);
    }
    
}
