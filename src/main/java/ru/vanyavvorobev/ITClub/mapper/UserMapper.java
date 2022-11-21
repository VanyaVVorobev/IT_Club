package ru.vanyavvorobev.ITClub.mapper;

import ru.vanyavvorobev.ITClub.dto.old.UserResponse;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

public class UserMapper {
    public static UserResponse mapToUserDto(UserEntity entity) {
        var dto = new UserResponse();
        dto.setUuid(entity.getUuid());
        dto.setUsername(entity.getUsername());
        dto.setName(entity.getName());
        dto.setAvatarLink(entity.getAvatarLink());
        dto.setFaculty(entity.getFaculty());
        dto.setCourse(entity.getCourse());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}