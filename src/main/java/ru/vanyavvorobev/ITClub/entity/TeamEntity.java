package ru.vanyavvorobev.ITClub.entity;

import ru.vanyavvorobev.ITClub.entity.memberOfTeam.MemberOfTeamEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "team_table")
public class TeamEntity implements Serializable {

    @Id
    @Column(name = "team_uuid")
    private String uuid;
    @Column(name = "team_name", nullable = false,unique = true)
    private String name;
    @Column(name = "team_description")
    private String description;

    @OneToMany(mappedBy = "teamEntity", cascade = {CascadeType.PERSIST})
    private Set<MemberOfTeamEntity> membersList;
    private String ownerUuid;

    public TeamEntity() {}
    public TeamEntity(String uuid, String name, String description, String ownerUuid) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.ownerUuid = ownerUuid;
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

    public Set<MemberOfTeamEntity> getMembersList() {
        return membersList;
    }

    public void setMembersList(Set<MemberOfTeamEntity> membersList) {
        this.membersList = membersList;
    }

    public String getOwnerUuid() {
        return ownerUuid;
    }

    public void setOwnerUuid(String ownerUuid) {
        this.ownerUuid = ownerUuid;
    }
}
