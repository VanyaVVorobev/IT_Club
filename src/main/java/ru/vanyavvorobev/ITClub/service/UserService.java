package ru.vanyavvorobev.ITClub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vanyavvorobev.ITClub.dto.AuthorizationUserDto;
import ru.vanyavvorobev.ITClub.dto.UserDto;
import ru.vanyavvorobev.ITClub.entity.RoleEntity;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.entity.position.PositionEntity;
import ru.vanyavvorobev.ITClub.repository.PositionRepository;
import ru.vanyavvorobev.ITClub.repository.RoleRepository;
import ru.vanyavvorobev.ITClub.repository.UserRepository;
import ru.vanyavvorobev.ITClub.service.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PositionRepository positionRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::mapToDto).collect(Collectors.toList());
    }


    public UserDto getUserByUuid(String uuid) {
        var user = UserMapper.mapToDto(userRepository.findByUuid(uuid));
//        user.setPositions(getUserPositionsByUuid(uuid));
        return user;
    }

    private UserDto getUserByLogin(String login) {
        var user = UserMapper.mapToDto(userRepository.findByUuid(login));
//        user.setPositions(getUserPositionsByUuid(user.getUuid()));
        return user;
    }

    private List<String> getUserPositionsByUuid(String uuid) {
        return positionRepository.findByUserUuid(uuid)
                .stream().map(PositionEntity::getPositionName).collect(Collectors.toList());
    }

//    public void updateUser(UserDto userDto) {
//        if(isValidUserData(userDto)) {
//            TODO:: update
//        }
//    }

    public void deleteUserByUuid(String uuid) {
        userRepository.deleteById(uuid);
    }

    public void registerUser(AuthorizationUserDto authorizationUserDto) {
        if(isValidUserData(authorizationUserDto)) {
            var userEntity = UserMapper.mapToEntity(authorizationUserDto);
            userEntity.setRole(roleRepository.findByName("ROLE_USER"));
            userEntity.setLogin(authorizationUserDto.getLogin());
            userEntity.setPassword(passwordEncoder.encode(authorizationUserDto.getPassword()));
            userRepository.save(userEntity);
        }
        else {
            //todo:: add exception
        }
    }

    public UserDto loginUser(AuthorizationUserDto authorizationUserDto) {
        UserEntity userEntity = userRepository.findByLogin(authorizationUserDto.getLogin());
        if(userEntity != null) {
            if(passwordEncoder.matches(authorizationUserDto.getPassword(), userEntity.getPassword())) {
                return UserMapper.mapToDto(userEntity);
            }
        }
        return new UserDto();
    }

    private Boolean isValidUserData(UserDto userDto) {
            //todo:: add implementation
        return true;
    }
    private Boolean isValidUserData(AuthorizationUserDto authorizationUserDto) {
            //todo:: add implementation
        return true;
    }

}
