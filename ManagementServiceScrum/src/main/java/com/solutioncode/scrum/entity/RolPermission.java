package com.solutioncode.scrum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "rol_permission")
@IdClass(PrimaryKeyRolPermission.class)
@Data
public class RolPermission {
    @Id
    @ManyToOne
    @JoinColumn(name = "rol_id",referencedColumnName = "id")
    private Rol rol;


    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "module_id",referencedColumnName = "module_id"),
            @JoinColumn(name = "operation_id",referencedColumnName = "operation_id")
    })
    private Permission permission;
}


class PrimaryKeyRolPermission implements Serializable {
    private Rol rol;
    private Permission permission;
}