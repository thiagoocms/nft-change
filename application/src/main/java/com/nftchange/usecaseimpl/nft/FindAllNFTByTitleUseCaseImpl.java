package com.nftchange.usecaseimpl.nft;

import com.nftchange.domain.NFT;
import com.nftchange.gateway.NFTGateway;
import com.nftchange.nft.FindAllNFTByTitleUseCase;
import com.nftchange.nft.FindNFTByIdUseCase;
import com.nftchange.validation.NFTValidation;

import java.util.List;
import java.util.UUID;

public class FindAllNFTByTitleUseCaseImpl implements FindAllNFTByTitleUseCase {

    private final NFTGateway nftGateway;

    public FindAllNFTByTitleUseCaseImpl(NFTGateway nftGateway) {
        this.nftGateway = nftGateway;
    }

    @Override
    public List<NFT> findAll(String title) {
        return nftGateway.findAllByTitle(title);
    }
}
