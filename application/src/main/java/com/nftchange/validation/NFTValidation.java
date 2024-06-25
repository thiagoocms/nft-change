package com.nftchange.validation;


import com.nftchange.domain.NFT;
import com.nftchange.exception.BadRequestException;
import com.nftchange.exception.ResourceNotFoundException;
import com.nftchange.gateway.NFTGateway;

import java.util.Objects;
import java.util.UUID;

public class NFTValidation {

    private final NFTGateway nftGateway;

    public NFTValidation(NFTGateway nftGateway) {
        this.nftGateway = nftGateway;
    }

    public void checkOwnerFieldsToCreate(NFT nft) {
        nft.setTokenId(null);
    }

    public NFT checkUpdateConsistence(UUID id, NFT toUpdateEntity) {

        if (Objects.isNull(id) || Objects.isNull(toUpdateEntity.getTokenId())) {
            throw new BadRequestException("400");
        }

        if (id.compareTo(toUpdateEntity.getTokenId()) != 0) {
            throw new BadRequestException("400");
        }
        NFT persistedEntity = checkExistNft(id);

        persistedEntity.from(toUpdateEntity);

        return persistedEntity;
    }

    public NFT checkExistNft(UUID id) {

        NFT nft = nftGateway.findById(id);
        if (Objects.isNull(nft)) {
            throw new ResourceNotFoundException("NFT não encontrado.");
        }

        return nft;
    }
}