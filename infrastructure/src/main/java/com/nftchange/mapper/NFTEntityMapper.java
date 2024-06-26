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
        nft.setTitle(nftEntity.getTitle());
        nft.setDescribe(nftEntity.getDescribe());
        nft.setImageUrl(nftEntity.getImageUrl());
        nft.setPrice(nftEntity.getPrice());
        nft.setUser(UserEntityMapper.toDomain(nftEntity.getUser()));
        nft.setLimit(nftEntity.getLimit());
        nft.setType(nftEntity.getType());
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
        nftEntity.setTitle(nft.getTitle());
        nftEntity.setDescribe(nft.getDescribe());
        nftEntity.setImageUrl(nft.getImageUrl());
        nftEntity.setPrice(nft.getPrice());
        nftEntity.setUser(UserEntityMapper.toEntity(nft.getUser()));
        nftEntity.setLimit(nft.getLimit());
        nftEntity.setType(nft.getType());
        nftEntity.setCreatedBy(nft.getCreatedBy());
        nftEntity.setCreatedDate(nft.getCreatedDate());
        nftEntity.setLastModifiedBy(nft.getLastModifiedBy());
        nftEntity.setLastModifiedDate(nft.getLastModifiedDate());
        nftEntity.setDeleted(nft.isDeleted());
        return nftEntity;
    }
}
