package ru.vanyavvorobev.ITClub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.dto.request.CreateTeamRequestDto;
import ru.vanyavvorobev.ITClub.security.jwt.JwtUtils;
import ru.vanyavvorobev.ITClub.service.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private TeamService teamService;
    private JwtUtils jwtUtils;

    public TeamController(TeamService teamService, JwtUtils jwtUtils) {
        this.teamService = teamService;
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTeams() {
        try {
            return ResponseEntity.ok(teamService.getAllTeams());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/")
    public ResponseEntity<?> getTeamByUser(
            @RequestHeader (name="Authorization") String token) {
        try {
            return ResponseEntity.ok(teamService.getTeamByUser(jwtUtils.cutTokenPrefix(token)));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTeam(
            @RequestHeader (name="Authorization") String token,
            @RequestBody CreateTeamRequestDto requestDto) {
        try {
            teamService.createTeam(jwtUtils.cutTokenPrefix(token), requestDto);
            return ResponseEntity.ok("Team create is successful!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
