package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vanyavvorobev.ITClub.entity.MemberOfTeam.MemberOfTeamEntity;
import ru.vanyavvorobev.ITClub.entity.MemberOfTeam.MemberOfTeamPrimaryKey;

@Repository
public interface MemberOfTeamRepository extends JpaRepository<MemberOfTeamEntity, MemberOfTeamPrimaryKey> {

}
