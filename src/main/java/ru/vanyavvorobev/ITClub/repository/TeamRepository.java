package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vanyavvorobev.ITClub.entity.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, String> {

    Boolean existsByName(String name);
}
