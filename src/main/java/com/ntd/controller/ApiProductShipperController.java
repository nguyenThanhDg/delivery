/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.controller;

import com.ntd.pojo.ProductShipper;
import com.ntd.pojo.User;
import com.ntd.service.ProductShipperService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiProductShipperController {

    @Autowired
    private ProductShipperService productShipperService;

    @PostMapping(path = "/add-productShipper", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<ProductShipper> addProductShipper(@RequestBody Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (u != null)
            try {
            String content = params.get("content");
            int productId = Integer.parseInt(params.get("productId"));
            if (this.productShipperService.checkShipperAndPro(productId, u.getId()).isEmpty()) {
                ProductShipper r = this.productShipperService.addProductShipper(content, productId, u);
                System.out.println("them");
                return new ResponseEntity<>(r, HttpStatus.CREATED);
            } else {
                System.out.println("up");
                ProductShipper r = this.productShipperService.updateProductShipper(this.productShipperService.checkShipperAndPro(productId, u.getId()).get(0).getId(), content);
                return new ResponseEntity<>(r, HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/active/{prosId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void changeActive(@PathVariable(value = "prosId") int id) {
        this.productShipperService.active(id);
    }
    
    @PutMapping("/accept/{prosId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void changeAccept(@PathVariable(value = "prosId") int id) {
        this.productShipperService.accept(id);
    }
}
