package com.solutioncode.scrum.dto.request.auth;

import lombok.Data;

@Data
public class RequestLogin {
    public String email;
    public String password;
}
