package com.nftchange.persistence.repository;

import com.nftchange.persistence.entity.NFTEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NFTRepository extends JpaRepository<NFTEntity, String> {

    NFTEntity findFirstByTokenIdAndDeletedIsFalse(String id);

    @Query(value = "SELECT * FROM tb_nfts WHERE (title LIKE %:title% OR title IS NULL) AND deleted IS FALSE", nativeQuery = true)
    List<NFTEntity> findAllByTitle(@Param("title") String title);
}
