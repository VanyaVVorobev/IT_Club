package ru.vanyavvorobev.ITClub.service;

import org.springframework.expression.AccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vanyavvorobev.ITClub.dto.request.UserProfileRequestDto;
import ru.vanyavvorobev.ITClub.dto.response.UserProfileResponseDto;
import ru.vanyavvorobev.ITClub.dto.response.UserResponseDto;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.mapper.UserMapper;
import ru.vanyavvorobev.ITClub.repository.UserRepository;
import ru.vanyavvorobev.ITClub.security.jwt.JwtUtils;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    public UserService(UserRepository userRepository,
                       JwtUtils jwtUtils
    ) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
    }

    public List<UserResponseDto> getAllUsers() {
        var userEntitiesList = userRepository.findAll();
        return userEntitiesList.stream().map(UserMapper::mapToUserDto).toList();
    }

    public UserProfileResponseDto getUserProfile(String token) throws UsernameNotFoundException {
        String username = jwtUtils.getUsernameFromJwtToken(token);
        return UserMapper.mapToUserProfileResponseDto(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Profile is not found!")));

    }

    public void putUserProfile(UserProfileRequestDto dto, String token) throws UsernameNotFoundException, AccessException {
        String username = jwtUtils.getUsernameFromJwtToken(token);
        UserEntity user = userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User Profile is not found!"));
        if(Objects.equals(user.getUuid(), dto.getUuid())) {
            userRepository.saveAndFlush(UserMapper.updateUserEntity(dto, user));
        } else {
            throw new AccessException("Not enough right!");
        }
    }
}
