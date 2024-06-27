package com.nftchange.gateway;


import com.nftchange.domain.Wallet;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletGateway {
    Wallet create(Wallet wallet) throws Throwable;
    void updateBalanceById(UUID id, BigDecimal balance);
}
