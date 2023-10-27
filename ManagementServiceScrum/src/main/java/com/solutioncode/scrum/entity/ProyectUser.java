package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "proyect_user")
@IdClass(PrimaryKeyProyectUser.class)
@Data
public class ProyectUser {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "proyect_id",referencedColumnName = "id")
    private Proyect proyect;

    @ManyToOne
    @JoinColumn(name = "rol_id",referencedColumnName = "id")
    private Rol rol;

    @OneToMany(mappedBy = "proyectUser")
    private List<UserStory> userStories;

}

class PrimaryKeyProyectUser{
    private User user;
    private Proyect proyect;
}