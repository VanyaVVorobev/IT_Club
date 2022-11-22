package ru.vanyavvorobev.ITClub.entity.memberOfTeam;

import ru.vanyavvorobev.ITClub.entity.TeamEntity;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MemberOfTeamPrimaryKey implements Serializable {

    private UserEntity userEntity;
    private TeamEntity teamEntity;

    public MemberOfTeamPrimaryKey() {}
    public MemberOfTeamPrimaryKey(UserEntity userEntity, TeamEntity teamEntity) {
        this.userEntity = userEntity;
        this.teamEntity = teamEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public TeamEntity getTeamEntity() {
        return teamEntity;
    }

    public void setTeamEntity(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }

}
