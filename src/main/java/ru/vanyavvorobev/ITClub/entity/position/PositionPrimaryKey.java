package ru.vanyavvorobev.ITClub.entity.position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionPrimaryKey implements Serializable {

    private UserEntity userUuid;
    private String positionName;

}
