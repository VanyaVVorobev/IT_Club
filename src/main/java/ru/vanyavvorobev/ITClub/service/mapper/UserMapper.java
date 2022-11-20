package ru.vanyavvorobev.ITClub.service.mapper;

import ru.vanyavvorobev.ITClub.dto.UserDto;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

public class UserMapper {
    public static UserDto mapToUserDto(UserEntity entity) {
        var dto = new UserDto();
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