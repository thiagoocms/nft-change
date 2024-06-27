package com.nftchange.gateway;

import com.nftchange.client.AuthorizerClient;
import com.nftchange.dto.AuthorizationDTO;
import com.nftchange.enums.AuthorizationStatusEnum;
import com.nftchange.enums.TransactionsStatusEnum;
import com.nftchange.handler.WebSocketHandler;
import com.nftchange.persistence.entity.NFTEntity;
import com.nftchange.persistence.entity.TransactionsEntity;
import com.nftchange.persistence.entity.UserEntity;
import com.nftchange.persistence.repository.NFTRepository;
import com.nftchange.persistence.repository.TransactionsRepository;
import com.nftchange.persistence.repository.UserRepository;
import com.nftchange.util.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class CreateTransactionsGatewayImpl implements CreateTransactionsGateway {

    private final NFTRepository nftRepository;
    private final UserRepository userRepository;
    private final TransactionsRepository transactionsRepository;
    private final AuthorizerClient authorizerClient;
    private final WebSocketHandler webSocketHandler;

    @Autowired
    public CreateTransactionsGatewayImpl(NFTRepository nftRepository, UserRepository userRepository, TransactionsRepository transactionsRepository, AuthorizerClient authorizerClient, WebSocketHandler webSocketHandler) {
        this.nftRepository = nftRepository;
        this.userRepository = userRepository;
        this.transactionsRepository = transactionsRepository;
        this.authorizerClient = authorizerClient;
        this.webSocketHandler = webSocketHandler;
    }

    @Async
    @Transactional
    @Override
    public void create(UUID nftTokenId, Long sellerId, Long buyerId, BigDecimal price) throws ExecutionException, InterruptedException {
        NFTEntity nft = this.nftRepository.findFirstByTokenIdAndDeletedIsFalse(nftTokenId.toString());
        UserEntity seller = this.userRepository.findFirstByIdAndDeletedIsFalse(sellerId);
        UserEntity buyer = this.userRepository.findFirstByIdAndDeletedIsFalse(buyerId);
        TransactionsEntity transactions = new TransactionsEntity();
        transactions.setBuyer(buyer);
        transactions.setNft(nft);
        transactions.setSeller(seller);
        transactions.setPrice(price);
        transactions.setStatus(TransactionsStatusEnum.PENDING);
        transactions.setCreatedBy(buyer.getLogin());
        transactions.setCreatedDate(LocalDateTime.now());
        this.transactionsRepository.save(transactions);
        checkAuthorization(transactions);
        if (transactions.getStatus().equals(TransactionsStatusEnum.APPROVED)) {
            seller.getWallet().setBalance(seller.getWallet().getBalance().add(price));
            buyer.getWallet().setBalance(buyer.getWallet().getBalance().subtract(price));
            nft.setUser(buyer);
            this.userRepository.save(seller);
            this.userRepository.save(buyer);
            this.nftRepository.save(nft);
        }
        this.transactionsRepository.save(transactions);
        try {
            this.webSocketHandler.sendMessageToChannel(nftTokenId.toString() + buyerId, transactions.getStatus().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkAuthorization(TransactionsEntity transactions) throws ExecutionException, InterruptedException {
        TransactionsStatusEnum transactionsStatusEnum = TransactionsStatusEnum.PENDING;

        try {
            CompletableFuture<ResponseEntity<AuthorizationDTO>> completableFuture = CompletableFuture.supplyAsync(this.authorizerClient::checkAuthorization);
            ResponseEntity<AuthorizationDTO> response = completableFuture.get();
            if (response.hasBody()) {
                AuthorizationDTO authorizationDTO = response.getBody();
                if (authorizationDTO != null &&
                        authorizationDTO.getStatus().equals(AuthorizationStatusEnum.success)) {
                    transactionsStatusEnum = TransactionsStatusEnum.APPROVED;
                }
            }
        }catch (Exception e) {
            transactionsStatusEnum = TransactionsStatusEnum.CANCELED;
        }
        transactions.setStatus(transactionsStatusEnum);
    }
}
