package ru.vanyavvorobev.ITClub.dto.response;

import java.util.List;

public class MemberOfTeamResponseDto {
    private String uuid;
    private String username;
    private List<String> positions;

    public MemberOfTeamResponseDto() {}
    public MemberOfTeamResponseDto(String uuid, String username, List<String> positions) {
        this.uuid = uuid;
        this.username = username;
        this.positions = positions;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }
}
