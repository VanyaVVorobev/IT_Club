package ru.vanyavvorobev.ITClub.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_table")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "user_uuid")
    private String uuid;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @Column(name = "user_login", nullable = false, unique = true)
    private String login;
    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_username", nullable = false, unique = true)
    private String username;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_avatar_link")
    private String avatarLink;
    @Column(name = "user_faculty")
    private String faculty;
    @Column(name = "user_course")
    private Integer course;
    @Column(name = "user_description")
    private String description;

    public UserEntity() {}
    public UserEntity(String uuid, String username, RoleEntity role, String login, String password, String name, String avatarLink, String faculty, Integer course, String description) {
        this.uuid = uuid;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
