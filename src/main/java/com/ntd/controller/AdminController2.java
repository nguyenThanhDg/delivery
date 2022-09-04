/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.Product;
import com.ntd.pojo.ProductShipper;
import com.ntd.pojo.User;
import com.ntd.pojo.UserShipper;
import com.ntd.service.ProductService;
import com.ntd.service.ProductShipperService;
import com.ntd.service.StatsService;
import com.ntd.service.UserService;
import com.ntd.service.UserShipperService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/admin2")
public class AdminController2 {

    @Autowired
    private UserService userService;

    @Autowired
    private StatsService statsService;

    @Autowired
    private UserShipperService userShipperService;

    @RequestMapping("/")
    public String admin(Model model) {
        model.addAttribute("uGoToShipper", this.userService.getUsersGoShipper());
        System.out.println(this.userService.getUsersGoShipper());
        return "listgotoshipper";
    }

    @RequestMapping("/shipper")
    public String shipper(Model model) {
        model.addAttribute("shipper", this.userService.getUserShipper());
        return "listadminshipper";
    }

    @RequestMapping("/shipper/{shipperId}")
    public String updateShipperView(Model model, @PathVariable(value = "shipperId") int shipperId) {
        model.addAttribute("shipper", this.userService.getUserById(shipperId));
        model.addAttribute("shipperInShipper", this.userShipperService.getShipperById(shipperId));
        return "updateShipper";
    }

    @PostMapping("/shipper/{shipperId}")
    public String updateShipper(Model model, @ModelAttribute(value = "shipper") User shipper, @PathVariable(value = "shipperId") int shipperId) {
        if (this.userService.updateUser(shipper, shipperId) == true) {
            return "redirect:/admin/shipper";
        }
        return "redirect:/";
    }

    @RequestMapping("/stats/products")
    public String statsProduct(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null, toDate = null;

        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        model.addAttribute("products", this.statsService.stats(kw, fromDate, toDate));
        return "statsProduct";
    }

    @RequestMapping("/stats/month")
    public String stats(Model model,
            @RequestParam(value = "year", defaultValue = "2022") int year) {
        model.addAttribute("revenuStats", this.statsService.revenueStats(year));
        return "statsMonth";
    }
}
