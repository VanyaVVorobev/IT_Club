package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vanyavvorobev.ITClub.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    public RoleEntity findByName(String name);
}
