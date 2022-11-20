package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vanyavvorobev.ITClub.entity.MemberOfTeam.MemberOfTeamPrimaryKey;

public interface MemberOfTeamRepository extends JpaRepository<MemberOfTeamRepository, MemberOfTeamPrimaryKey> {

}
