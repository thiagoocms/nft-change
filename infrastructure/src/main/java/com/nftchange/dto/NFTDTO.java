package com.nftchange.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class NFTDTO {

    private UUID tokenId;
    private String title;
    private String describe;
    private String imageUrl;
    private BigDecimal price;
    private UserDTO user;
    private Integer limit;
    private String type;

    public NFTDTO() {
    }

    public NFTDTO(UUID tokenId, String title, String describe, String imageUrl, BigDecimal price, UserDTO user, Integer limit, String type) {
        this.tokenId = tokenId;
        this.title = title;
        this.describe = describe;
        this.imageUrl = imageUrl;
        this.price = price;
        this.user = user;
        this.limit = limit;
        this.type = type;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
