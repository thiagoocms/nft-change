package com.nftchange.user;

import com.nftchange.domain.User;

public interface CreateUserUseCase {
    User create(User user) throws Throwable;
}
