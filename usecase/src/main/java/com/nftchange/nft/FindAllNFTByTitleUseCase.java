package com.nftchange.nft;

import com.nftchange.domain.NFT;

import java.util.List;

public interface FindAllNFTByTitleUseCase {
    List<NFT> findAll(String title);
}
