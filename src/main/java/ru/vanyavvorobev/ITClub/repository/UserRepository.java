package ru.vanyavvorobev.ITClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vanyavvorobev.ITClub.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public UserEntity findByUuid(String uuid);
    public UserEntity findByLogin(String login);
}
