package com.nftchange.usecaseimpl.nft;

import com.nftchange.domain.NFT;
import com.nftchange.gateway.NFTGateway;
import com.nftchange.nft.UpdateNFTByIdUseCase;
import com.nftchange.validation.NFTValidation;

import java.util.UUID;

public class UpdateNFTByIdUseCaseImpl implements UpdateNFTByIdUseCase {

    private final NFTGateway nftGateway;
    private final NFTValidation nftValidation;

    public UpdateNFTByIdUseCaseImpl(NFTGateway nftGateway, NFTValidation nftValidation) {
        this.nftGateway = nftGateway;
        this.nftValidation = nftValidation;
    }


    @Override
    public NFT updateById(UUID id, NFT nft) {
        nft = this.nftValidation.checkUpdateConsistence(id, nft);
        return this.nftGateway.update(nft);
    }
}
