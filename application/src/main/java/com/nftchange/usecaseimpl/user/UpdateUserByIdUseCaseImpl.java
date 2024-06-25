package com.nftchange.usecaseimpl.user;

import com.nftchange.domain.User;
import com.nftchange.gateway.UserGateway;
import com.nftchange.user.UpdateUserByIdUseCase;
import com.nftchange.validation.UserValidation;

public class UpdateUserByIdUseCaseImpl implements UpdateUserByIdUseCase {

    private final UserGateway userGateway;
    private final UserValidation userValidation;

    public UpdateUserByIdUseCaseImpl(UserGateway userGateway, UserValidation userValidation) {
        this.userGateway = userGateway;
        this.userValidation = userValidation;
    }

    @Override
    public User updateById(Long id, User user) throws Throwable {
        this.userValidation.checkUpdateConsistence(id, user);
        return this.userGateway.update(user);
    }
}
