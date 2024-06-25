package com.nftchange.usecaseimpl.user;

import com.nftchange.domain.User;
import com.nftchange.gateway.UserGateway;
import com.nftchange.user.DeleteUserByIdUseCase;
import com.nftchange.validation.UserValidation;

public class DeleteUserByIdUseCaseImpl implements DeleteUserByIdUseCase {

    private final UserGateway userGateway;
    private final UserValidation userValidation;

    public DeleteUserByIdUseCaseImpl(UserGateway userGateway, UserValidation userValidation) {
        this.userGateway = userGateway;
        this.userValidation = userValidation;
    }

    @Override
    public void deleteById(Long id) {
        User user = this.userValidation.checkExistUser(id);
        this.userGateway.deleteById(user.getId());
    }
}
