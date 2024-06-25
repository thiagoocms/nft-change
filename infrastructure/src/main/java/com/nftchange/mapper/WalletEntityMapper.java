package com.nftchange.mapper;

import com.nftchange.domain.Wallet;
import com.nftchange.persistence.entity.WalletEntity;

public class WalletEntityMapper {

    public static Wallet toDomain(WalletEntity walletEntity) {
        Wallet wallet = new Wallet();
        wallet.setId(walletEntity.getId());
        wallet.setBalance(walletEntity.getBalance());
        wallet.setCreatedBy(walletEntity.getCreatedBy());
        wallet.setCreatedDate(walletEntity.getCreatedDate());
        wallet.setLastModifiedBy(walletEntity.getLastModifiedBy());
        wallet.setLastModifiedDate(walletEntity.getLastModifiedDate());
        wallet.setDeleted(walletEntity.isDeleted());
        return wallet;
    }

    public static WalletEntity toEntity(Wallet wallet) {
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setId(wallet.getId());
        walletEntity.setBalance(wallet.getBalance());
        walletEntity.setCreatedBy(wallet.getCreatedBy());
        walletEntity.setCreatedDate(wallet.getCreatedDate());
        walletEntity.setLastModifiedBy(wallet.getLastModifiedBy());
        walletEntity.setLastModifiedDate(wallet.getLastModifiedDate());
        walletEntity.setDeleted(wallet.isDeleted());
        return walletEntity;
    }
}
