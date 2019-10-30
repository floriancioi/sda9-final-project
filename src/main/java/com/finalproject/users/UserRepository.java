package com.finalproject.users;

import com.finalproject.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
interface UserRepository extends CrudRepository<User, Long> {

   Optional<User> findByUserName(@Param("userName") String username);

}

