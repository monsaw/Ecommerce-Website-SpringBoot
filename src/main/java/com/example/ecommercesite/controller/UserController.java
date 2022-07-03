package com.example.ecommercesite.controller;


import com.example.ecommercesite.entity.User;
import com.example.ecommercesite.repository.UserRepository;
import com.example.ecommercesite.service.custom.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    UserServiceImpl userServiceImp;
    @GetMapping()
    public String viewHomePage(){
        return "index";
    }


    @GetMapping("/register")
    public String viewRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "authentication/signup_form";
    }


    @PostMapping("/registering")
    public String registering(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode(user.getPassword());
        user.setPassword(encoded);
//      repository.save(user);
      userServiceImp.save(user);

      return "authentication/register_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model){
//        List<User> allUsers = repository.findAll();
        List<User> allUsers = userServiceImp.findAllUser();
        model.addAttribute("allUsers" , allUsers);

        return "user/users";
    }

    @RequestMapping("/delete/user/{id}")
        public String deleteUser(@PathVariable(name = "id") Long id){
        User user = userServiceImp.findById(id);

//        repository.delete(user);
        userServiceImp.deleteUser(user);
    return "redirect:/list_users";}
}
