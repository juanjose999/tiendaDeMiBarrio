package com.tienda.barrio.dto.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor

public class UserResponseDto {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public UserResponseDto(String id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
