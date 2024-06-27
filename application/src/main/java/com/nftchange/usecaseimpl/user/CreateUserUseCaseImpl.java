package com.nftchange.usecaseimpl.user;

import com.nftchange.domain.User;
import com.nftchange.domain.Wallet;
import com.nftchange.gateway.EmailSendGateway;
import com.nftchange.gateway.UserGateway;
import com.nftchange.user.CreateUserUseCase;
import com.nftchange.validation.UserValidation;
import com.nftchange.wallet.CreateWalletUseCase;

import java.math.BigDecimal;
import java.util.Random;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGateway userGateway;

    private final UserValidation userValidation;
    private final EmailSendGateway emailSendGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway, UserValidation userValidation, EmailSendGateway emailSendGateway) {
        this.userGateway = userGateway;
        this.userValidation = userValidation;
        this.emailSendGateway = emailSendGateway;
    }

    @Override
    public User create(User user) throws Throwable {
        this.userValidation.checkOwnerFieldsToCreate(user);
        this.userValidation.checkExistByEmail(user);
        this.userValidation.checkExistByLogin(user);
        user.setWallet(new Wallet(null, BigDecimal.ZERO));
        this.generatePinCode(user);
        user = this.userGateway.create(user);
        this.sendEmail(user);
        return this.userGateway.create(user);
    }

    private void generatePinCode(User user) {
        Random random = new Random();
        int pin = 1000 + random.nextInt(9000);
        user.setPinCode(String.valueOf(pin));
    }

    private void sendEmail(User user) {
        String subject = "Seja muito bem-vindo!";
        String msg = "Ola " + user.getName() + ", seja bem vindo ao NFT change! Aqui estar o codigo de ativação da sua conta: " + user.getPinCode();
        emailSendGateway.sendEmailText(user.getEmail(), subject, msg);
    }
}
