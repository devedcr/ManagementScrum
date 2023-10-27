package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "proyect")
@Data
public class Proyect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne(mappedBy = "proyect")
    private Documentation documentation;

    @Column(name = "date_created")
    private Date dateCreated;
}
