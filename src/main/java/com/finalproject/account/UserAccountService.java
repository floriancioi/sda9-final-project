package com.finalproject.account;

import com.finalproject.entities.User;
import com.finalproject.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public void save(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }

    public UserAccount findByUserId(long id) {
        return userAccountRepository.findByUserId(id);
    }
}
