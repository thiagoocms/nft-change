package com.nftchange.usecaseimpl.user;

import com.nftchange.domain.User;
import com.nftchange.domain.Wallet;
import com.nftchange.gateway.UserGateway;
import com.nftchange.user.CreateUserUseCase;
import com.nftchange.validation.UserValidation;
import com.nftchange.wallet.CreateWalletUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;
    private final CreateWalletUseCase createWalletUseCase;
    private final UserValidation userValidation;

    public CreateUserUseCaseImpl(UserGateway userGateway, CreateWalletUseCase createWalletUseCase, UserValidation userValidation) {
        this.userGateway = userGateway;
        this.createWalletUseCase = createWalletUseCase;
        this.userValidation = userValidation;
    }

    @Override
    public User create(User user) throws Throwable {
        this.userValidation.checkOwnerFieldsToCreate(user);
        Wallet wallet = this.createWalletUseCase.create(user.getWallet());
        user.setWallet(wallet);
        return this.userGateway.create(user);
    }
}
