package com.nftchange.user;

import java.math.BigDecimal;

public interface AddBalanceByUserUseCase {
    void add(Long userId, BigDecimal value);
}
