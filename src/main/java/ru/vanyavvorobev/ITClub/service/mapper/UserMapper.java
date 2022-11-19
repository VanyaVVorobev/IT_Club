package ru.vanyavvorobev.ITClub.service.mapper;

import ru.vanyavvorobev.ITClub.dto.AuthorizationUserDto;
import ru.vanyavvorobev.ITClub.dto.UserDto;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

public class UserMapper {
    public static UserDto mapToDto(UserEntity entity) {
        var dto = new UserDto();
        dto.setUuid(entity.getUuid());
        dto.setLogin(entity.getLogin());
        dto.setCourse(entity.getCourse());
        dto.setName(entity.getName());
        dto.setFaculty(entity.getFaculty());
        dto.setDescription(entity.getDescription());
        dto.setAvatarLink(entity.getAvatarLink());
        return dto;
    }

    public static UserEntity mapToEntity(AuthorizationUserDto dto) {
        var entity = new UserEntity();
        entity.setPassword(dto.getPassword());
        entity.setLogin(dto.getLogin());
        return entity;
    }
    public static UserEntity mapToEntity(UserDto dto) {
        var entity = new UserEntity();
        entity.setPassword(null);
        entity.setLogin(dto.getLogin());
        entity.setUuid(dto.getUuid());
        entity.setDescription(dto.getDescription());
        entity.setCourse(dto.getCourse());
        entity.setFaculty(dto.getFaculty());
        entity.setName(dto.getName());
        entity.setRole(null);
        return null;
    }
}