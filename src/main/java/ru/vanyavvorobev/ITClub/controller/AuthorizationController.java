package ru.vanyavvorobev.ITClub.controller;

import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

}
