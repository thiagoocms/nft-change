package com.nftchange.usecaseimpl.user;

import com.nftchange.domain.User;
import com.nftchange.exception.BadRequestException;
import com.nftchange.gateway.UserGateway;
import com.nftchange.user.IsActiveUserUseCase;

public class IsActiveUserUseCaseImpl implements IsActiveUserUseCase {

    private final UserGateway userGateway;

    public IsActiveUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void isActive(String login) {
        User user = this.userGateway.findByLogin(login);
        if (user == null) {
            throw new BadRequestException("Usuário não encontrado.");
        }
        if (user.isActive()) {
            return;
        }
        throw new BadRequestException("O usuário " + user.getLogin() + " ainda não foi ativo.");
    }
}
