package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "documentation")
@Data
public class Documentation {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String content;

    @OneToOne
    @JoinColumn(name = "proyect_id",referencedColumnName = "id")
    private Proyect proyect;

}
