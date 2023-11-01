package com.solutioncode.scrum.configuration;

import com.solutioncode.scrum.component.security.AuthenticationHandler;
import com.solutioncode.scrum.component.security.AuthorizationHandler;
import com.solutioncode.scrum.constant.ApiRoute;
import com.solutioncode.scrum.service.auth.UserServiceOrm;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurity {

    private UserServiceOrm userServiceOrm;

    public static String[] WHITE_ROUTE = {
            ApiRoute.AUTH.concat("/**"),
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(WHITE_ROUTE).permitAll()
                .anyRequest().authenticated()
        );
        http.csrf(csrf -> csrf.disable());
        http.authenticationProvider(daoAuthenticationProvider());
        http.exceptionHandling(exceptionHandling -> exceptionHandling
                .authenticationEntryPoint(authenticationEntryPoint())
                .accessDeniedHandler(authorizationHandler())
        );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        var providerDao = new DaoAuthenticationProvider();
        providerDao.setUserDetailsService(userServiceOrm);
        providerDao.setPasswordEncoder(passwordEncoder());
        return providerDao;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new AuthenticationHandler();
    }

    @Bean
    public AuthorizationHandler authorizationHandler(){
        return new AuthorizationHandler();
    }

}
