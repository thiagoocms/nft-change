package com.nftchange.dto;

public class BuyNFTDTO {

    private String tokenId;
    private Long buyerId;

    public BuyNFTDTO() {
    }

    public BuyNFTDTO(String tokenId, Long buyerId) {
        this.tokenId = tokenId;
        this.buyerId = buyerId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}
