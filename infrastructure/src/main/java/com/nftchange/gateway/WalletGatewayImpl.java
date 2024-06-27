package com.nftchange.gateway;

import com.nftchange.domain.Wallet;
import com.nftchange.mapper.WalletEntityMapper;
import com.nftchange.persistence.entity.WalletEntity;
import com.nftchange.persistence.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class WalletGatewayImpl implements WalletGateway{

    private final WalletRepository walletRepository;

    @Autowired
    public WalletGatewayImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet create(Wallet wallet) throws Throwable {
        WalletEntity walletEntity = WalletEntityMapper.toEntity(wallet);
        wallet = WalletEntityMapper.toDomain(this.walletRepository.save(walletEntity));
        return wallet;
    }

    @Override
    public void updateBalanceById(UUID id, BigDecimal balance) {
        this.walletRepository.updateBalanceById(id.toString(), balance);
    }
}
