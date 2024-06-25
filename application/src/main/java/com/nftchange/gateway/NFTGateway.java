package com.nftchange.gateway;

import com.nftchange.domain.NFT;

import java.util.List;
import java.util.UUID;

public interface NFTGateway {
    NFT create(NFT nft);
    NFT findById(UUID tokenId);
    NFT update(NFT nft);
    void deleteById(UUID tokenId);
    List<NFT> findAllByTitle(String title);
}
