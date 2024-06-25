package com.nftchange.user;

import com.nftchange.domain.User;

public interface FindUserByIdUseCase {
    User findById(Long id);
}
