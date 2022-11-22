package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.entity.memberOfTeam.MemberOfTeamEntity;
import ru.vanyavvorobev.ITClub.entity.memberOfTeam.MemberOfTeamPrimaryKey;

@Repository
public interface MemberOfTeamRepository extends JpaRepository<MemberOfTeamEntity, MemberOfTeamPrimaryKey> {

    Boolean existsByUserEntity(UserEntity user);

}
