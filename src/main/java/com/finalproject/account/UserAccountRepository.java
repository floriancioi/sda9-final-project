package com.finalproject.account;

import com.finalproject.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository  extends CrudRepository<UserAccount, Long> {
    UserAccount findByUserId(long id);
}
