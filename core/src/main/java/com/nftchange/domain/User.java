package com.nftchange.domain;

public class User extends AbstractAuditing {
    private Long id;
    private String name;
    private String email;
    private Wallet wallet;
    private String login;
    private String password;
    private String pinCode;
    private boolean active;

    public User() {
    }

    public User(Long id, String name, String email, Wallet wallet, String login, String password, String pinCode, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.wallet = wallet;
        this.login = login;
        this.password = password;
        this.pinCode = pinCode;
        this.active = active;
    }

    public void from(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.wallet = user.getWallet();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.pinCode = user.getPinCode();
        this.active = user.isActive();
        this.setCreatedBy(user.getCreatedBy());
        this.setCreatedDate(user.getCreatedDate());
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
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
