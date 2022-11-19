package ru.vanyavvorobev.ITClub.controller;

import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.dto.AuthorizationUserDto;
import ru.vanyavvorobev.ITClub.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody AuthorizationUserDto authorizationUserDto) {}

    @GetMapping("/login")
    public void loginUser(@RequestBody AuthorizationUserDto authorizationUserDto) {}
}
