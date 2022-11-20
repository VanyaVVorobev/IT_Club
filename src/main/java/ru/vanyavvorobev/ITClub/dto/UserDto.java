package ru.vanyavvorobev.ITClub.dto;

import java.util.List;

public class UserDto {
    private String uuid;
    private String name;
    private String avatarLink;
    private String faculty;
    private Integer course;
    private String description;
    private List<String> positions;

    public UserDto() {};
    public UserDto(String uuid, String name, String avatarLink, String faculty, Integer course, String description, List<String> positions) {
        this.uuid = uuid;
        this.name = name;
        this.avatarLink = avatarLink;
        this.faculty = faculty;
        this.course = course;
        this.description = description;
        this.positions = positions;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }
}
