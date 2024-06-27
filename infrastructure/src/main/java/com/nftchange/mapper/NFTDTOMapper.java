package com.nftchange.mapper;


import com.nftchange.domain.NFT;
import com.nftchange.domain.User;
import com.nftchange.dto.NFTDTO;
import com.nftchange.enums.NFTTypeEnum;


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
        nft.setUser(nftdto.getUser() != null && nftdto.getUser().getId() != null ? new User(nftdto.getUser().getId()) : null);
        nft.setLimit(nftdto.getLimit());
        nft.setType(NFTTypeEnum.valueOf(nftdto.getType()));
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
        nftdto.setUser(UserDTOMapper.toDto(nft.getUser()));
        nftdto.setLimit(nft.getLimit());
        nftdto.setType(nft.getType().toString());
        return nftdto;
    }
}
