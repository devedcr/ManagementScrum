package com.solutioncode.scrum.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutioncode.scrum.component.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class AuthenticationHandler implements AuthenticationEntryPoint {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        var authenticationFailed = ApiResponse.createErrorResponse("Authentication Failed");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getOutputStream().println(objectMapper.writeValueAsString(authenticationFailed));
    }
}
