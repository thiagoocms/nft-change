package com.nftchange.gateway;


import com.nftchange.domain.Wallet;

public interface WalletGateway {
    Wallet create(Wallet wallet) throws Throwable;
}
