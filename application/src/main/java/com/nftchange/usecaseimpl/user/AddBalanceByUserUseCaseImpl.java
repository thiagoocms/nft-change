package com.nftchange.usecaseimpl.user;

import com.nftchange.domain.User;
import com.nftchange.domain.Wallet;
import com.nftchange.gateway.WalletGateway;
import com.nftchange.user.AddBalanceByUserUseCase;
import com.nftchange.validation.UserValidation;

import java.math.BigDecimal;

public class AddBalanceByUserUseCaseImpl implements AddBalanceByUserUseCase {

    private final UserValidation  userValidation;
    private final WalletGateway walletGateway;

    public AddBalanceByUserUseCaseImpl(UserValidation userValidation, WalletGateway walletGateway) {
        this.userValidation = userValidation;
        this.walletGateway = walletGateway;
    }

    @Override
    public void add(Long userId, BigDecimal value) {
        User user = this.userValidation.checkExistUser(userId);
        Wallet wallet = user.getWallet();
        value = value.add(wallet.getBalance());
        this.walletGateway.updateBalanceById(wallet.getId(), value);
    }
}
