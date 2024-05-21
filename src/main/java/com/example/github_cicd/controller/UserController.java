package com.example.github_cicd.controller;

import com.example.github_cicd.models.User;
import com.example.github_cicd.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> getAll(){
        List<User> list = userRepository.findAll();
        return list;
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id){
        Optional<User> user =   userRepository.findById(id);
        return user;
    }

    @PostMapping("/user")
    public User create(@RequestBody User user){
        user = userRepository.save(user);
        return user;
    }
}
