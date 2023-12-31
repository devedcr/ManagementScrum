package com.solutioncode.scrum.controller;

import com.solutioncode.scrum.component.jwt.JwtManager;
import com.solutioncode.scrum.dto.request.auth.ReqRegisterDto;
import com.solutioncode.scrum.mapper.auth.AuthMapper;
import com.solutioncode.scrum.component.response.ApiResponse;
import com.solutioncode.scrum.component.response.SchemaResponse;
import com.solutioncode.scrum.configuration.security.CustomUser;
import com.solutioncode.scrum.constant.ApiRoute;
import com.solutioncode.scrum.dto.request.auth.ReqLoginDto;
import com.solutioncode.scrum.service.user.IUserService;
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
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private JwtManager jwtManager;
    private AuthenticationManager authenticationManager;
    private IUserService iUserService;

    @PostMapping(path = "/login")
    public ResponseEntity<SchemaResponse> login(@RequestBody ReqLoginDto body) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword()));
        var customUser = (CustomUser) authentication.getPrincipal();
        var jwt = jwtManager.generateJwt(customUser.getId().toString(), customUser.getUsername(), customUser.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.createSuccessResponse("User Login Successful", AuthMapper.mapToken(jwt))
        );
    }

    @PostMapping(path = "/register")
    public ResponseEntity<SchemaResponse> register(@RequestBody ReqRegisterDto body) {
        var user = iUserService.save(body.getName(), body.getEmail(), body.getPassword());
        var jwt = jwtManager.generateJwt(user.getId().toString(), user.getName(), user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.createSuccessResponse("User registered Successful", AuthMapper.mapToken(jwt))
        );
    }
}
