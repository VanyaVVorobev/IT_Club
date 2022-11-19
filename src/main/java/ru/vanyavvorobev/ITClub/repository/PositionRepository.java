package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vanyavvorobev.ITClub.entity.position.PositionEntity;
import ru.vanyavvorobev.ITClub.entity.position.PositionPrimaryKey;

import java.util.List;

public interface PositionRepository extends JpaRepository<PositionEntity, PositionPrimaryKey> {
    public List<PositionEntity> findByUserUuid(String Uuid);
}
