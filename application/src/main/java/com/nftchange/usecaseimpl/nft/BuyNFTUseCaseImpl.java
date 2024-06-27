package com.nftchange.usecaseimpl.nft;

import com.nftchange.domain.NFT;
import com.nftchange.domain.User;
import com.nftchange.enums.NFTTypeEnum;
import com.nftchange.exception.BadRequestException;
import com.nftchange.gateway.CreateTransactionsGateway;
import com.nftchange.nft.BuyNFTUseCase;
import com.nftchange.validation.NFTValidation;
import com.nftchange.validation.UserValidation;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class BuyNFTUseCaseImpl implements BuyNFTUseCase {

    private final NFTValidation nftValidation;
    private final UserValidation userValidation;
    private final CreateTransactionsGateway createTransactionsGateway;

    public BuyNFTUseCaseImpl(NFTValidation nftValidation, UserValidation userValidation, CreateTransactionsGateway createTransactionsGateway) {
        this.nftValidation = nftValidation;
        this.userValidation = userValidation;
        this.createTransactionsGateway = createTransactionsGateway;
    }

    @Override
    public void buy(UUID tokenId, Long buyerId) throws ExecutionException, InterruptedException {
        NFT nft = this.nftValidation.checkExistNft(tokenId);
        User buyer = this.userValidation.checkExistUser(buyerId);
        User seller = nft.getUser();
        if (seller != null) {
            if (seller.getId().equals(buyerId)) {
                throw new BadRequestException("O NFT ja é seu.");
            }
            if (buyer.getWallet().getBalance().compareTo(nft.getPrice()) < 0) {
                throw new BadRequestException("Saldo insuficiente.");
            }
            this.createTransactionsGateway.create(tokenId, seller.getId(), buyerId, nft.getPrice());
        }
    }
}
