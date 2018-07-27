package com.ing.retroapp.repository;

import com.ing.retroapp.model.PostCard;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by D-RB15LP on 20/04/2018.
 */
public interface PostCardRepository extends MongoRepository<PostCard, String> {
}
