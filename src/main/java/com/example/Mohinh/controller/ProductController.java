package com.example.Mohinh.controller;

import com.example.Mohinh.entities.Product;
import com.example.Mohinh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/view")
    public String viewProduct(Model model){
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        return "/index";
    }
//    @GetMapping("/")
//    public String viewProductTL(Model model){
//        List<Product> productList = productService.getAll();
//        model.addAttribute("productTL", productList);
//        return "/index";
//    }
}
