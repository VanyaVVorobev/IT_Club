package ru.vanyavvorobev.ITClub.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @Column(name = "uuid")
    private String uuid;
    @ManyToOne(fetch = FetchType.LAZY)
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


    @ManyToMany
    @JoinTable(
            name = "user_position",
            joinColumns = @JoinColumn(name = "user_uuid"),
            inverseJoinColumns = @JoinColumn(name = "position_name")
    )
    private Set<PositionEntity> userPositions;

    public UserEntity() {}
    public UserEntity(String uuid, RoleEntity role, String login, String password, String name, String avatarLink, String faculty, Integer course, String description) {
        this.uuid = uuid;
        this.role = role;
        this.login = login;
        this.password = password;
        this.name = name;
        this.avatarLink = avatarLink;
        this.faculty = faculty;
        this.course = course;
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PositionEntity> getUserPositions() {
        return userPositions;
    }

    public void setUserPositions(Set<PositionEntity> userPositions) {
        this.userPositions = userPositions;
    }
}
