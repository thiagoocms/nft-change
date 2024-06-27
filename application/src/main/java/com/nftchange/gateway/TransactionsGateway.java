package com.nftchange.gateway;


import com.nftchange.domain.Transactions;
import com.nftchange.enums.TransactionsStatusEnum;

public interface TransactionsGateway {
    Transactions create(Transactions transactions);
    Transactions findById(Long id);
    void updateStatusById(Long id, TransactionsStatusEnum status);
    void deleteById(Long id);
}
