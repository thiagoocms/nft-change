package com.nftchange.usecaseimpl.nft;

import com.nftchange.domain.NFT;
import com.nftchange.domain.User;
import com.nftchange.gateway.NFTGateway;
import com.nftchange.gateway.UserGateway;
import com.nftchange.nft.DeleteNFTByIdUseCase;
import com.nftchange.user.DeleteUserByIdUseCase;
import com.nftchange.validation.NFTValidation;
import com.nftchange.validation.UserValidation;

import java.util.UUID;

public class DeleteNFTByIdUseCaseImpl implements DeleteNFTByIdUseCase {

    private final NFTGateway nftGateway;
    private final NFTValidation nftValidation;

    public DeleteNFTByIdUseCaseImpl(NFTGateway nftGateway, NFTValidation nftValidation) {
        this.nftGateway = nftGateway;
        this.nftValidation = nftValidation;
    }

    @Override
    public void deleteById(UUID id) {
        NFT nft = this.nftValidation.checkExistNft(id);
        this.nftGateway.deleteById(nft.getTokenId());
    }
}
