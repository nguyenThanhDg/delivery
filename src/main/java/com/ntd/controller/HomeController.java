/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.service.ProductService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private ProductService productService;
    
    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }
    @GetMapping("/")
    public String index(Model model,@RequestParam(required = false)Map<String, String> params, HttpSession session) {
        String kw = params.getOrDefault("kw",null);
        int page = Integer.parseInt(params.getOrDefault("page","1"));
        String cateId = params.get("cateId");
        if (cateId == null){
            model.addAttribute("products",this.productService.getProducts(kw, page));
        }
        model.addAttribute("counter", this.productService.countProduct());
        return "index";
    }
    
    
}
