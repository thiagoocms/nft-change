package com.nftchange.domain;

import com.nftchange.enums.NFTTypeEnum;
import com.nftchange.exception.BadRequestException;

import java.math.BigDecimal;
import java.util.UUID;

public class NFT extends AbstractAuditing {
    private UUID tokenId;
    private String title;
    private String describe;
    private String imageUrl;
    private BigDecimal price;
    private User user;
    private Integer limit;
    private NFTTypeEnum type;

    public NFT() {
    }

    public NFT(UUID tokenId, String title, String describe, String imageUrl, BigDecimal price, User user, Integer limit, NFTTypeEnum type) {
        this.tokenId = tokenId;
        this.title = title;
        this.describe = describe;
        this.imageUrl = imageUrl;
        this.price = price;
        this.user = user;
        this.limit = limit;
        this.type = type;
    }

    public void from(NFT nft) {
        this.title = nft.getTitle() != null ? nft.getTitle() : this.title;
        this.describe = nft.getDescribe() != null ? nft.getDescribe() : this.describe;
        this.imageUrl = nft.getImageUrl() != null ? nft.getImageUrl() : this.imageUrl;
        this.price = nft.getPrice() != null ? nft.getPrice() : this.price;
        this.user = nft.getUser() != null ? nft.getUser() : this.getUser();
        this.limit = nft.getLimit() != null ? nft.getLimit() : this.limit;
        this.type = nft.getType() != null ? nft.getType() : this.type;
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
        if (title == null) {
            throw new BadRequestException("O campo titulo é obrigatorio.");
        }
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        if (describe == null) {
            throw new BadRequestException("O campo descrição é obrigatorio.");
        }
        this.describe = describe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        if (imageUrl == null) {
            throw new BadRequestException("O campo url da imagem é obrigatorio.");
        }
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price == null) {
           price = BigDecimal.ZERO;
        }
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public NFTTypeEnum getType() {
        return type;
    }

    public void setType(NFTTypeEnum type) {
        this.type = type;
    }
}
