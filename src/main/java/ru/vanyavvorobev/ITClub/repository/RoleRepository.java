package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vanyavvorobev.ITClub.entity.Role.RoleEntity;
import ru.vanyavvorobev.ITClub.entity.Role.RoleNamesEnum;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    Optional<RoleEntity> findByName(RoleNamesEnum name);

}
