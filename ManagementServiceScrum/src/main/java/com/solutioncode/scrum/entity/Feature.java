package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "feature")
@Data
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "epic_id",referencedColumnName = "id")
    private Epic epic;

    @OneToOne
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private Task task;

    @OneToMany(mappedBy = "feature")
    private List<UserStory> userStories;
}
