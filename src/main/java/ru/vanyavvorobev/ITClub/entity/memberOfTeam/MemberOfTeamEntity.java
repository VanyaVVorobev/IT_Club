package ru.vanyavvorobev.ITClub.entity.memberOfTeam;

import ru.vanyavvorobev.ITClub.entity.PositionEntity;
import ru.vanyavvorobev.ITClub.entity.TeamEntity;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "member_of_team_table")
@IdClass(MemberOfTeamPrimaryKey.class)
public class MemberOfTeamEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_uuid", nullable = false)
    private UserEntity userEntity;

    @Id
    @ManyToOne
    @JoinColumn(name = "team_uuid", nullable = false)
    private TeamEntity teamEntity;

    public MemberOfTeamEntity() {}
    public MemberOfTeamEntity(UserEntity userEntity, TeamEntity teamEntity) {
        this.userEntity = userEntity;
        this.teamEntity = teamEntity;
    }

    @ManyToMany
    @JoinTable(
            name = "member_position",
            joinColumns = {
                    @JoinColumn(name = "team_uuid"),
                    @JoinColumn(name = "user_uuid")
            },
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private Set<PositionEntity> memberPositions;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Set<PositionEntity> getMemberPositions() {
        return memberPositions;
    }

    public void setMemberPositions(Set<PositionEntity> memberPositions) {
        this.memberPositions = memberPositions;
    }

    public TeamEntity getTeamEntity() {
        return teamEntity;
    }

    public void setTeamEntity(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }

}
