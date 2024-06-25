package com.nftchange.usecaseimpl.user;

import com.nftchange.domain.User;
import com.nftchange.exception.BadRequestException;
import com.nftchange.exception.ResourceNotFoundException;
import com.nftchange.gateway.UserGateway;
import com.nftchange.user.ActiveUserUseCase;
import com.nftchange.user.IsActiveUserUseCase;

import java.util.Objects;

public class ActiveUserUseCaseImpl implements ActiveUserUseCase {

    private final UserGateway userGateway;

    public ActiveUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void active(String login, String pinCode) {
        User user = this.userGateway.findByLogin(login);
        if (user == null) {
            throw new ResourceNotFoundException("Usuário não encontrado.");
        }
        if (Objects.nonNull(user.getPinCode()) && !user.getPinCode().equals(pinCode)){
            throw new BadRequestException("Codigo incorreto");
        }
        user.setActive(true);
        user.setPinCode(null);
        userGateway.update(user);
    }
}
