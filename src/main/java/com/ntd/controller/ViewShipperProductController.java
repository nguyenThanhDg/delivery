/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.ProductShipper;
import com.ntd.pojo.User;
import com.ntd.service.ProductService;
import com.ntd.service.ProductShipperService;
import com.ntd.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ViewShipperProductController {
    @Autowired
    private ProductShipperService productShipperService;
    
    @RequestMapping("/products/view/{productId}")
    public String viewShipper(Model model, @PathVariable(value = "productId") int productId) {
        model.addAttribute("shippers",this.productShipperService.getByProductId(productId));
        model.addAttribute("active", this.productShipperService.getActive(productId));
        return "viewShipper";
    }
}
