package ru.vanyavvorobev.ITClub.controller;

import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


}
