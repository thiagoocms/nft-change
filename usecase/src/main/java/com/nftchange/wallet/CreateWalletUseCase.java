package com.nftchange.wallet;


import com.nftchange.domain.Wallet;

public interface CreateWalletUseCase {
    Wallet create(Wallet wallet) throws Throwable;
}
