package com.nftchange.dto;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private WalletDTO wallet;
    private String login;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, WalletDTO wallet, String login) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.wallet = wallet;
        this.login = login;
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

    public WalletDTO getWallet() {
        return wallet;
    }

    public void setWallet(WalletDTO wallet) {
        this.wallet = wallet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
