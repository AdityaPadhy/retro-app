package com.ing.retroapp.controller;

import com.ing.retroapp.model.DeleteUsers;
import com.ing.retroapp.model.Sort;
import com.ing.retroapp.model.User;
import com.ing.retroapp.repository.UserCrudRepository;
import com.ing.retroapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D-RB15LP on 13/02/2018.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCrudRepository userCrudRepository;

    @GetMapping(value = "/users", produces = "application/json")
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping(value = "/add")
    public Flux<User> addUser(@RequestBody User user) {
        userCrudRepository.save(user);
        return getAllUsers();
    }

    @PostMapping(value = "/sort")
    public List<User> sortUser(@RequestBody Sort sort) {

        List<User> users = userCrudRepository.findAll();
        if (sort.getSortKey() != null) {
            users.sort((o1, o2) -> {
                if(sort.getSortKey().equalsIgnoreCase("asc")) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return o2.getName().compareTo(o1.getName());
                }
            });
        }

        return users;
    }

    @PostMapping(value = "/delete")
    public void deleteUsers(@RequestBody DeleteUsers users) {
         userCrudRepository.deleteByIdIn(users.getIds());
    }

}
