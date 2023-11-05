package com.solutioncode.scrum.filter;

import com.solutioncode.scrum.component.jwt.JwtManager;
import com.solutioncode.scrum.configuration.security.CustomUser;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    public static Logger logger = LoggerFactory.getLogger(JwtFilter.class);
    public static String authBearer = "Bearer ";
    private JwtManager jwtManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (Objects.isNull(authorization) || !authorization.startsWith(authBearer)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorization.replace(authBearer, "").trim();
        if (!jwtManager.validate(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        setAuthentication(token);
        filterChain.doFilter(request, response);
    }

    private void setAuthentication(String token) {
        Claims claims = jwtManager.parseClaims(token);
        CustomUser userDetails = new CustomUser(claims.get("name", String.class), "", Arrays.asList());
        userDetails.setId(Long.parseLong(claims.get("sub", String.class)));
        userDetails.setEmail(claims.get("email", String.class));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
