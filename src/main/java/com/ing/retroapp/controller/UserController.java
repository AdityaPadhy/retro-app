package com.ing.retroapp.controller;

import com.ing.retroapp.model.User;
import com.ing.retroapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by D-RB15LP on 13/02/2018.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users", produces = "application/json")
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping(value = "/add")
    public Mono<User> addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
