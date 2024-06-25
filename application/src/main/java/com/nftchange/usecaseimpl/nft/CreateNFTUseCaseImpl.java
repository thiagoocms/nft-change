package com.nftchange.usecaseimpl.nft;

import com.nftchange.domain.NFT;
import com.nftchange.gateway.NFTGateway;
import com.nftchange.nft.CreateNFTUseCase;
import com.nftchange.validation.NFTValidation;

public class CreateNFTUseCaseImpl implements CreateNFTUseCase {

    private final NFTGateway nftGateway;
    private final NFTValidation nftValidation;

    public CreateNFTUseCaseImpl(NFTGateway nftGateway, NFTValidation nftValidation) {
        this.nftGateway = nftGateway;
        this.nftValidation = nftValidation;
    }

    @Override
    public NFT create(NFT nft) {
        this.nftValidation.checkOwnerFieldsToCreate(nft);
        return this.nftGateway.create(nft);
    }
}
