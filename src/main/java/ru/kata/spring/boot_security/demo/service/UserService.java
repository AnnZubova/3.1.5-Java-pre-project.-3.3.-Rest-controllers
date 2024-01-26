package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> allUsers();

    public User  findById(Long id);


    public void  addUser(User user);

    public void updateUser(User user);
    User findByEmail(String username);

    public void removeUser(Long id);
    List<Role> roleList();

    @Override
    public UserDetails loadUserByUsername(String username) ;
}
