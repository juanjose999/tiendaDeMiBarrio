package com.tienda.barrio.repository.user;

import com.tienda.barrio.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();

    User findUserById(String id);
    Optional<User> findByEmail(String email);
    User createUser(User user);

    User saveUser(User user);

    Boolean updateUser(String id, User user);

    Boolean deleteUserById(String id);
}
