package com.example.ecommercesite.service.custom;

import com.example.ecommercesite.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> listAll();

    void save(Product product);

    Product get(Long id);

    void delete(Long id);
}
