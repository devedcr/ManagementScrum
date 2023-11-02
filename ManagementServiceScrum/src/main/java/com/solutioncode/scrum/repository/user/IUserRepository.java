package com.solutioncode.scrum.repository.user;

import com.solutioncode.scrum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    @Query(value ="select * from usuario where email=:email",nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);
}
