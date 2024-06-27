package com.nftchange.dto;

import java.math.BigDecimal;

public class UserAddBalanceDTO {
    private Long userId;
    private BigDecimal value;

    public UserAddBalanceDTO() {
    }

    public UserAddBalanceDTO(Long userId, BigDecimal value) {
        this.userId = userId;
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
