package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "epic")
@Data
public class Epic {
    @Id
    private Long id;

    @OneToMany(mappedBy = "epic")
    private List<Feature> features;

    @OneToOne
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private Task task;

}
