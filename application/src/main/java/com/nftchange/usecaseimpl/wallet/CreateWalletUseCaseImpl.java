package com.nftchange.usecaseimpl.wallet;


import com.nftchange.domain.Wallet;
import com.nftchange.gateway.WalletGateway;
import com.nftchange.wallet.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private final WalletGateway walletGateway;

    public CreateWalletUseCaseImpl(WalletGateway walletGateway) {
        this.walletGateway = walletGateway;
    }

    @Override
    public Wallet create(Wallet wallet) throws Throwable {
        return this.walletGateway.create(wallet);
    }
}
