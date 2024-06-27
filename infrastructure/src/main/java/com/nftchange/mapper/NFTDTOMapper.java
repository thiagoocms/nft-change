package com.nftchange.mapper;


import com.nftchange.domain.NFT;
import com.nftchange.dto.NFTDTO;

import java.util.UUID;

public class NFTDTOMapper {

    public static NFT toDomain(NFTDTO nftdto) {
        if (nftdto == null) {
            return null;
        }
        NFT nft = new NFT();
        nft.setTokenId(nftdto.getTokenId());
        nft.setTitle(nftdto.getTitle());
        nft.setDescribe(nftdto.getDescribe());
        nft.setImageUrl(nftdto.getImageUrl());
        nft.setPrice(nftdto.getPrice());
        return nft;
    }

    public static NFTDTO toDto(NFT nft) {
        if (nft == null) {
            return null;
        }
        NFTDTO nftdto = new NFTDTO();
        nftdto.setTokenId(nft.getTokenId());
        nftdto.setTitle(nft.getTitle());
        nftdto.setDescribe(nft.getDescribe());
        nftdto.setImageUrl(nft.getImageUrl());
        nftdto.setPrice(nft.getPrice());
        return nftdto;
    }
}
