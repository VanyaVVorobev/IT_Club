package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vanyavvorobev.ITClub.entity.TeamEntity;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.entity.MemberOfTeamEntity;

import java.util.Optional;

@Repository
public interface MemberOfTeamRepository extends JpaRepository<MemberOfTeamEntity, String> {

    Boolean existsByUserEntity(UserEntity user);

    Optional<MemberOfTeamEntity> findByUserEntityAndTeamEntity(UserEntity user, TeamEntity team);
}
