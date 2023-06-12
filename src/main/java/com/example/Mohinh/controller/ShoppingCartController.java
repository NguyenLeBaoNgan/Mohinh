package com.example.Mohinh.controller;

import com.example.Mohinh.entities.CartItem;
import com.example.Mohinh.entities.Product;
import com.example.Mohinh.service.ProductService;
import com.example.Mohinh.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @GetMapping("view1")
    public String index1 (Model model){

        return "product-list";
    }
    @GetMapping("view")
    public String viewCart(Model model){
        model.addAttribute("all_items_in_shoppingcart", shoppingCartService.getAllItems());
        model.addAttribute("total_amount", shoppingCartService.getAmount());
        return "view_shoppingcart";
    }

    @GetMapping("add/{id}")
    public String addItem(@PathVariable("id") Integer id){
        Product product = productService.getProductId(Long.valueOf(id));
        if(product !=null){
            CartItem item =  new CartItem();
            item.setIdsp(Math.toIntExact(product.getIdsp()));
            item.setTensp(product.getTensp());
            item.setPrice(product.getPrice());
            item.setSoluong(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shoppingcart/view";
    }
    @GetMapping("clear")
    public String clearCart(){
        shoppingCartService.clear();
        return "redirect:/shoppingcart/view";
    }
    @GetMapping("remove/{id}")
    public String removeItem(@PathVariable("id") Integer id){
        shoppingCartService.remove(id);
        return "redirect:/shoppingcart/view";
    }
    @PostMapping("update/{id}")
    public String updateItem(@RequestParam("id") Integer id, @RequestParam("soluong")Integer soluong){
        shoppingCartService.update(id, soluong);
        return "redirect:/shoppingcart/view";
    }
}
