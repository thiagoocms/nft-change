package com.nftchange.persistence.repository;

import com.nftchange.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByIdAndDeletedIsFalse(Long id);
    UserEntity findFirstByEmailAndDeletedIsFalse(String email);
    Long countByLoginAndDeletedIsFalse(String login);
    UserEntity findFirstByLoginAndDeletedIsFalse(String login);

}
