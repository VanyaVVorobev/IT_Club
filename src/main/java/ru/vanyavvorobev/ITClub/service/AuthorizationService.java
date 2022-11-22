package ru.vanyavvorobev.ITClub.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vanyavvorobev.ITClub.dto.request.SignupRequestDto;
import ru.vanyavvorobev.ITClub.dto.response.MessageResponseDto;
import ru.vanyavvorobev.ITClub.entity.Role.RoleEntity;
import ru.vanyavvorobev.ITClub.entity.Role.RoleNamesEnum;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.repository.RoleRepository;
import ru.vanyavvorobev.ITClub.repository.UserRepository;
import ru.vanyavvorobev.ITClub.security.service.UserDetailsServiceImpl;

import java.util.*;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthorizationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(SignupRequestDto requestDto) throws RuntimeException {
        Set<RoleEntity> roles = new HashSet<>();
        RoleEntity userRole = getRoleByName(RoleNamesEnum.ROLE_USER);
        if(userRole == null) { throw new RuntimeException("Role User is not found!"); }
        roles.add(userRole);
        UserEntity user = new UserEntity(
                UUID.randomUUID().toString(),
                requestDto.getUsername(),
                requestDto.getLogin(),
                passwordEncoder.encode(requestDto.getPassword()),
                roles);
        userRepository.save(user);
    }

    public List<MessageResponseDto> getErrorsInSignupData(SignupRequestDto requestDto) {
        List<String> errors = new ArrayList<>();
        //TODO: add validation
        if(isUserExistByEmail(requestDto.getLogin())) { errors.add("Error: Email is already exist"); }
        if(isUserExistByUsername(requestDto.getUsername())) { errors.add("Error: Username is already exist"); }
        return errors.stream().map(MessageResponseDto::new).toList();
    }

    private Boolean isUserExistByEmail(String email) {
        return userRepository.existsByLogin(email);
    }
    private Boolean isUserExistByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    private RoleEntity getRoleByName(RoleNamesEnum roleName) throws RuntimeException {
            return roleRepository.findByName(roleName);
    }
}
