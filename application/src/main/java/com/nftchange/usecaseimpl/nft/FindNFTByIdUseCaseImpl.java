package com.nftchange.usecaseimpl.nft;

import com.nftchange.domain.NFT;
import com.nftchange.nft.FindNFTByIdUseCase;
import com.nftchange.validation.NFTValidation;

import java.util.UUID;

public class FindNFTByIdUseCaseImpl implements FindNFTByIdUseCase {

    private final NFTValidation nftValidation;

    public FindNFTByIdUseCaseImpl(NFTValidation nftValidation) {
        this.nftValidation = nftValidation;
    }

    @Override
    public NFT findById(UUID id) {
        return this.nftValidation.checkExistNft(id);
    }
}
