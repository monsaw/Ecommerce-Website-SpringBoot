package com.example.ecommercesite.service.custom;

import com.example.ecommercesite.entity.User;
import com.example.ecommercesite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUser(){
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    public User findById(Long Id){
        User user = userRepository.findById(Id).get();
        return user;
    }

    @Override
    public void deleteUser(User user){
        userRepository.delete(user);
    }


}
