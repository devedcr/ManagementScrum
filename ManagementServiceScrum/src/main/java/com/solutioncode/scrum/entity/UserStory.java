package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Entity
@Table(name = "user_story")
@Data
public class UserStory {

    @Id
    private Long id;

    @Column
    private String criterion;

    @Column(name = "commit_link")
    private String commitLink;

    @Column(name = "mockup_link")
    private String mockupLink;

    @Column(name = "story_point")
    private Long storyPoint;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "user_id",nullable = true,referencedColumnName = "user_id"),
            @JoinColumn(name = "proyect_id",nullable = true,referencedColumnName = "proyect_id")
    })
    private ProyectUser proyectUser;

    @ManyToOne
    @JoinColumn(name = "sprint_id",nullable = true,referencedColumnName = "id")
    private Sprint sprint;

    @ManyToOne
    @JoinColumn(name = "feature_id",nullable = true,referencedColumnName ="id")
    private Feature feature;


    @OneToOne
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private Task task;

}
