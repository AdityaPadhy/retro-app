package com.ing.retroapp.repository;

import com.ing.retroapp.model.Action;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by D-RB15LP on 13/09/2018.
 */
public interface ActionRepository extends MongoRepository<Action, String> {
}
