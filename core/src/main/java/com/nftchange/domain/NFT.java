package com.nftchange.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class NFT extends AbstractAuditing {
    private UUID tokenId;
    private String title;
    private String describe;
    private String imageUrl;
    private BigDecimal price;

    public NFT() {
    }

    public NFT(UUID tokenId, String title, String describe, String imageUrl, BigDecimal price) {
        this.tokenId = tokenId;
        this.title = title;
        this.describe = describe;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public void from(NFT nft) {
        this.title = nft.getTitle() != null ? nft.getTitle() : this.title;
        this.describe = nft.getDescribe() != null ? nft.getDescribe() : this.describe;
        this.imageUrl = nft.getImageUrl() != null ? nft.getImageUrl() : this.imageUrl;
        this.price = nft.getPrice() != null ? nft.getPrice() : this.price;
    }

    public UUID getTokenId() {
        return tokenId;
    }

    public void setTokenId(UUID tokenId) {
        this.tokenId = tokenId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
