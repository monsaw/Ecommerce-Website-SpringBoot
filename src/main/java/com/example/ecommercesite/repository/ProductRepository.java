package com.example.ecommercesite.repository;

import com.example.ecommercesite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
