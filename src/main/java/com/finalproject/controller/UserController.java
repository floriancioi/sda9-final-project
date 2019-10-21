package com.finalproject.controller;

import com.finalproject.entities.User;
import com.finalproject.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        return "index";
    }

    @GetMapping("/userslist")
    public String showLogInForm(Model model) {
     List<User> users = userService.findAll();
     User u = new User();
     u.setName("a");
     u.setPassword("a");
     userService.addUser(u);
      model.addAttribute("users", users);
      return "users-list";
    }

    @GetMapping("/home")
    public String homePage(User user) {
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(User user) {
        return "user-register";
    }



    @GetMapping("/contact")
    public String contactForm(User user) {
        return "user-contact";
    }



}
