package ru.vanyavvorobev.ITClub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vanyavvorobev.ITClub.dto.request.CreateTeamRequestDto;
import ru.vanyavvorobev.ITClub.dto.request.PositionRequestDto;
import ru.vanyavvorobev.ITClub.security.jwt.JwtUtils;
import ru.vanyavvorobev.ITClub.service.TeamService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;
    private final JwtUtils jwtUtils;

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

    @PostMapping("/{teamUuid}/follow")
    public ResponseEntity<?> followUserToTeam(
            @RequestHeader (name="Authorization") String token,
            @PathVariable String teamUuid
    ) {
        try {
            teamService.followUserToTeam(jwtUtils.cutTokenPrefix(token), teamUuid);
            return ResponseEntity.ok("Follow is successful!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{teamUuid}/user/{userUuid}/delete")
    public ResponseEntity<?> deleteUserFromTeam(
            @RequestHeader (name="Authorization") String token,
            @PathVariable String teamUuid,
            @PathVariable String userUuid
    ) {
        try {
            teamService.deleteUserFromTeam(jwtUtils.cutTokenPrefix(token), teamUuid, userUuid);
            return ResponseEntity.ok("User delete successful!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("{teamUuid}/positions")
    public ResponseEntity<?> setPositionToUser(
            @RequestHeader (name="Authorization") String token,
            @PathVariable String teamUuid,
            @RequestBody List<String> requestDto
    ) {
        try {
            teamService.setPositionToUser(jwtUtils.cutTokenPrefix(token), teamUuid, requestDto);
            return ResponseEntity.ok("Position set successful!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/positions")
    public ResponseEntity<?> getAllPositions() {
        try {
            return ResponseEntity.ok(teamService.getAllPositions());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
