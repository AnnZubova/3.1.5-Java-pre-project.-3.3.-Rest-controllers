package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class MyRestController {
    private final UserService userService;
    @Autowired
    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/admin")
    public ResponseEntity<List<User>> getAllUsers() { //+getUserForAdminPage
        List<User> list = userService.allUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/admin")
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView();//+
        modelAndView.setViewName("admin");
        return modelAndView;
    }
    @GetMapping("/user")
    public ModelAndView userPage() {
        ModelAndView modelAndView = new ModelAndView();//+
        modelAndView.setViewName("user");
        return modelAndView;
    }
    @GetMapping("/api/admin/{id}")
    public User getUserById(@PathVariable  Long id) {
        return userService.findById(id);
    }

    @GetMapping("/api/roles")
    public ResponseEntity<List<Role>> getAllRoles() { //++
        return new ResponseEntity<>(userService.roleList(), HttpStatus.OK);
    }
    @GetMapping("/api/user")
    public ResponseEntity<User> getUser(Principal principal) {// +
        return new ResponseEntity<>(userService.findByEmail(principal.getName()), HttpStatus.OK);
    }


    @PostMapping("/api/admin")
    public ResponseEntity<User> saveNewUser(@RequestBody User user) { //addUserAction
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/admin")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/admin/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
