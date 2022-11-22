package ru.vanyavvorobev.ITClub.mapper;

import ru.vanyavvorobev.ITClub.dto.response.MemberOfTeamResponseDto;
import ru.vanyavvorobev.ITClub.dto.response.TeamResponseDto;
import ru.vanyavvorobev.ITClub.entity.PositionEntity;
import ru.vanyavvorobev.ITClub.entity.TeamEntity;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.entity.memberOfTeam.MemberOfTeamEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TeamMapper {

    public static TeamResponseDto mapTeamEntityToTeamResponseDto(TeamEntity entity) {
        var dto = new TeamResponseDto();
        dto.setUuid(entity.getUuid());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setMembers(entity.getMembersList().stream().map(TeamMapper::mapEntityToMemberOfTeamResponseDto).collect(Collectors.toList()));
        dto.setOwnerUuid(entity.getOwnerUuid());
        return dto;
    }

    public static MemberOfTeamResponseDto mapEntityToMemberOfTeamResponseDto(MemberOfTeamEntity entity) {
        var dto = new MemberOfTeamResponseDto();
        dto.setUuid(entity.getUserEntity().getUuid());
        dto.setUsername(entity.getUserEntity().getUsername());
        dto.setPositions(entity.getMemberPositions().stream().map(PositionEntity::getName).collect(Collectors.toList()));
        return dto;
    }

    public static List<TeamResponseDto> mapUserEntityToTeamResponseDto(UserEntity entity) {
        var teams = entity.getMemberOfTeamEntitySet().stream().map(MemberOfTeamEntity::getTeamEntity).toList();
        return teams.stream().map(TeamMapper::mapTeamEntityToTeamResponseDto).collect(Collectors.toList());
    }
}
