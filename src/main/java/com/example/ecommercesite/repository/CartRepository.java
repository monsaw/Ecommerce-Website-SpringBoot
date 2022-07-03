package com.example.ecommercesite.repository;

import com.example.ecommercesite.entity.Cart;
import com.example.ecommercesite.entity.Product;
import com.example.ecommercesite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUser(User user);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cart cart WHERE cart.user = ?1")
    void deleteFrom(User user);


    @Transactional
    @Modifying
   @Query("DELETE FROM Cart cart WHERE cart.user = ?1 AND cart.product = ?2")
    void deleteCartsByUserAndProduct(User user , Product product);

    @Query("SELECT product FROM Product product " +
            "WHERE product.id IN (SELECT" +
            " cart.product FROM Cart cart " +
            "WHERE cart.user.id = :id)")
    List<Product> findByUserAndProduct(Long id);


}
