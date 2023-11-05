package com.solutioncode.scrum.service.user;

import com.solutioncode.scrum.entity.User;
import com.solutioncode.scrum.repository.user.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private PasswordEncoder passwordEncoder;
    private IUserRepository iUserRepository;
    @Override
    public User save(String name, String email, String password) {
        String passEncrypted = passwordEncoder.encode(password);
        var user = User.builder().name(name).email(email).password(passEncrypted).build();
        iUserRepository.save(user);
        return user;
    }
}
