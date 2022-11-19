package ru.vanyavvorobev.ITClub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String uuid;
    private String name;
    private String avatarLink;
    private String faculty;
    private Integer course;
    private String description;
    private List<String> positions;
}