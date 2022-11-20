package ru.vanyavvorobev.ITClub.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position_table")
public class PositionEntity {

    @Id
    private Integer id;

    @Column(name = "position_name")
    private String positionName;

    @ManyToMany(mappedBy = "userPositions")
    private Set<UserEntity> userEntities;

    public PositionEntity() {}

    public PositionEntity(Integer id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }
}
