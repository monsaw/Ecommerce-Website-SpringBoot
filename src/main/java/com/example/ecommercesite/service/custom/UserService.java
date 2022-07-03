package com.example.ecommercesite.service.custom;

import com.example.ecommercesite.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User findByEmail(String email);

    void save(User user);

    List<User> findAllUser();

    User findById(Long Id);

    void deleteUser(User user);
}
