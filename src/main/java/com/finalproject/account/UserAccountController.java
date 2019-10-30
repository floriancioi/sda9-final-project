package com.finalproject.account;

import com.finalproject.entities.User;
import com.finalproject.entities.UserAccount;
import com.finalproject.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAccountController {

    private UserService userService;
    private UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserService userService, UserAccountService userAccountService) {
        this.userService = userService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/my_account")
    public String myAccount(Model model) {

        User authenticatedUser = userService.getAuthenticatedUser();
        model.addAttribute("authenticatedUser", authenticatedUser);

        UserAccount userAccount = userAccountService.findByUserId(authenticatedUser.getId());
        model.addAttribute("userAccount", userAccount);
        return "my_account";
    }
}
