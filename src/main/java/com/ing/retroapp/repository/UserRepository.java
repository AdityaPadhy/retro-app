package com.ing.retroapp.repository;

import com.ing.retroapp.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by D-RB15LP on 13/02/2018.
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}

