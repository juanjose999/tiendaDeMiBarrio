package com.tienda.barrio.controller.user;

import com.tienda.barrio.dto.user.UserDto;
import com.tienda.barrio.dto.user.UserResponseDto;
import com.tienda.barrio.service.user.UserService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.tienda.barrio.utils.Constants.ADMIN_ROLE;


@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        //loadSampleUsers();
    }

    public void loadSampleUsers() {
        LocalDate fecha = LocalDate.of(2024, 2, 22);
        UserDto userEntity = new UserDto("Juan Jose", " ortega", fecha, "juan@gmail.com", "hi38dz7");
        userService.createUser(userEntity);
        UserDto adminUser= new UserDto("Super", "Admin", fecha, "superadmin@gmail.com", "xx9dot7");
        userService.createUserAdmin(adminUser);
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        try {
            List<UserResponseDto> users = userService.getAllUsers();
            System.out.println("Number of user response DTOs: " + users.size());
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            System.err.println("Error in getAllUser controller: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserResponseDto>> findUserById(@PathVariable  String userId){
        try{
            return new ResponseEntity<>(userService.findUserById(userId),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity("the user " + userId + " doesn't in the data base.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RolesAllowed(ADMIN_ROLE)
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.saveUser(userDto),HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    @RolesAllowed(ADMIN_ROLE)
    public ResponseEntity<Boolean> updateUser(@PathVariable String userId, @RequestBody UserDto userDto){
        try{
            Boolean isUpdateUser = userService.updateUser(userId, userDto);
            if(isUpdateUser){
                return new ResponseEntity("the user update is ok." , HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("the user " + userId + " doesn't in the data base." , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    @RolesAllowed(ADMIN_ROLE)
    public ResponseEntity<Boolean> deleteUser(@PathVariable String userId){
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }
}
