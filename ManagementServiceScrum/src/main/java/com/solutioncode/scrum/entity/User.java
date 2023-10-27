package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private  String password;

    @OneToMany(mappedBy = "user")
    private List<ProyectUser> proyectUsers;
}
