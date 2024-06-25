package com.nftchange.configuration;

import com.nftchange.gateway.UserGateway;
import com.nftchange.gateway.WalletGateway;
import com.nftchange.usecaseimpl.user.CreateUserUseCaseImpl;
import com.nftchange.usecaseimpl.user.DeleteUserByIdUseCaseImpl;
import com.nftchange.usecaseimpl.user.FindUserByIdUseCaseImpl;
import com.nftchange.usecaseimpl.user.UpdateUserByIdUseCaseImpl;
import com.nftchange.usecaseimpl.wallet.CreateWalletUseCaseImpl;
import com.nftchange.user.CreateUserUseCase;
import com.nftchange.user.DeleteUserByIdUseCase;
import com.nftchange.user.FindUserByIdUseCase;
import com.nftchange.user.UpdateUserByIdUseCase;
import com.nftchange.validation.UserValidation;
import com.nftchange.wallet.CreateWalletUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway, CreateWalletUseCase createWalletUseCase, UserValidation userValidation) {
        return new CreateUserUseCaseImpl(userGateway, createWalletUseCase, userValidation);
    }

    @Bean
    public UserValidation userValidation(UserGateway userGateway) {
        return new UserValidation(userGateway);
    }

    @Bean
    public CreateWalletUseCase createWalletUseCase(WalletGateway walletGateway) {
        return new CreateWalletUseCaseImpl(walletGateway);
    }

    @Bean
    public UpdateUserByIdUseCase updateUserByIdUseCase(UserGateway userGateway, UserValidation userValidation) {
        return new UpdateUserByIdUseCaseImpl(userGateway, userValidation);
    }

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(UserValidation userValidation) {
        return new FindUserByIdUseCaseImpl(userValidation);
    }

    @Bean
    public DeleteUserByIdUseCase deleteUserByIdUseCase(UserGateway userGateway, UserValidation userValidation) {
        return new DeleteUserByIdUseCaseImpl(userGateway, userValidation);
    }
}
