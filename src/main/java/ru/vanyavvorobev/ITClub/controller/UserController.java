package ru.vanyavvorobev.ITClub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.dto.request.UserProfileRequestDto;
import ru.vanyavvorobev.ITClub.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
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
            return ResponseEntity.ok(userService.getUserProfile(parseToken(token)));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/profile")
    private ResponseEntity<?> putUserInfo(@RequestBody UserProfileRequestDto requestDto, @RequestHeader (name="Authorization") String token) {
        try {
            userService.putUserProfile(requestDto, parseToken(token));
            return ResponseEntity.ok("User profile edit is successful!");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private String parseToken(String token) {
        if(StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        return token;
    }
}
