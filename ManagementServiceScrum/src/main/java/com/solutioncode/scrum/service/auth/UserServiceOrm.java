package com.solutioncode.scrum.service.auth;

import com.solutioncode.scrum.configuration.security.CustomUser;
import com.solutioncode.scrum.repository.user.IUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@AllArgsConstructor
@Service
public class UserServiceOrm implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceOrm.class);
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var boxUser = iUserRepository.findByEmail(email);
        if (boxUser.isEmpty()) throw new UsernameNotFoundException("email not found");
        return new CustomUser(
                boxUser.get().getId(),
                boxUser.get().getName(),
                boxUser.get().getEmail(),
                boxUser.get().getPassword(),
                Arrays.asList()
        );
    }

}
