package com.ing.retroapp.controller;

import com.ing.retroapp.model.DeleteUsers;
import com.ing.retroapp.model.Sort;
import com.ing.retroapp.model.User;
import com.ing.retroapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    public Flux<User> addUser(@RequestBody User user) {
        userRepository.save(user);
        return getAllUsers();
    }

    @PostMapping(value = "/sort")
    public Flux<User> sortUser(@RequestBody Sort sort) {
        Flux<User> users = getAllUsers().sort((o1, o2) -> {
            if(sort.getSortKey().equalsIgnoreCase("asc")) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        });

        return users;
    }

    @DeleteMapping(value = "/delete")
    @Transactional
    public void deleteUsers(@RequestBody DeleteUsers users) {
        Mono<User> user = userRepository.findById(users.getIds().get(0));
        for (String id : users.getIds())
        userRepository.deleteById(id);
    }
}
