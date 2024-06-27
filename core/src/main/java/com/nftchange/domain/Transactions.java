package com.nftchange.domain;

import com.nftchange.enums.TransactionsStatusEnum;

import java.math.BigDecimal;

public class Transactions extends AbstractAuditing {
    private Long id;
    private User seller;
    private User buyer;
    private NFT nft;
    private BigDecimal price;
    private TransactionsStatusEnum status;

    public Transactions() {
    }

    public Transactions(Long id, User seller, User buyer, NFT nft, BigDecimal price, TransactionsStatusEnum status) {
        this.id = id;
        this.seller = seller;
        this.buyer = buyer;
        this.nft = nft;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public NFT getNft() {
        return nft;
    }

    public void setNft(NFT nft) {
        this.nft = nft;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransactionsStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionsStatusEnum status) {
        this.status = status;
    }
}
