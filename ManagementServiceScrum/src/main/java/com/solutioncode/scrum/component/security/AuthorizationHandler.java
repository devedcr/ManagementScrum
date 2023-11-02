package com.solutioncode.scrum.component.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutioncode.scrum.component.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class AuthorizationHandler implements AccessDeniedHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        var authorizationFailed = ApiResponse.createErrorResponse("Authorization Failed");
        response.getOutputStream().println(objectMapper.writeValueAsString(authorizationFailed));
    }
}
