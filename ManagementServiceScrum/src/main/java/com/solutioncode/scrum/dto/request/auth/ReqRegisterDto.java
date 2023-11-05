package com.solutioncode.scrum.dto.request.auth;

import lombok.Data;

@Data
public class ReqRegisterDto {
    private String name;
    private String email;
    private String password;
}
