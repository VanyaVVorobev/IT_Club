package ru.vanyavvorobev.ITClub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vanyavvorobev.ITClub.entity.position.PositionEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private String uuid;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name")
    private String name;
    @Column(name = "avatar_link")
    private String avatarLink;
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "course")
    private Integer course;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "positionName")
    private Set<PositionEntity> userPositions;


}
