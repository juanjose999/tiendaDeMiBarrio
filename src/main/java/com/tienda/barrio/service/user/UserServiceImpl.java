package com.tienda.barrio.service.user;


import com.tienda.barrio.dto.user.UserDto;
import com.tienda.barrio.dto.user.UserMapper;
import com.tienda.barrio.dto.user.UserResponseDto;
import com.tienda.barrio.model.user.RolesEnum;
import com.tienda.barrio.model.user.User;
import com.tienda.barrio.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userRepository.getAllUsers().forEach(user -> userResponseDtos.add(UserMapper.user_To_UserResponseDto(user)));
        return userResponseDtos;
    }

    @Override
    public Optional<UserResponseDto> findUserById(String id) {
        UserResponseDto user = UserMapper.user_To_UserResponseDto(userRepository.findUserById(id));
        return Optional.ofNullable(user);
    }

    @Override
    public User findByEmail(String email) {
        User userFound = userRepository.findByEmail(email).get();
        if (userFound != null){
            return userFound;
        }else {
            return null;
        }
    }

    @Override
    public UserResponseDto createUser(UserDto userDto) {
        return UserMapper.user_To_UserResponseDto(userRepository.createUser(UserMapper.userDto_To_User(userDto)));
    }

    @Override
    public UserResponseDto createUserAdmin(UserDto userDto) {
        User userAdmin = UserMapper.userDto_To_User(userDto);
        userAdmin.addRole(RolesEnum.ADMIN);
        return UserMapper.user_To_UserResponseDto(userRepository.createUser(userAdmin));
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        return UserMapper.user_To_UserResponseDto(userRepository.saveUser(UserMapper.userDto_To_User(userDto)));
    }

    @Override
    public Boolean updateUser(String id, UserDto userDto) {
        return userRepository.updateUser(id, UserMapper.userDto_To_User(userDto));
    }

    @Override
    public Boolean deleteUserById(String id) {
        return userRepository.deleteUserById(id);
    }
}
