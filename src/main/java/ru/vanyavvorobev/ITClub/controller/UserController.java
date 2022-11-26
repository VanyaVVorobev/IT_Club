package ru.vanyavvorobev.ITClub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.dto.request.UserProfileRequestDto;
import ru.vanyavvorobev.ITClub.security.jwt.JwtUtils;
import ru.vanyavvorobev.ITClub.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    public UserController(UserService userService, JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @GetMapping("/")
    private ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok().body(userService.getAllUsers());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/profile")
    private ResponseEntity<?> getUserInfo(@RequestHeader (name="Authorization") String token) {
        try {
            return ResponseEntity.ok(userService.getUserProfile(jwtUtils.cutTokenPrefix(token)));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/profile")
    private ResponseEntity<?> putUserInfo(@RequestBody UserProfileRequestDto requestDto, @RequestHeader (name="Authorization") String token) {
        try {
            userService.putUserProfile(requestDto, jwtUtils.cutTokenPrefix(token));
            return ResponseEntity.ok("User profile edit is successful!");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
