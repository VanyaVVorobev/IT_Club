package ru.vanyavvorobev.ITClub.entity.position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position_table")
@IdClass(PositionPrimaryKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionEntity {
//    @Id
//    @Column(name = "user_uuid")
//    private String userUuid;
    @Id
    @Column(name = "position_name")
    private String positionName;
    @ManyToOne
    @Id
    @JoinColumn(name = "user_uuid", nullable = false)
    private UserEntity userUuid;
}
