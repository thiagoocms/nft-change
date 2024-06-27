package com.nftchange.persistence.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_users")
public class UserEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", nullable = false)
    private WalletEntity wallet;

    @Column(name = "login", length = 50, nullable = false)
    private String login;

    @Column(name = "password", length = 25, nullable = false)
    private String password;

    @Column(name = "pin_code", length = 4)
    private String pinCode;

    @Column(name = "active", nullable = false)
    private boolean active;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email, WalletEntity wallet, String login, String password, String pinCode, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.wallet = wallet;
        this.login = login;
        this.password = password;
        this.pinCode = pinCode;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public WalletEntity getWallet() {
        return wallet;
    }

    public void setWallet(WalletEntity wallet) {
        this.wallet = wallet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
