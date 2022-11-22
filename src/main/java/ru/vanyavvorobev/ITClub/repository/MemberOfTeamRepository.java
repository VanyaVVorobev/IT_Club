package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.entity.MemberOfTeamEntity;

@Repository
public interface MemberOfTeamRepository extends JpaRepository<MemberOfTeamEntity, String> {

    Boolean existsByUserEntity(UserEntity user);

}
