package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "rol")
    private List<ProyectUser> users;

    @OneToMany(mappedBy = "rol")
    private List<RolPermission> rolPermissions;

}
