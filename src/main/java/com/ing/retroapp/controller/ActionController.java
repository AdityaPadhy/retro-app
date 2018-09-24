package com.ing.retroapp.controller;

import com.ing.retroapp.model.Action;
import com.ing.retroapp.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by D-RB15LP on 13/09/2018.
 */
@RestController
@RequestMapping("/actions")
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<Action> getAllActions(@PathVariable("id") String id) {
        return actionRepository.findAll();
    }

    @PutMapping(value = "/add")
    public void addAction(@RequestBody Action card) {
        actionRepository.save(card);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteAction(@PathVariable("id") String id) {
        actionRepository.deleteById(id);
    }

    @PostMapping(value = "/update")
    public void updateAction(@RequestBody Action card) {
        actionRepository.save(card);
    }
}
