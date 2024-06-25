package com.nftchange.nft;


import com.nftchange.domain.NFT;
import java.util.UUID;

public interface UpdateNFTByIdUseCase {
    NFT updateById(UUID tokenId, NFT nft);
}
