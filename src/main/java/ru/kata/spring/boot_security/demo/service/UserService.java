package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> allUsers();

    public User getUserById(Long id);


    public void  addUser(User user);

    public void updateUser(Long id, User user);
    User findByEmail(String email);

    public void removeUser(Long id);

    @Override
    public UserDetails loadUserByUsername(String username) ;
}
