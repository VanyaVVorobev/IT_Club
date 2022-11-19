package ru.vanyavvorobev.ITClub.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vanyavvorobev.ITClub.dto.AuthorizationUserDto;
import ru.vanyavvorobev.ITClub.dto.UserProfileDto;
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
                       RoleRepository roleRepository
                       //PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<UserProfileDto> getAllUsers() {
        var userList = userRepository.findAll().stream().map(UserMapper::mapToDto).toList();
        userList.forEach(it -> it.setPositions(getUserPositionsByUuid(it.getUuid())));
        return userList;
    }


    public UserProfileDto getUserByUuid(String uuid) {
        var user = UserMapper.mapToDto(userRepository.findByUuid(uuid));
        user.setPositions(getUserPositionsByUuid(uuid));
        return user;
    }

    private UserProfileDto getUserByLogin(String login) {
        var user = UserMapper.mapToDto(userRepository.findByUuid(login));
        user.setPositions(getUserPositionsByUuid(user.getUuid()));
        return user;
    }

    private List<String> getUserPositionsByUuid(String uuid) {
        return positionRepository.findAllByUserUuid(uuid)
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

    public UserProfileDto loginUser(AuthorizationUserDto authorizationUserDto) {
        UserEntity userEntity = userRepository.findByLogin(authorizationUserDto.getLogin());
        if(userEntity != null) {
            if(passwordEncoder.matches(authorizationUserDto.getPassword(), userEntity.getPassword())) {
                return UserMapper.mapToDto(userEntity);
            }
        }
        return new UserProfileDto();
    }

    private Boolean isValidUserData(UserProfileDto userProfileDto) {
            //todo:: add implementation
        return true;
    }
    private Boolean isValidUserData(AuthorizationUserDto authorizationUserDto) {
            //todo:: add implementation
        return true;
    }

}
