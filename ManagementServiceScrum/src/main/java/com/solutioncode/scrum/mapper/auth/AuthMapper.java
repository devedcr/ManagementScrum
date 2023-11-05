package com.solutioncode.scrum.mapper.auth;

import com.solutioncode.scrum.dto.response.auth.ResTokenDto;

public class AuthMapper {
    public static ResTokenDto mapToken(String jwt) {
        return ResTokenDto.builder()
                .token(jwt)
                .build();
    }
}
