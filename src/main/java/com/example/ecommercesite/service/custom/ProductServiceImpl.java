package com.example.ecommercesite.service.custom;

import com.example.ecommercesite.entity.Product;
import com.example.ecommercesite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> listAll(){

        return repo.findAll();
    }

    @Override
    public void save(Product product){

        repo.save(product);
    }

    @Override
    public Product get(Long id){

        return repo.findById(id).get();
    }

    @Override
    public void delete(Long id){

        repo.deleteById(id);
    }
}
