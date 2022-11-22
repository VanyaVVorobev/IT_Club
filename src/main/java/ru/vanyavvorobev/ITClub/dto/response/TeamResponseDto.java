package ru.vanyavvorobev.ITClub.dto.response;

import java.util.List;

public class TeamResponseDto {

    private String uuid;
    private String name;
    private String description;
    private String ownerUuid;
    private List<MemberOfTeamResponseDto> members;

    public TeamResponseDto() {}
    public TeamResponseDto(String uuid, String name, String description, String ownerUuid, List<MemberOfTeamResponseDto> members) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.ownerUuid = ownerUuid;
        this.members = members;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerUuid() {
        return ownerUuid;
    }

    public void setOwnerUuid(String ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    public List<MemberOfTeamResponseDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberOfTeamResponseDto> members) {
        this.members = members;
    }
}
