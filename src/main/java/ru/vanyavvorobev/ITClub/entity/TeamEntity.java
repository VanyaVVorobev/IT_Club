package ru.vanyavvorobev.ITClub.entity;

import ru.vanyavvorobev.ITClub.entity.MemberOfTeam.MemberOfTeamEntity;

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

    @OneToMany(mappedBy = "teamEntity")
    private Set<MemberOfTeamEntity> membersList;

    public TeamEntity() {}

    public TeamEntity(String uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
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

}
