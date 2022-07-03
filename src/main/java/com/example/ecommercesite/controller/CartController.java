package com.example.ecommercesite.controller;


import com.example.ecommercesite.entity.Cart;
import com.example.ecommercesite.entity.Product;
import com.example.ecommercesite.entity.User;
import com.example.ecommercesite.repository.UserRepository;
import com.example.ecommercesite.service.custom.CartServiceImpl;
import com.example.ecommercesite.service.custom.ProductServiceImpl;
import com.example.ecommercesite.service.custom.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping("/cart/{id}")
    public String cart(Model model, @PathVariable("id") Long id, Authentication authentication) {

//        User user = userRepository.findByEmail(authentication.getName());
        User user = userServiceImpl.findByEmail(authentication.getName());
        Product product = productServiceImpl.get(id);

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setQuantity(1);
        cart.setProduct(product);
        cartService.saveToCart(cart);

        return "redirect:/product";
    }

    @RequestMapping("/cart")
    public String cartProduct(Model model, Authentication authentication) {
//        User user = userRepository.findByEmail(authentication.getName());
        User user = userServiceImpl.findByEmail(authentication.getName());

        List<Product> cartProduct = cartService.cartPerUser(user.getId());
        model.addAttribute("allCart", cartProduct);
        System.out.println(user.getId());
        return "product/cart";
    }

    @RequestMapping("/checkup")
    public String check(Model model, Authentication authentication) {
//        User user = userRepository.findByEmail(authentication.getName());
        User user = userServiceImpl.findByEmail(authentication.getName());
        cartService.deleteUserCart(user);
        model.addAttribute("Success", "Congratulations, Your order has been processed!");
        return "product/cart";
//    return "redirect:/cart";}
    }

    @RequestMapping("/singledelete/{id}")
    public String checks(@PathVariable("id") Long id, Model model, Authentication authentication) {
//        User user = userRepository.findByEmail(authentication.getName());
        User user = userServiceImpl.findByEmail(authentication.getName());
        Product product = productServiceImpl.get(id);
        cartService.deleteByUP(user, product);
        return "redirect:/cart";
    }
}
