package com.nftchange.nft;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public interface BuyNFTUseCase {
    void buy(UUID tokenId, Long userId) throws ExecutionException, InterruptedException;
}
