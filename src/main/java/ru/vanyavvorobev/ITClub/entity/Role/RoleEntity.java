package ru.vanyavvorobev.ITClub.entity.Role;

import ru.vanyavvorobev.ITClub.entity.Role.RoleNamesEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "role_table")
public class RoleEntity implements Serializable {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", unique = true)
    private RoleNamesEnum name;

    public RoleEntity() {}
    public RoleEntity(Integer id, RoleNamesEnum name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleNamesEnum getName() {
        return name;
    }

    public void setName(RoleNamesEnum name) {
        this.name = name;
    }

}
