package com.nftchange.persistence.entity;

import com.nftchange.enums.TransactionsStatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_transactions")
public class TransactionsEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", nullable = false)
    private UserEntity seller;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id", nullable = false)
    private UserEntity buyer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nft_token_id", nullable = false)
    private NFTEntity nft;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionsStatusEnum status;

    public TransactionsEntity() {
    }

    public TransactionsEntity(Long id, UserEntity seller, UserEntity buyer, NFTEntity nft, BigDecimal price, TransactionsStatusEnum status) {
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

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    public UserEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(UserEntity buyer) {
        this.buyer = buyer;
    }

    public NFTEntity getNft() {
        return nft;
    }

    public void setNft(NFTEntity nft) {
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
