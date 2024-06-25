package com.nftchange.user;

import com.nftchange.domain.User;

public interface UpdateUserByIdUseCase {
    User updateById(Long id, User user) throws Throwable;
}
