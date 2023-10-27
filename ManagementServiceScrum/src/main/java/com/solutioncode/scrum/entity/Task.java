package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private  String description;

    @Column
    private Date dateStart;

    @Column
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "state_id",nullable = false,referencedColumnName = "id")
    private State state;
}
