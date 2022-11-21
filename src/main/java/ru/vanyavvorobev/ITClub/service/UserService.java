package ru.vanyavvorobev.ITClub.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vanyavvorobev.ITClub.dto.old.UserResponse;
import ru.vanyavvorobev.ITClub.repository.PositionRepository;
import ru.vanyavvorobev.ITClub.repository.RoleRepository;
import ru.vanyavvorobev.ITClub.repository.UserRepository;
import ru.vanyavvorobev.ITClub.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PositionRepository positionRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    public List<UserResponse> getAllUsers() {
//        var userEntitiesList = userRepository.findAll();
//        return userEntitiesList.stream().map(UserMapper::mapToUserDto).toList();
//    }

}
