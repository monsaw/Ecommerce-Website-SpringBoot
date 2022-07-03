package com.example.ecommercesite.service.custom;


import com.example.ecommercesite.entity.Cart;
import com.example.ecommercesite.entity.Product;
import com.example.ecommercesite.entity.User;
import com.example.ecommercesite.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Product> cartPerUser(Long id){
        return cartRepository.findByUserAndProduct(id);

    }

    @Override
    public void  deleteUserCart(User user){

        cartRepository.deleteFrom(user);
    }

    @Override
    public void saveToCart(Cart cart){
        cartRepository.save(cart);

    }

    @Override
    public void deleteByUP (User user, Product product){
        cartRepository.deleteCartsByUserAndProduct(user,product);
    }

}
