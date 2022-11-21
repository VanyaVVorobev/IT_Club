package ru.vanyavvorobev.ITClub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.dto.old.MessageResponse;
import ru.vanyavvorobev.ITClub.dto.request.LoginRequestDto;
import ru.vanyavvorobev.ITClub.dto.request.SignupRequestDto;
import ru.vanyavvorobev.ITClub.dto.response.MessageResponseDto;
import ru.vanyavvorobev.ITClub.dto.response.TokenResponseDto;
import ru.vanyavvorobev.ITClub.entity.Role.RoleEntity;
import ru.vanyavvorobev.ITClub.entity.Role.RoleNamesEnum;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.security.jwt.JwtUtils;
import ru.vanyavvorobev.ITClub.security.service.UserDetailsImpl;
import ru.vanyavvorobev.ITClub.service.AuthorizationService;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {

    private final AuthenticationManager authenticationManager;
    private final AuthorizationService authorizationService;
    private final JwtUtils jwtUtils;

    public AuthorizationController(AuthorizationService authorizationService,AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authorizationService = authorizationService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequestDto requestDto) {
        List<MessageResponseDto> messageResponses = new ArrayList<>(authorizationService.getErrorsInSignupData(requestDto));
        if(messageResponses.isEmpty()) {
            try {
                authorizationService.saveUser(requestDto);
                return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
            } catch(Exception e) {
                return ResponseEntity.internalServerError().body("Server Error");
            }
        }
        else {
            return ResponseEntity.badRequest().body(messageResponses);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestDto requestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.getLogin(), requestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok(new TokenResponseDto(token));
    }
}
