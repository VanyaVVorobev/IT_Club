package ru.vanyavvorobev.ITClub.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;
import ru.vanyavvorobev.ITClub.dto.request.CreateTeamRequestDto;
import ru.vanyavvorobev.ITClub.dto.response.TeamResponseDto;
import ru.vanyavvorobev.ITClub.entity.TeamEntity;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.entity.MemberOfTeamEntity;
import ru.vanyavvorobev.ITClub.mapper.TeamMapper;
import ru.vanyavvorobev.ITClub.repository.MemberOfTeamRepository;
import ru.vanyavvorobev.ITClub.repository.TeamRepository;
import ru.vanyavvorobev.ITClub.repository.UserRepository;
import ru.vanyavvorobev.ITClub.security.jwt.JwtUtils;
import ru.vanyavvorobev.ITClub.security.service.UserDetailsServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final MemberOfTeamRepository memberOfTeamRepository;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService, MemberOfTeamRepository memberOfTeamRepository) {
        this.jwtUtils = jwtUtils;
        this.teamRepository = teamRepository;
        this.userDetailsService = userDetailsService;
        this.memberOfTeamRepository = memberOfTeamRepository;
        this.userRepository = userRepository;
    }

    public List<TeamResponseDto> getAllTeams() {
        return teamRepository.findAll().stream().map(TeamMapper::mapTeamEntityToTeamResponseDto).collect(Collectors.toList());
    }

    public List<TeamResponseDto> getTeamByUser(String token) throws UsernameNotFoundException, RequestRejectedException {
        String username = jwtUtils.getUsernameFromJwtToken(token);
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Profile is not found!"));
        return TeamMapper.mapUserEntityToTeamResponseDto(user);
    }

    public void createTeam(String token, CreateTeamRequestDto requestDto) throws RequestRejectedException {
        String username = jwtUtils.getUsernameFromJwtToken(token);
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RequestRejectedException("User is not found!"));
        if(teamRepository.existsByName(requestDto.getName())) {
            throw new RequestRejectedException("Name is already taken!");
        }
        else if(!memberOfTeamRepository.existsByUserEntity(user)){
            TeamEntity team = new TeamEntity();
            team.setUuid(UUID.randomUUID().toString());
            team.setOwnerUuid(user.getUuid());
            team.setName(requestDto.getName());
            team.setDescription(requestDto.getDescription());
            teamRepository.save(team);
            memberOfTeamRepository.save(new MemberOfTeamEntity(UUID.randomUUID().toString(), user, team));
        }
    }


}
