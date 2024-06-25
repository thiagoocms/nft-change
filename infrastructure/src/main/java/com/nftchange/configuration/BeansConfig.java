package com.nftchange.configuration;

import com.nftchange.gateway.EmailSendGateway;
import com.nftchange.gateway.UserGateway;
import com.nftchange.gateway.WalletGateway;
import com.nftchange.usecaseimpl.user.*;
import com.nftchange.usecaseimpl.wallet.CreateWalletUseCaseImpl;
import com.nftchange.user.*;
import com.nftchange.validation.UserValidation;
import com.nftchange.wallet.CreateWalletUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway, CreateWalletUseCase createWalletUseCase, UserValidation userValidation, EmailSendGateway emailSendGateway) {
        return new CreateUserUseCaseImpl(userGateway, createWalletUseCase, userValidation, emailSendGateway);
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

    @Bean
    public IsActiveUserUseCase isActiveUserUseCase(UserGateway userGateway) {
        return new IsActiveUserUseCaseImpl(userGateway);
    }
}
