package com.nftchange.usecaseimpl.user;

import com.nftchange.domain.User;
import com.nftchange.user.FindUserByIdUseCase;
import com.nftchange.validation.UserValidation;

public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase {

    private final UserValidation userValidation;

    public FindUserByIdUseCaseImpl(UserValidation userValidation) {
        this.userValidation = userValidation;
    }

    @Override
    public User findById(Long id) {
        return this.userValidation.checkExistUser(id);
    }
}
