package com.nftchange.mapper;

import com.nftchange.domain.Wallet;
import com.nftchange.persistence.entity.WalletEntity;

import java.util.UUID;

public class WalletEntityMapper {

    public static Wallet toDomain(WalletEntity walletEntity) {
        if (walletEntity == null) {
            return null;
        }
        Wallet wallet = new Wallet();
        wallet.setId(UUID.fromString(walletEntity.getId()));
        wallet.setBalance(walletEntity.getBalance());
        wallet.setCreatedBy(walletEntity.getCreatedBy());
        wallet.setCreatedDate(walletEntity.getCreatedDate());
        wallet.setLastModifiedBy(walletEntity.getLastModifiedBy());
        wallet.setLastModifiedDate(walletEntity.getLastModifiedDate());
        wallet.setDeleted(walletEntity.isDeleted());
        return wallet;
    }

    public static WalletEntity toEntity(Wallet wallet) {
        if (wallet == null) {
            return null;
        }
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setId(wallet.getId() != null ? wallet.getId().toString() : null);
        walletEntity.setBalance(wallet.getBalance());
        walletEntity.setCreatedBy(wallet.getCreatedBy());
        walletEntity.setCreatedDate(wallet.getCreatedDate());
        walletEntity.setLastModifiedBy(wallet.getLastModifiedBy());
        walletEntity.setLastModifiedDate(wallet.getLastModifiedDate());
        walletEntity.setDeleted(wallet.isDeleted());
        return walletEntity;
    }
}
