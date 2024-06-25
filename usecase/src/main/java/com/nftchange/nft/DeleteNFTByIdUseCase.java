package com.nftchange.nft;

import java.util.UUID;

public interface DeleteNFTByIdUseCase {
    void deleteById(UUID tokenId);
}
