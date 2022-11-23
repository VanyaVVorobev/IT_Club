package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vanyavvorobev.ITClub.entity.PositionEntity;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {

    Optional<PositionEntity> findByName(String name);
}
