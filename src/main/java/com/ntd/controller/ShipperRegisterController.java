/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.User;
import com.ntd.pojo.UserShipper;
import com.ntd.service.UserShipperService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author Admin
 */
@Controller
public class ShipperRegisterController {

    @Autowired
    private UserShipperService userShipperService;
    
    

    @GetMapping("/gotoshipper")
    public String goToShipper(Model model) {
        model.addAttribute("userShipper", new UserShipper());
        return "gotoshipper";
    }

    @PostMapping("/gotoshipper")
    public String registerShipper(Model model, @ModelAttribute(value = "userShipper")@Valid UserShipper userShipper,BindingResult r){
   
        User u  = (User) model.getAttribute("currentUser");
        userShipper.setId(u.getId());
        if (this.userShipperService.addUserShipper(userShipper) == true) {
            return "redirect:/";
        }
        model.addAttribute("errMsg", "Co loi xay ra vui long thu lai sau");
        return "gotoshipper";
    }
}
