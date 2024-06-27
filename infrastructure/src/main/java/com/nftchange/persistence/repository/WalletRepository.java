package com.nftchange.persistence.repository;

import com.nftchange.persistence.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, String> {

    @Modifying
    @Query(value = "UPDATE tb_wallets SET balance = ?2 WHERE id = ?1", nativeQuery = true)
    void updateBalanceById(String id, BigDecimal balance);
}
