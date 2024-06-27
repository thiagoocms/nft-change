package com.nftchange.gateway;


import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public interface CreateTransactionsGateway {
    void create(UUID nftTokenId, Long sellerId, Long buyerId, BigDecimal price) throws ExecutionException, InterruptedException;
}
