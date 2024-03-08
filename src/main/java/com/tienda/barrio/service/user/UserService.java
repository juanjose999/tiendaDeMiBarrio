package com.tienda.barrio.service.user;


import com.tienda.barrio.dto.user.UserDto;
import com.tienda.barrio.dto.user.UserResponseDto;
import com.tienda.barrio.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    Optional<UserResponseDto> findUserById(String id);
    User findByEmail(String email);
    UserResponseDto createUser(UserDto userDto);
    UserResponseDto createUserAdmin(UserDto userDto);

    UserResponseDto saveUser(UserDto userDto);

    Boolean updateUser(String id, UserDto userDto);

    Boolean deleteUserById(String id);
}
