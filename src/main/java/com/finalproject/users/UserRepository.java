package com.finalproject.users;

import com.finalproject.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findAll();

}

