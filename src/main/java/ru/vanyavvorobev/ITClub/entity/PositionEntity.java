package ru.vanyavvorobev.ITClub.entity;

import ru.vanyavvorobev.ITClub.entity.MemberOfTeam.MemberOfTeamEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position_table")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer id;

    @Column(name = "position_name")
    private String name;

    @ManyToMany(mappedBy = "memberPositions")
    private Set<MemberOfTeamEntity> memberOfTeamEntitySet;

    public PositionEntity() {}

    public PositionEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String positionName) {
        this.name = positionName;
    }

    public Set<MemberOfTeamEntity> getMemberOfTeamEntitySet() {
        return memberOfTeamEntitySet;
    }

    public void setMemberOfTeamEntitySet(Set<MemberOfTeamEntity> memberOfTeamEntitySet) {
        this.memberOfTeamEntitySet = memberOfTeamEntitySet;
    }
}
