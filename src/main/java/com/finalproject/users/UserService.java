package com.finalproject.users;

import com.finalproject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void addUser(User user) {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));

        userRepository.save(user);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byName = userRepository.findByUserName(username);
        if (!byName.isPresent()) {
            throw new UsernameNotFoundException("Username is invalid");
        }
        User user = byName.get();
       return new org.springframework.security.core.userdetails.User(user.getFirstName(),user.getPassword(), getAuthority(user));
    }

    private List getAuthority(User user) {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + "USER")); //TODO replase USER with user.getRole() which will return the role of an user;
    }

    public User getAuthenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        Optional<User> user = userRepository.findByUserName(userDetails.getUsername());
        return user.get();
    }

    public long getIdByUserName(String userName){
        Optional<User> byUserName = userRepository.findByUserName(userName);
        return byUserName.get().getId();
    }

}
