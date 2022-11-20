package ru.vanyavvorobev.ITClub.entity.MemberOfTeam;

import ru.vanyavvorobev.ITClub.entity.TeamEntity;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

import java.io.Serializable;

public class MemberOfTeamPrimaryKey implements Serializable {

    private UserEntity userEntity;
    private TeamEntity teamEntity;
}
