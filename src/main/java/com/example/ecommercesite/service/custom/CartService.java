package com.example.ecommercesite.service.custom;

import com.example.ecommercesite.entity.Cart;
import com.example.ecommercesite.entity.Product;
import com.example.ecommercesite.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartService {

    List<Product> cartPerUser(Long id);

    void  deleteUserCart(User user);

    void saveToCart(Cart cart);

    void deleteByUP (User user, Product product);


}
