package ru.vanyavvorobev.ITClub.controller;

import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.dto.old.UserResponse;
import ru.vanyavvorobev.ITClub.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    private List<UserResponse> getAllUsers() {
//        return userService.getAllUsers();
//    }
}
