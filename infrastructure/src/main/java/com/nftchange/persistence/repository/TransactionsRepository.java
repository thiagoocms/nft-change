package com.nftchange.persistence.repository;

import com.nftchange.enums.TransactionsStatusEnum;
import com.nftchange.persistence.entity.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {
    TransactionsEntity findFirstByIdAndDeletedIsFalse(Long id);

    @Modifying
    @Query(value = "UPDATE SET status = ?2 WHERE id = ?1", nativeQuery = true)
    void updateStatusById(Long id, TransactionsStatusEnum status);
}
