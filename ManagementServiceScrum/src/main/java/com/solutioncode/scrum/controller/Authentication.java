package com.solutioncode.scrum.controller;


import com.solutioncode.scrum.component.response.ApiResponse;
import com.solutioncode.scrum.component.response.SchemaResponse;
import com.solutioncode.scrum.constant.ApiRoute;
import com.solutioncode.scrum.dto.request.auth.RequestLogin;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = ApiRoute.AUTH)
@AllArgsConstructor
public class Authentication {

    private static final Logger logger = LoggerFactory.getLogger(Authentication.class);
    private AuthenticationManager authenticationManager;

    @PostMapping(path = "/login")
    public ResponseEntity<SchemaResponse> saludo(@RequestBody RequestLogin body) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword()));
        authentication.getPrincipal();
        logger.info(authentication.getPrincipal().toString());
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.createSuccessResponse("User Login Successful"));
    }

}
