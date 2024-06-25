package com.nftchange.mapper;

import com.nftchange.domain.Wallet;
import com.nftchange.dto.WalletDTO;
import com.nftchange.persistence.entity.WalletEntity;

public class WalletDTOMapper {

    public static Wallet toDomain(WalletDTO walletDTO) {
        if (walletDTO == null) {
            return null;
        }
        Wallet wallet = new Wallet();
        wallet.setId(walletDTO.getId());
        wallet.setBalance(walletDTO.getBalance());
        return wallet;
    }

    public static WalletDTO toDto(Wallet wallet) {
        if (wallet == null) {
            return null;
        }
        WalletDTO  walletDTO = new WalletDTO();
        walletDTO.setId(wallet.getId());
        walletDTO.setBalance(wallet.getBalance());
        return walletDTO;
    }
}
