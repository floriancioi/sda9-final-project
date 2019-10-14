package com.finalproject.controller;

import com.finalproject.entities.User;
import com.finalproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        return "index";
    }

    @GetMapping("/userslist")
    public String showLogInForm(Model model) {
     List<User> users = userRepository.findAll();
     User u = new User();
     u.setName("firstuser");
     u.setPassword("aaa");
     userRepository.save(u);
      model.addAttribute("users", users);
      return "users-list";
    }


}
