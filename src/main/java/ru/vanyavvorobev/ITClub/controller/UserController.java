package ru.vanyavvorobev.ITClub.controller;

import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.dto.UserProfileDto;
import ru.vanyavvorobev.ITClub.service.TokenService;
import ru.vanyavvorobev.ITClub.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;

    public UserController(UserService userService,
                          TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping("/")
    public List<UserProfileDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{uuid}")
    public UserProfileDto getUserByUuid(@PathVariable String uuid) {
        return userService.getUserByUuid(uuid);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UserProfileDto userProfileDto) {}

    @DeleteMapping("/delete/{uuid}")
    public void deleteUserByUuid(@PathVariable String uuid) {}

}
