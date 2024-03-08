package com.tienda.barrio.security.jwt;


import com.tienda.barrio.dto.TokenDto;
import com.tienda.barrio.model.user.User;

public interface OperationJwt {
    TokenDto generateTokenDto(User user);
}
