package com.nftchange.nft;

import com.nftchange.domain.NFT;
import java.util.UUID;

public interface FindNFTByIdUseCase {
    NFT findById(UUID tokenId);
}
