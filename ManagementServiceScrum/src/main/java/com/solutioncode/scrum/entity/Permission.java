package com.solutioncode.scrum.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "permission")
@IdClass(PrimaryKeyPermission.class)
@Data
public class Permission {

    @Id
    @ManyToOne
    @JoinColumn(name = "module_id",referencedColumnName = "id")
    private Module module;

    @Id
    @ManyToOne
    @JoinColumn(name = "operation_id",referencedColumnName = "id")
    private Operation operation;

    @OneToMany(mappedBy = "permission")
    private List<RolPermission> rolPermissions;

}

class PrimaryKeyPermission implements Serializable {
    private Module module;
    private Operation operation;
}

