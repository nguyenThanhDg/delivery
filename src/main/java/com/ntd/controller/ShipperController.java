/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.User;
import com.ntd.service.ProductShipperService;
import com.ntd.service.RatingService;
import com.ntd.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/shipper")
public class ShipperController {

    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;
    
    @Autowired
    private ProductShipperService productShipperService;

    @GetMapping("/")
    public String listShipper(Model model, @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("shipper", this.userService.getUserShipper(page));
        model.addAttribute("counter", this.userService.countUserShipper());
        System.out.println(this.userService.countUserShipper());
        return "listShipper";
    }

    @GetMapping("/{shipperId}")
    public String detail(Model model, @PathVariable(value = "shipperId") int shipperId) {
        User user = (User) model.getAttribute("currentUser");
        if (user != null) {
            model.addAttribute("rate", 0);
            model.addAttribute("avg", this.ratingService.avgRating(shipperId));
        } else {
            model.addAttribute("rate", -1);
        }

        if (this.userService.checkShiper(shipperId)) {
            model.addAttribute("shipperDetail", this.userService.getUserById(shipperId));
            return "shipperDetail";
        } else {
            return "redirec:/listShipper";
        }
    }
    
    @GetMapping("/products")
    public String productShipper(Model model) {
        User authUser = (User) model.getAttribute("currentUser");
        model.addAttribute("product", this.productShipperService.getByShipperId(authUser.getId()));
        return "productShipper";
    }
}
