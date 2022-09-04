/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.Product;
import com.ntd.pojo.User;
import com.ntd.service.ProductService;
import com.ntd.service.ProductShipperService;
import com.ntd.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductShipperService productShipperService;
    
    @Autowired
    private UserService userService;


    @GetMapping("/products/{productId}")
    public String detail(Model model, @PathVariable(value = "productId") int productId, HttpSession session) {
        model.addAttribute("product", this.productService.getProductById(productId));
        User u = (User) session.getAttribute("currentUser");
        if (u != null) {
            int a = this.productShipperService.checkShipperAndPro(productId, u.getId()).size() -1 ;
            if (a >= 0)
                model.addAttribute("cost", this.productShipperService.checkShipperAndPro(productId, u.getId()).get(a));
            if(this.userService.checkShiper(u.getId()) == true)
            model.addAttribute("shipper", 1);
        }
        return "detail";
    }

    @GetMapping("/add/product")
    public String addProductView(Model model) {
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/add/product")
    public String addProduct(Model model, @ModelAttribute(value = "product") Product product) {
        User u = (User) model.getAttribute("currentUser");
        product.setCustomer(u);
        if (this.productService.addOrUpdate(product) == true) {
            return "redirect:/";
        }
        model.addAttribute("errMsg", "Co loi xay ra vui long thu lai sau");
        return "redirect:/add/product";
    }

    @GetMapping("/products")
    public String productCustomer(Model model) {
        User authUser = (User) model.getAttribute("currentUser");
        model.addAttribute("product", this.productService.getProductsByUser(authUser));
        return "productCustomer";
    }

    @RequestMapping("/products/update/{productId}")
    public String updateShipperView(Model model, @PathVariable(value = "productId") int productId) {
        model.addAttribute("product", this.productService.getProductById(productId));
        return "updateProduct";
    }

    @PostMapping("/products/update/{productId}")
    public String updateShipper(Model model, @ModelAttribute(value = "product") Product product, @PathVariable(value = "productId") int productId) {
        if (this.productService.updateProduct(product, productId) == true) {
            return "redirect:/products/";
        }
        return "redirect:/";
    }
}
