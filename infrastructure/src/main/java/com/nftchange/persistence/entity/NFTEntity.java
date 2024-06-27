package com.nftchange.persistence.entity;

import com.nftchange.domain.User;
import com.nftchange.enums.NFTTypeEnum;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity user;

    @Column(name = "\"limit\"", nullable = true)
    private Integer limit;

    @Enumerated(EnumType.STRING)
    @Column(name = "\"type\"", nullable = false)
    private NFTTypeEnum type;

    public NFTEntity() {
    }

    public NFTEntity(String tokenId, String title, String describe, String imageUrl, BigDecimal price, UserEntity user, Integer limit, NFTTypeEnum type) {
        this.tokenId = tokenId;
        this.title = title;
        this.describe = describe;
        this.imageUrl = imageUrl;
        this.price = price;
        this.user = user;
        this.limit = limit;
        this.type = type;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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
