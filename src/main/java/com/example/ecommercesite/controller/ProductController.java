package com.example.ecommercesite.controller;


import com.example.ecommercesite.entity.Product;
import com.example.ecommercesite.service.custom.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;


    @RequestMapping("/product")
    public String viewHomePage(Model model){
        List<Product> listProducts = service.listAll();

        model.addAttribute("listProducts",listProducts);
        return "product/products";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
     Product product = new Product();
     model.addAttribute("product",product);
    return "product/new_product";}



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product, Model model){
        service.save(product);
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts",listProducts);

        return "product/index";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name ="id") Long id){
       ModelAndView mav = new ModelAndView("product/edit_product");

       Product product = service.get(id);
       mav.addObject("product" , product);


        return mav;}

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name="id") Long id){
        service.delete(id);

        return "redirect:/product";
    }

    @RequestMapping("/buy/{id}")
    public String buyProduct(@PathVariable(name="id") Long id, Model model){
//        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service.get(id);
        model.addAttribute("product", product);


        return "product/productdetails";}




}
