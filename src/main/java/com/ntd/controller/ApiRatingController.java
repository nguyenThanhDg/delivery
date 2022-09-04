/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.Rating;
import com.ntd.pojo.User;
import com.ntd.service.RatingService;
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
public class ApiRatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping(path = "/add-rating", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Rating> addRating(@RequestBody Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (u != null)
            try {
            String rate = params.get("rate");
            int shipperId = Integer.parseInt(params.get("shipperId"));
            if (this.ratingService.checkUserAndPro(u, shipperId).isEmpty()) {
                Rating r = this.ratingService.addRating(rate, shipperId, u);
                return new ResponseEntity<>(r, HttpStatus.CREATED);
            } else {
                Rating r = this.ratingService.updateRating(this.ratingService.checkUserAndPro(u, shipperId).get(0).getId(), rate);
                return new ResponseEntity<>(r, HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
