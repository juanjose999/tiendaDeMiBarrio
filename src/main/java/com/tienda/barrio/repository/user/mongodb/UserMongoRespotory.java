package com.tienda.barrio.repository.user.mongodb;

import com.tienda.barrio.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRespotory extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
