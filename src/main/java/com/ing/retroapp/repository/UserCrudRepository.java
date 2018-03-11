package com.ing.retroapp.repository;

import com.ing.retroapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by D-RB15LP on 11/03/2018.
 */
public interface UserCrudRepository extends MongoRepository<User, String> {
    void deleteByIdIn(List<String> ids);
}
