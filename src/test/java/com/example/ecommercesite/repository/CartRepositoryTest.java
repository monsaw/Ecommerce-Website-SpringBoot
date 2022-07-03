package com.example.ecommercesite.repository;

import com.example.ecommercesite.entity.Cart;
import com.example.ecommercesite.entity.Product;
import com.example.ecommercesite.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.Assert.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @Test
    public void testAddOneCartItem(){


        Product product = testEntityManager.find(Product.class, 2L);
        User user = testEntityManager.find(User.class, 2L);


        Cart cartItem = new Cart();
        cartItem.setProduct(product);
        cartItem.setQuantity(3);
        cartItem.setUser(user);

        Cart carts = cartRepository.save(cartItem);

        assertTrue(carts.getId() > 0);
    }

    @Test
    public void testGetCardItemByCustomer(){

        User user = new User();
        user.setId(2L);

        List<Cart> cart = cartRepository.findByUser(user);
        assertEquals(4,cart.size());


    }

}