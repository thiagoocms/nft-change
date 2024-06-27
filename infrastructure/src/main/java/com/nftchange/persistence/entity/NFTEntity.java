package com.nftchange.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_nfts")
public class NFTEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String tokenId;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "\"describe\"", length = 300, nullable = false)
    private String describe;

    @Column(name = "image_url", length = 350, nullable = false)
    private String imageUrl;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public NFTEntity() {
    }

    public NFTEntity(String tokenId, String title, String describe, String imageUrl, BigDecimal price) {
        this.tokenId = tokenId;
        this.title = title;
        this.describe = describe;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public void from(NFTEntity nft) {
        this.title = nft.getTitle() != null ? nft.getTitle() : this.title;
        this.describe = nft.getDescribe() != null ? nft.getDescribe() : this.describe;
        this.imageUrl = nft.getImageUrl() != null ? nft.getImageUrl() : this.imageUrl;
        this.price = nft.getPrice() != null ? nft.getPrice() : this.price;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
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
