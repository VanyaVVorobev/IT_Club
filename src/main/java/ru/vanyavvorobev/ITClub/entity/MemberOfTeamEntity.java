package ru.vanyavvorobev.ITClub.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "member_of_team_table")
public class MemberOfTeamEntity implements Serializable {

    @Id
    @Column(name = "member_uuid")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "user_uuid", nullable = false)
    private UserEntity userEntity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_uuid", nullable = false)
    private TeamEntity teamEntity;

    @ManyToMany
    @JoinTable(
            name = "member_position",
            joinColumns = {
                    @JoinColumn(name = "member_uuid"),
            },
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private Set<PositionEntity> memberPositions;

    public MemberOfTeamEntity() {
    }

    public Set<PositionEntity> getMemberPositions() {
        return memberPositions;
    }

    public void setMemberPositions(Set<PositionEntity> memberPositions) {
        this.memberPositions = memberPositions;
    }

    public MemberOfTeamEntity(String uuid, UserEntity userEntity) {
        this.uuid = uuid;
        this.userEntity = userEntity;
    }

    public MemberOfTeamEntity(String uuid, UserEntity userEntity, TeamEntity teamEntity) {
        this.uuid = uuid;
        this.userEntity = userEntity;
        this.teamEntity = teamEntity;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String primaryKey) {
        this.uuid = primaryKey;
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
