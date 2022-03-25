package com.arshaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arshaa.entity.User;
import com.arshaa.service.UserService;

@RestController
@RequestMapping("/login-service")
@CrossOrigin("*")
public class LoginController {

    @Autowired(required = true)
    private UserService service;

    @GetMapping("/users")
    private List<User> getUsers() {
        return service.findUsers();
    }

    @PostMapping("/users")
    private int saveUsers(@RequestBody User user) {
        service.save(user);
        return user.getUserId();
    }
}
