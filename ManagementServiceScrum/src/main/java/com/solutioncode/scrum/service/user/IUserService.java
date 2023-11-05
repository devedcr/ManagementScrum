package com.solutioncode.scrum.service.user;

import com.solutioncode.scrum.entity.User;

public interface IUserService {
    User save(String name, String email, String password);
}
