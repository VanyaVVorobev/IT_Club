package ru.vanyavvorobev.ITClub.service.mapper;

import ru.vanyavvorobev.ITClub.dto.AuthorizationUserDto;
import ru.vanyavvorobev.ITClub.dto.UserDto;
import ru.vanyavvorobev.ITClub.dto.UserProfileDto;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.entity.PositionEntity;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserProfileDto mapToUserProfileDto(UserEntity entity) {
        var dto = new UserProfileDto();

        dto.setUuid(entity.getUuid());
        dto.setLogin(entity.getLogin());
        dto.setCourse(entity.getCourse());
        dto.setName(entity.getName());
        dto.setFaculty(entity.getFaculty());
        dto.setDescription(entity.getDescription());
        dto.setAvatarLink(entity.getAvatarLink());
        dto.setPositions(entity.getUserPositions().stream().map(PositionEntity::getPositionName).collect(Collectors.toList()));

        return dto;
    }
    public static UserDto mapToUserDto(UserEntity entity) {
        var dto = new UserDto();

        dto.setUuid(entity.getUuid());
        dto.setCourse(entity.getCourse());
        dto.setName(entity.getName());
        dto.setFaculty(entity.getFaculty());
        dto.setDescription(entity.getDescription());
        dto.setAvatarLink(entity.getAvatarLink());
        dto.setPositions(entity.getUserPositions().stream().map(PositionEntity::getPositionName).toList());

        return dto;
    }

    public static UserEntity mapToEntity(AuthorizationUserDto dto) {
        var entity = new UserEntity();

        entity.setPassword(dto.getPassword());
        entity.setLogin(dto.getLogin());

        entity.setUuid(null);
        entity.setDescription(null);
        entity.setCourse(null);
        entity.setFaculty(null);
        entity.setName(null);
        entity.setRole(null);
        entity.setUserPositions(null);

        return entity;
    }
    public static UserEntity mapToEntity(UserProfileDto dto) {
        var entity = new UserEntity();

        entity.setLogin(dto.getLogin());
        entity.setUuid(dto.getUuid());
        entity.setAvatarLink(dto.getAvatarLink());
        entity.setDescription(dto.getDescription());
        entity.setCourse(dto.getCourse());
        entity.setFaculty(dto.getFaculty());
        entity.setName(dto.getName());

        entity.setUserPositions(dto.getPositions().stream().map(UserMapper::mapToPosition).collect(Collectors.toSet()));

        entity.setPassword(null);
        entity.setRole(null);

        return entity;
    }

    private static PositionEntity mapToPosition(String name) {
        var entity = new PositionEntity();
        entity.setPositionName(name);
        return entity;
    }
}