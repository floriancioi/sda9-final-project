package com.finalproject.controller;

import com.finalproject.account.UserAccountService;
import com.finalproject.entities.User;
import com.finalproject.entities.UserAccount;
import com.finalproject.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;
    private UserAccountService userAccountService;

    @Autowired
    public UserController(UserService userService, UserAccountService userAccountService){
        this.userService = userService;
        this.userAccountService= userAccountService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        return "index";
    }

    @GetMapping("/userslist")
    public String showLogInForm(Model model) {
     Iterable<User> users = userService.findAll();
     User u = new User();
     u.setFirstName("a");
     u.setLastName("a");
     u.setPassword("a");
     u.setPhoneNumber("a");
     u.setEmail("a@a.ro");
     u.setUserName("a");

     userService.addUser(u);
      model.addAttribute("users", users);
      return "users-list";
    }

    @GetMapping("/home")
    public String homePage(User user) {
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        User user=new User();
        model.addAttribute("user",user);
        return "user-register";
    }
    @PostMapping("/register")
    public String register(User user){
        userService.addUser(user);
        long id = userService.getIdByUserName(user.getUserName());
        createAccount(id,"ROPIGGY123"); //TODO generate unique Iban

        return "user-login";
    }

    private void createAccount(long userId, String iban) {
        UserAccount userAccount = new UserAccount();
        userAccount.setIban(iban);
        userAccount.setSold(0);
        userAccount.setUserId(userId);
        userAccountService.save(userAccount);
    }

    @GetMapping("/contact")
    public String contactForm(User user) {
        return "user-contact";
    }

    @GetMapping("/user-account")
    public String userAccountForm(User user) {
        return "user-account";
    }




}
