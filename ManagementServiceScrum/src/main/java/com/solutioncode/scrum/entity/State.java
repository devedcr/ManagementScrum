package com.solutioncode.scrum.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "state")
@Data
public class State {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String description;
}
