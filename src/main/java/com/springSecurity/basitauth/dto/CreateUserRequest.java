package com.springSecurity.basitauth.dto;

import com.springSecurity.basitauth.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
) {

}
