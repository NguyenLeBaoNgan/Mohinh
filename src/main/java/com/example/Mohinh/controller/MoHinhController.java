package com.example.Mohinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MoHinhController {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/about")
    public String about1(){
        return "about";
    }
    @RequestMapping("/console")
    public String console1(){
        return "console";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
    @RequestMapping("/faqs")
    public String faqs(){
        return "faqs";
    }
    @RequestMapping("/gaminggear")
    public String gaminggear(){
        return "gaminggear";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/offer")
    public String offer(){
        return "offer";
    }
    @RequestMapping("/pccomponent")
    public String pccomponent(){
        return "pccomponent";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/shipping")
    public String shipping(){
        return "shipping";
    }
    @RequestMapping("/single")
    public String single(){
        return "single";
    }
    @RequestMapping("/term")
    public String term(){
        return "terms";
    }
    @RequestMapping("/wishlist")
    public String wishlist(){
        return "wishlist";
    }


}
