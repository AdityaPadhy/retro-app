package com.ing.retroapp.controller;

import com.ing.retroapp.model.PostCard;
import com.ing.retroapp.repository.PostCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by D-RB15LP on 20/04/2018.
 */
@RestController
@RequestMapping("/postcard")
public class PostCardController {

    @Autowired
    private PostCardRepository postCardRepository;

    @GetMapping(value = "/cards", produces = "application/json")
    public List<PostCard> getAllCards() {
        return postCardRepository.findAll();
    }

    @PutMapping(value = "/add")
    public void addCard(@RequestBody PostCard card) {
        postCardRepository.save(card);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        postCardRepository.deleteById(id);
    }

    @PostMapping(value = "/update")
    public void updateCard(@RequestBody PostCard card) {
        postCardRepository.save(card);
    }
}
