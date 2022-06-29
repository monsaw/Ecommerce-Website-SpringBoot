package com.example.ecommercesite.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/heading")
    public String head(){

        return "header/headers";
    }
}
