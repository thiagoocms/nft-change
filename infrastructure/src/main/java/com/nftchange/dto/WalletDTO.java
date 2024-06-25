package com.nftchange.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletDTO {
    private UUID id;
    private BigDecimal balance;

    public WalletDTO() {
    }

    public WalletDTO(UUID id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
