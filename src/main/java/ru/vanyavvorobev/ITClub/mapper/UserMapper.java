package ru.vanyavvorobev.ITClub.mapper;

import ru.vanyavvorobev.ITClub.dto.request.UserProfileRequestDto;
import ru.vanyavvorobev.ITClub.dto.response.UserProfileResponseDto;
import ru.vanyavvorobev.ITClub.dto.response.UserResponseDto;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

public class UserMapper {
    public static UserResponseDto mapToUserDto(UserEntity entity) {
        var dto = new UserResponseDto();
        dto.setUuid(entity.getUuid());
        dto.setUsername(entity.getUsername());
        dto.setName(entity.getName());
        dto.setAvatarLink(entity.getAvatarLink());
        dto.setFaculty(entity.getFaculty());
        dto.setCourse(entity.getCourse());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public static UserProfileRequestDto mapToUserProfileRequestDto(UserEntity entity) {
        var dto = new UserProfileRequestDto();
        dto.setUuid(entity.getUuid());
        dto.setName(entity.getName());
        dto.setAvatarLink(entity.getAvatarLink());
        dto.setFaculty(entity.getFaculty());
        dto.setCourse(entity.getCourse());
        dto.setDescription(entity.getDescription());
        return dto;
    }
    public static UserProfileResponseDto mapToUserProfileResponseDto(UserEntity entity) {
        var dto = new UserProfileResponseDto();
        dto.setUuid(entity.getUuid());
        dto.setUsername(entity.getUsername());
        dto.setName(entity.getName());
        dto.setAvatarLink(entity.getAvatarLink());
        dto.setFaculty(entity.getFaculty());
        dto.setCourse(entity.getCourse());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public static UserEntity updateUserEntity(UserProfileRequestDto dto, UserEntity entity) {
        entity.setAvatarLink(dto.getAvatarLink());
        entity.setName(dto.getName());
        entity.setFaculty(dto.getFaculty());
        entity.setCourse(dto.getCourse());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}