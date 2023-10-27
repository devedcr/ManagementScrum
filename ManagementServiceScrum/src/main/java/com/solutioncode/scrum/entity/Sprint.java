package com.solutioncode.scrum.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sprint")
@Data
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long nro;

    @Column
    private Date dateStart;

    @Column
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "proyect_id",nullable = false,referencedColumnName = "id")
    private Proyect proyect;

    @OneToMany(mappedBy = "sprint")
    private List<UserStory> userStories;

}
