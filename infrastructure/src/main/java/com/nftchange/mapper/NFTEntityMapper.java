package com.nftchange.mapper;


import com.nftchange.domain.NFT;
import com.nftchange.persistence.entity.NFTEntity;

import java.util.UUID;

public class NFTEntityMapper {

    public static NFT toDomain(NFTEntity nftEntity) {
        if (nftEntity == null) {
            return null;
        }
        NFT nft = new NFT();
        nft.setTokenId(UUID.fromString(nftEntity.getTokenId()));
        nft.setDescribe(nftEntity.getDescribe());
        nft.setImageUrl(nftEntity.getImageUrl());
        nft.setPrice(nftEntity.getPrice());
        nft.setCreatedBy(nftEntity.getCreatedBy());
        nft.setCreatedDate(nftEntity.getCreatedDate());
        nft.setLastModifiedBy(nftEntity.getLastModifiedBy());
        nft.setLastModifiedDate(nftEntity.getLastModifiedDate());
        nft.setDeleted(nftEntity.isDeleted());
        return nft;
    }

    public static NFTEntity toEntity(NFT nft) {
        if (nft == null) {
            return null;
        }
        NFTEntity nftEntity = new NFTEntity();
        nftEntity.setTokenId(nft.getTokenId() != null ? nft.getTokenId().toString() : null);
        nftEntity.setDescribe(nftEntity.getDescribe());
        nftEntity.setImageUrl(nftEntity.getImageUrl());
        nftEntity.setPrice(nftEntity.getPrice());
        nftEntity.setCreatedBy(nft.getCreatedBy());
        nftEntity.setCreatedDate(nft.getCreatedDate());
        nftEntity.setLastModifiedBy(nft.getLastModifiedBy());
        nftEntity.setLastModifiedDate(nft.getLastModifiedDate());
        nftEntity.setDeleted(nft.isDeleted());
        return nftEntity;
    }
}
